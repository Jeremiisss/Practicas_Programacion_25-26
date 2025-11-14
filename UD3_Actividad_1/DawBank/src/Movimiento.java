// esto sirve para las fechas
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movimiento {
    // Atributos del Movimiento
    private int id;
    private String fecha;
    private String tipo;    // Sera ingreso o retirada
    private double cantidad;

    //sirve para que cada movimiento tenga un ID unico
    private static int proximoId = 1;

    // Constructor: se ejecuta cuando creamos un nuevo Movimiento
    public Movimiento(String tipo, double cantidad) {
        this.id = proximoId; // Le asignamos el ID que toca
        proximoId++;

        // DateTimeFormatter nos pone el formato de la fecha como queremos
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fecha = LocalDate.now().format(formatoFecha);

        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // este metodo devuelve un texto con toda la informacion del movimiento
    public String mostrarInfoMovimiento() {
        return String.format("ID: %-4d | Fecha: %s | Tipo: %-8s | Cantidad: %.2f €",
                this.id, this.fecha, this.tipo, this.cantidad);
    }
}