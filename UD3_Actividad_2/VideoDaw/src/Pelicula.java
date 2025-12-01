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

    private static int proximoCod = 1;

    // Constructor
    public Pelicula(String nombre, String director, Genero genero) {
        this.codigo = String.format("P-%04d", proximoCod++);
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.isAlquilada = false;
        this.fechaBaja = null;
        this.fechaAlquiler = null;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }
    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }
    public boolean isDeBaja() {
        return this.fechaBaja != null;
    }

    //metodos
    public void alquilar() {
        this.isAlquilada = true;
        this.fechaAlquiler = LocalDateTime.now();
    }

    public void devolver() {
        this.isAlquilada = false;
        this.fechaAlquiler = null;
    }

    public void darDeBaja() {
        this.fechaBaja = LocalDate.now();
    }

    // Metodos para mostrar la informacion de la pelicula
    public String mostrarInfoPelicula() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String estado = isAlquilada ? "Alquilada" : "Disponible";
        if (isDeBaja()) {
            estado = "Dada de Baja (" + this.fechaBaja.format(formatoFecha) + ")";
        }
        return String.format("Cód: %s | Nombre: %-25s | Director: %-20s | Género: %-15s | Estado: %s",
                this.codigo, this.nombre, this.director, this.genero, estado);
    }
}