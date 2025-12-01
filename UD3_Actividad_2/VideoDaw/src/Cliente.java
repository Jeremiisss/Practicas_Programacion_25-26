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
    private boolean esValido;

    private static int proximoNumSocio = 1;
    private static final int MAX_PELICULAS_ALQUILER = 3;

    // Constructor
    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        if (validarDNIFormato(dni) && Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18) {
            this.esValido = true;
            this.dni = dni.toUpperCase();
            this.nombre = nombre;
            this.direccion = direccion;
            this.fechaNacimiento = fechaNacimiento;
            this.numSocio = String.format("S-%04d", proximoNumSocio++);
            this.fechaBaja = null;
            this.peliculasAlquiladas = new Pelicula[MAX_PELICULAS_ALQUILER];
            this.nPeliculasAlquiladas = 0;
        } else {
            this.esValido = false;
        }
    }

    // Metodo para validar el DNI
    private static boolean validarDNIFormato(String dni) {
        if (dni == null || dni.length() != 9) return false;
        // Bucle para comprobar los 8 primeros caracteres
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(dni.charAt(i))) return false;
        }
        // para comprobar que el ultimo caracter es una letra
        char letra = dni.charAt(8);
        return Character.isLetter(letra);
    }

    // Getters
    public String getDni() { return dni; }
    public String getNumSocio() { return numSocio; }
    public boolean isDeBaja() { return this.fechaBaja != null; }
    public boolean esValido() { return this.esValido; }

    // Metodos
    public boolean alquilarPelicula(Pelicula p) {
        if (nPeliculasAlquiladas < MAX_PELICULAS_ALQUILER) {
            peliculasAlquiladas[nPeliculasAlquiladas] = p;
            nPeliculasAlquiladas++;
            return true;
        }
        return false;
    }

    public void devolverPelicula(Pelicula p) {
        int indice = -1;
        for (int i = 0; i < nPeliculasAlquiladas; i++) {
            if (peliculasAlquiladas[i].getCodigo().equals(p.getCodigo())) {
                indice = i;
                break;
            }
        }
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
    // Metodo para mostrar la info el cliente
    public String mostrarInfoCliente() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String estado = isDeBaja() ? "Dado de Baja (" + this.fechaBaja.format(formatoFecha) + ")" : "Activo";
        return String.format("Nº Socio: %s | DNI: %-10s | Nombre: %-20s | Estado: %s",
                this.numSocio, this.dni, this.nombre, estado);
    }
    public String mostrarPeliculasAlquiladas() {
        if (nPeliculasAlquiladas == 0) {
            return "Este cliente no tiene películas alquiladas actualmente.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--- Películas alquiladas por ").append(this.nombre).append(" ---\n");
        for (int i = 0; i < nPeliculasAlquiladas; i++) {
            sb.append("- ").append(peliculasAlquiladas[i].getNombre()).append("\n");
        }
        return sb.toString();
    }
}