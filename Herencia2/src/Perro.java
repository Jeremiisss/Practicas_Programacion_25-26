import java.time.LocalDate;

public class Perro extends Mascotas {
    private String raza;
    private boolean tienePulgas;

    // constructor
    public Perro(String nombre, LocalDate fechaNacimiento, String raza, boolean tienePulgas) {
        super(nombre, fechaNacimiento);
        this.raza = raza;
        this.tienePulgas = tienePulgas;
    }

    @Override
    public String muestra() {
        return "--- FICHA DE PERRO ---\n" +
                getInfoBase() +
                "Raza: " + this.raza + "\n" +
                "Tiene Pulgas: " + (this.tienePulgas ? "Sí" : "No") + "\n" +
                "----------------------";
    }

    @Override
    public String habla() {
        return "GUAU GUAU";
    }
}
