import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    // Atributos
    private String cod;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean alquilada;

    private static int proximoCod = 1; //contador para asignar ID unicos

    // Constructor
    public Pelicula(String titulo, Genero genero) {
        //generamos el codigo unico formateado ejemplo P-0001
        this.cod = String.format("P-%04d", proximoCod++);
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now(); //guarda la fecha actual
        this.alquilada = false; //cualquier peli nueva no esta alquilada
        this.fechaBaja = null; // null significa que no esta dado de baja
        this.fechaAlquiler = null;
    }

    // Getters para acceder a los datos desde otra clase
    public String getCod()
        { return cod; }

    public String getTitulo()
        { return titulo; }

    public boolean getAlquilada()
        { return alquilada; }

    public LocalDateTime getFechaAlquiler()
        { return fechaAlquiler; }

    public boolean getbaja()
        { return fechaBaja == null; }

    // para cambiar el estado de la pelicula (alquilar,devolver o darDeBaja)
    public void alquilar() {
        this.alquilada = true;
        this.fechaAlquiler = LocalDateTime.now();
    }

    public void devolver() {
        this.alquilada = false;
        this.fechaAlquiler = null;
    }

    public void darDeBaja() {
        this.fechaBaja = LocalDate.now();
    }

    // mostrar toda la info de la peli
    public String mostrarInfoPelicula() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String estado = alquilada ? "Alquilada" : "Disponible";
        if (getbaja()) {
            estado = "Dada de Baja (" + this.fechaBaja.format(formatoFecha) + ")";
        }

        return String.format("Cód: %s | Título: %-25s | Género: %-15s | Estado: %s",
                this.cod, this.titulo, this.genero, estado);
    }
}