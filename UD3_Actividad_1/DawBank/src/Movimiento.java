// fechas
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {
    // Atributos del Movimiento
    private int id;
    private String fecha;
    private String tipo;    // ingreso o retirada
    private double cantidad;

    //para que cada movimiento tenga un ID unico
    private static int proximoId = 1;

    // Constructor: se ejecuta cuando creamos un nuevo movimiento
    public Movimiento(String tipo, double cantidad) {
        this.id = proximoId; // para asignar el ID
        proximoId++;

        // DateTimeFormatter nos ayuda a ponerla en el formato "dd/MM/yyyy HH:mm:ss"
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fecha = LocalDateTime.now().format(formatoFecha);

        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // nos devuelve toda la informacion del movimiento
    public String mostrarInfoMovimiento() {
        return String.format("ID: %-4d | Fecha: %s | Tipo: %-8s | Cantidad: %.2f €",
                this.id, this.fecha, this.tipo, this.cantidad);
    }
}