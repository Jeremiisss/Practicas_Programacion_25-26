public class cuentaBancaria {
    // Constantes: son valores fijos que no cambian
    private static final int MAX_MOVIMIENTOS = 100;
    private static final double SALDO_MINIMO = -50.0;
    private static final double AVISO_HACIENDA = 3000.0;

    // Atributos de la cuenta
    private String iban;
    private String titular;
    private double saldo;
    private boolean esValida; // sirve para saber si la cuenta ha sido creada correctamente

    // coleccion para guardar los movimientos
    private Movimiento[] movimientos;
    private int nMovimientosActuales;

    // Constructor: se ejecuta cuando creamos una nueva cuenta
    public cuentaBancaria(String iban, String titular) {

        if (iban != null && iban.matches("^[A-Z]{2}\\d{22}$")) {
            this.iban = iban;
            this.esValida = true; // iban valido
        } else {
            this.iban = "IBAN INVÁLIDO";
            this.esValida = false;
        }

        // para que obligue al usuario poner un nombre
        if (titular == null || titular.trim().isEmpty()) {
            this.titular = "TITULAR INVÁLIDO";
            this.esValida = false;
        } else {
            this.titular = titular;
        }

        // inicializar los demas valores
        this.saldo = 0.0;
        this.movimientos = new Movimiento[MAX_MOVIMIENTOS];
        this.nMovimientosActuales = 0;
    }

    // metodos para obtener datos Getters
    public String getIban() { return this.iban; }
    public String getTitular() { return this.titular; }
    public double getSaldo() { return this.saldo; }
    public boolean esValida() { return this.esValida; } // para saber si se ha creado bien

    // ingresar dinero
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            agregarMovimiento("Ingreso", cantidad);

            if (cantidad > AVISO_HACIENDA) {
                System.out.println("💀AVISO: Notificar a hacienda.💀");
            }
        } else {
            System.out.println("❌Error: La cantidad a ingresar debe ser positiva.❌");
        }
    }

    // retirar dinero
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("❌Error: La cantidad a retirar debe ser positiva.❌" +
                    "");
            return;
        }

        // comprobar que la operacion que vamos a hacer nos deja por debajo del permitido
        if ((this.saldo - cantidad) < SALDO_MINIMO) {
            System.out.println("❌Error: Saldo insuficiente para realizar la operación.❌");
        } else {
            this.saldo -= cantidad;
            agregarMovimiento("Retirada", cantidad);

            if (this.saldo < 0) {
                System.out.println("☠️AVISO: Saldo negativo.☠️");
            }
            if (cantidad > AVISO_HACIENDA) {
                System.out.println("💸AVISO: Notificar a hacienda.💸");
            }
        }
    }

    // mostrar historial de movimientos
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

    // metodo para meter un movimiento en un array
    private void agregarMovimiento(String tipo, double cantidad) {
        if (this.nMovimientosActuales < MAX_MOVIMIENTOS) {
            Movimiento nuevoMovimiento = new Movimiento(tipo, cantidad);
            this.movimientos[this.nMovimientosActuales] = nuevoMovimiento;
            this.nMovimientosActuales++;
        } else {
            System.out.println("Aviso: Limite de movimientos alcanzado. La operación no se registrará.");
        }
    }
}