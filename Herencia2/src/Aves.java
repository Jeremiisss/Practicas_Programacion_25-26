import java.time.LocalDate;

public abstract class Aves extends Mascotas {
    private String pico;
    private boolean vuela;

    // constructor
    public Aves(String nombre, LocalDate fechaNacimiento, String pico, boolean vuela) {
        // la palabra super llama a la clase padre para que nos de los datos
        super(nombre, fechaNacimiento);
        this.pico = pico;
        this.vuela = vuela;
    }

    // Getter
    public boolean isVuela() {
        return vuela;
    }

    // metodo abstracto
    public abstract String volar();

    // sobreescribe el metodo para añadir info de aves
    @Override
    public String getInfoBase() {
        return super.getInfoBase() +
                "Tipo de Pico: " + this.pico + "\n" +
                "Puede volar: " + (this.vuela ? "Sí" : "No") + "\n";
    }
}