import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    // Atributos
    private String codigo;
    private String nombre;
    private String director;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    // Constructor
    public Pelicula(LocalDate fechaRegistro, LocalDate fechaBaja, LocalDateTime fechaAlquiler, boolean isAlquilada) {
        this.fechaRegistro = fechaRegistro;
        this.fechaBaja = fechaBaja;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }

    //Metodos


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDirector() {
        return director;
    }

    public Genero getGenero() {
        return genero;
    }

    public String mostrarInfoPelicula() {
        String infoPelicula = "";
        infoPelicula += "Codigo: " + this.codigo + "\n";
        infoPelicula += "Nombre: " + this.nombre + "\n";
        infoPelicula += "Director: " + this.director + "\n";
        infoPelicula += "Genero: " + this.genero + "\n";
    }
}