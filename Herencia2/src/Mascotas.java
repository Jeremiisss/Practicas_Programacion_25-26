import java.time.LocalDate;
import java.time.Period;

// Clase ABSTRACTA es la plantilla para todas los animales
// datos basicos de todas las mascotas
public abstract class Mascotas {

    private String nombre;
    private int edad;
    private String estado;
    private LocalDate fechaNacimiento;

    // Constructor que usan todas las clases hijas
    public Mascotas(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = "Vivo";
        this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    // metodos Abstractoos
    // Obligan a las clases hijas dar estos datos
    public abstract String muestra();
    public abstract String habla();

    // Metodos de logica
    public String cumpleaños() {
        this.edad++;
        return "¡Feliz cumpleaños " + this.nombre + "! Ahora tienes " + this.edad + " años.";
    }

    public void morir() {
        this.estado = "Muerto";
    }

    // metoodo de informacion de las mascotas
    public String getInfoBase() {
        return "Nombre: " + this.nombre + "\n" +
                "Edad: " + this.edad + "\n" +
                "Estado: " + this.estado + "\n" +
                "Fecha de Nacimiento: " + this.fechaNacimiento + "\n";
    }
}