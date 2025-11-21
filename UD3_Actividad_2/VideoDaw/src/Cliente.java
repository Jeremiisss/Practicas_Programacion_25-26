import java.time.LocalDate;

public class Cliente {

    //Atributos
    private String DNI;
    private String nombre;
    private String NumSocio;
    private String Direccion;
    private LocalDate fechaNacimiento; //debe ser mayor de edad
    private LocalDate fechaBaja;
    private Pelicula peliculasAlquiladas;


    //Constructor
    public Cliente(String DNI, String nombre, String NumSocio, String Direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.NumSocio = NumSocio;
        this.Direccion = Direccion;
        this.fechaNacimiento = LocalDate.now();
        this.fechaBaja = LocalDate.now();
    }
}