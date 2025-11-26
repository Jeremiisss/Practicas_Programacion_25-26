import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Cliente {
    // Atributos
    private String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula[] peliculasAlquiladas;
    private int nPeliculasAlquiladas;

    private static int proximoNumSocio = 1; // Contador para IDs únicos
    private static final int MAX_PELICULAS_ALQUILER = 3;

    // Constructor con validaciones
    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        // vamos a validar el dni que sea 8 numeros y una letra
        if (dni == null || !dni.matches("^\\d{8}[A-Z]$")) {
            System.out.println("Error: Formato de DNI incorrecto.");
            return; // para el objeto
        }
        // validar que es mayor de edad
        if (Period.between(fechaNacimiento, LocalDate.now()).getYears() < 18) {
            System.out.println("Error: El cliente debe ser mayor de edad.");
            return;
        }

        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.numSocio = String.format("S-%04d", proximoNumSocio++);
        this.fechaBaja = null;
        this.peliculasAlquiladas = new Pelicula[MAX_PELICULAS_ALQUILER];
        this.nPeliculasAlquiladas = 0;
    }

    // Getters
    public String getDni() { return dni; }
    public String getNumSocio() { return numSocio; }
    public boolean baja() { return this.fechaBaja != null; }

    // metodos para alquilar y devolver
    public void alquilarPelicula(Pelicula p) {
        if (nPeliculasAlquiladas < MAX_PELICULAS_ALQUILER) {
            peliculasAlquiladas[nPeliculasAlquiladas] = p;
            nPeliculasAlquiladas++;
        }
    }

    public void devolverPelicula(Pelicula p) {
        int indice = -1;
        // buscamos la pelicula en la lista del cliente
        for (int i = 0; i < nPeliculasAlquiladas; i++) {
            if (peliculasAlquiladas[i].getCod().equals(p.getCod())) {
                indice = i;
                break;
            }
        }
        // si la encontramos la eliminamos
        if (indice != -1) {
            for (int i = indice; i < nPeliculasAlquiladas - 1; i++) {
                peliculasAlquiladas[i] = peliculasAlquiladas[i + 1];
            }
            peliculasAlquiladas[nPeliculasAlquiladas - 1] = null;
            nPeliculasAlquiladas--;
        }
    }

    public void darDeBaja() {
        this.fechaBaja = LocalDate.now();
    }

    public String mostrarInfoCliente() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String estado = baja() ? "Dado de Baja (" + this.fechaBaja.format(formatoFecha) + ")" : "Activo";
        return String.format("Nº Socio: %s | DNI: %-10s | Nombre: %-20s | Estado: %s",
                this.numSocio, this.dni, this.nombre, estado);
    }

    public void mostrarPeliculasAlquiladas() {
        System.out.println("--- Películas alquiladas por " + this.nombre + " ---");
        if (nPeliculasAlquiladas == 0) {
            System.out.println("Este cliente no tiene películas alquiladas actualmente.");
        } else {
            for (int i = 0; i < nPeliculasAlquiladas; i++) {
                System.out.println("- " + peliculasAlquiladas[i].getTitulo());
            }
        }
        System.out.println("----------------------------------------------");
    }
}