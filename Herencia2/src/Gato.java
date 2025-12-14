import java.time.LocalDate;

// La clase Gato es un tipo de mascota
public class Gato extends Mascotas {
    private String color;
    private boolean peloLargo;

    // constructor
    public Gato(String nombre, LocalDate fechaNacimiento, String color, boolean peloLargo) {
        super(nombre, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    @Override
    public String muestra() {
        return "--- FICHA DE GATO ---\n" +
                getInfoBase() +
                "Color: " + this.color + "\n" +
                "Pelo Largo: " + (this.peloLargo ? "Sí" : "No") + "\n" +
                "---------------------";
    }

    @Override
    public String habla() {
        return "MIAU MIAU";
    }
}