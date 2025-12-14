import java.time.LocalDate;

// La clase Canario es un tipo de Ave.
public class Canario extends Aves {
    private String color;
    private boolean canta;

    //Constructor
    public Canario(String nombre, LocalDate fechaNacimiento, String pico, boolean vuela, String color, boolean canta) {
        super(nombre, fechaNacimiento, pico, vuela);
        this.color = color;
        this.canta = canta;
    }

    @Override
    public String muestra() {
        return "--- FICHA DE CANARIO ---\n" +
                getInfoBase() +
                "Color: " + this.color + "\n" +
                "Canta: " + (this.canta ? "Sí" : "No") + "\n" +
                "------------------------";
    }

    @Override
    public String habla() {
        if (this.canta) {
            return "PIO PIO PIO... (cantando)";
        } else {
            return "PIO PIO";
        }
    }

    @Override
    public String volar() {
        return getNombre() + " está volando ágilmente.";
    }
}