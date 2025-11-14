public class cuentaBancaria {
    // Constantes: son valores fijos que no cambian
    private static final int MAX_MOVIMIENTOS = 100;
    private static final double SALDO_MINIMO = -50.0;
    private static final double AVISO_HACIENDA = 3000.0;

    // Atributos de la cuenta
    private String iban;
    private String titular;
    private double saldo;
    private boolean esValida; // esto sirve para saber si la cuenta ha sido creada o no

    // Colección para guardar los movimientos
    private Movimiento[] movimientos;
    private int nMovimientosActuales;

    // Constructor
    public cuentaBancaria(String iban, String titular) {
        //esto nos sirve para validar el IBAN
        if (iban != null && iban.matches("^[A-Z]{2}\\d{22}$")) {
            this.iban = iban;
            this.esValida = true; // si el IBAN es correcto la cuenta es valida
        } else {
            this.iban = "IBAN INVÁLIDO";
            this.esValida = false; // Si no, la marcamos como no valida
        }

        // Esto sirve para que el titular sea un campo obligatorio
        if (titular == null || titular.trim().isEmpty()) {
            this.titular = "TITULAR INVÁLIDO";
            this.esValida = false; // si el titular no es valido la cuenta tampoco sera validada
        } else {
            this.titular = titular;
        }

        // aqui inicializamos el resto de valores
        this.saldo = 0.0;
        this.movimientos = new Movimiento[MAX_MOVIMIENTOS];
        this.nMovimientosActuales = 0;
    }

    //Metodos para obtener datos (Getters)
    public String getIban() { return this.iban; }
    public String getTitular() { return this.titular; }
    public double getSaldo() { return this.saldo; }
    public boolean esValida() { return this.esValida; } //para saber que la cuenta ha sido creada

    //realizar ingreso
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            agregarMovimiento("Ingreso", cantidad);

            if (cantidad > AVISO_HACIENDA) {
                System.out.println("AVISO: Notificar a hacienda.");
            }
        } else {
            System.out.println("Error: La cantidad a ingresar debe ser positiva.");
        }
    }

    //realizar una retirada
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser positiva.");
            return;
        }
        //comprobar que la operacion nos dejaria con el saldo por debajo del minimo
        if ((this.saldo - cantidad) < SALDO_MINIMO) {
            System.out.println("Error: Saldo insuficiente para realizar la operación.");
        } else {
            this.saldo -= cantidad;
            agregarMovimiento("Retirada", cantidad);

            if (this.saldo < 0) {
                System.out.println("AVISO: Saldo negativo.");
            }
            if (cantidad > AVISO_HACIENDA) {
                System.out.println("AVISO: Notificar a hacienda.");
            }
        }
    }

    // mostrar por pantalla lod movimientos
    public void mostrarMovimientos() {
        System.out.println("--- Historial de Movimientos ---");
        if (this.nMovimientosActuales == 0) {
            System.out.println("No hay movimientos registrados.");
        } else {
            for (int i = 0; i < this.nMovimientosActuales; i++) {
                System.out.println(this.movimientos[i].mostrarInfoMovimiento());
            }
        }
        System.out.println("---------------------------------");
    }

    // metodo privado para añadir un movimiento al array
    private void agregarMovimiento(String tipo, double cantidad) {
        if (this.nMovimientosActuales < MAX_MOVIMIENTOS) {
            Movimiento nuevoMovimiento = new Movimiento(tipo, cantidad);
            this.movimientos[this.nMovimientosActuales] = nuevoMovimiento;
            this.nMovimientosActuales++;
        } else {
            System.out.println("Aviso: Límite de movimientos alcanzado. La operación no se registrará.");
        }
    }
}