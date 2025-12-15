import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String DNI;
    private String direccion;
    private String NumeroContrato;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Persona(String numeroContrato, String direccion, String DNI, LocalDate fechaNacimiento, String nombre) {
        NumeroContrato = numeroContrato;
        this.direccion = direccion;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
