
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VideoDaw {
    // Atributos
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula[] peliculasRegistradas;
    private Cliente[] clientesRegistrados;
    private int nPeliculas;
    private int nClientes;
    private boolean esValido;

    private static final int MAX_PELICULAS = 200;
    private static final int MAX_CLIENTES = 100;

    // Constructor
    public VideoDaw(String cif, String direccion) {
        if (cif == null || !cif.matches("^[A-Z]\\d{8}$")) {
            this.esValido = false;
        } else {
            this.esValido = true;
            this.cif = cif;
            this.direccion = direccion;
            this.fechaAlta = LocalDate.now();
            this.peliculasRegistradas = new Pelicula[MAX_PELICULAS];
            this.clientesRegistrados = new Cliente[MAX_CLIENTES];
            this.nPeliculas = 0;
            this.nClientes = 0;
        }
    }

    // Getters
    public String getCif() {
        return this.cif;
    }

    public boolean esValido() {
        return this.esValido;
    }

    // Metodos
    public Cliente buscarClientePorDNI(String dni) {
        for (int i = 0; i < nClientes; i++) {
            if (clientesRegistrados[i].getDni().equalsIgnoreCase(dni)) {
                return clientesRegistrados[i];
            }
        }
        return null;
    }

    public Pelicula buscarPeliculaPorCod(String cod) {
        for (int i = 0; i < nPeliculas; i++) {
            if (peliculasRegistradas[i].getCodigo().equalsIgnoreCase(cod)) {
                return peliculasRegistradas[i];
            }
        }
        return null;
    }

    public boolean registrarPelicula(Pelicula p) {
        if (nPeliculas < MAX_PELICULAS) {
            peliculasRegistradas[nPeliculas] = p;
            nPeliculas++;
            return true;
        }
        return false;
    }

    public boolean registrarCliente(Cliente c) {
        if (c == null || !c.esValido()) {
            return false;
        }
        if (buscarClientePorDNI(c.getDni()) != null) {
            return false;
        }
        if (nClientes < MAX_CLIENTES) {
            clientesRegistrados[nClientes] = c;
            nClientes++;
            return true;
        }
        return false;
    }

    public String alquilarPelicula(Pelicula p, Cliente c) {
        if (p.isDeBaja() || c.isDeBaja()) {
            return "⚠️Error: No se puede operar con películas o clientes dados de baja.⚠️";
        }
        if (p.isAlquilada()) {
            return "⚠️Error: La película '" + p.getNombre() + "' ya está alquilada.⚠️";
        }
        boolean exito = c.alquilarPelicula(p);
        if (exito) {
            p.alquilar();
            return "✅Alquiler exitoso: El cliente " + c.getNumSocio() + " ha alquilado " + p.getCodigo() + " ✅";
        } else {
            return "⚠️Error: El cliente ha alcanzado el límite de alquileres.⚠️";
        }
    }

    public String devolverPelicula(Pelicula p, Cliente c) {
        long horas = Duration.between(p.getFechaAlquiler(), LocalDateTime.now()).toHours();
        String mensaje = "🗄️Devolución exitosa.🗄️";
        if (horas > 48) {
            mensaje = "🕕AVISO: Devolución fuera de plazo (" + horas + " horas). 🕕" + mensaje;
        }
        p.devolver();
        c.devolverPelicula(p);
        return mensaje;
    }

    public void darBajaCliente(Cliente c) {
        c.darDeBaja();
    }

    public void darBajaPelicula(Pelicula p) {
        p.darDeBaja();
    }

    public String mostrarPeliculasRegistradas() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- 📼LISTADO DE PELÍCULAS📼 ---\n");
        for (int i = 0; i < nPeliculas; i++) {
            sb.append(peliculasRegistradas[i].mostrarInfoPelicula()).append("\n");
        }
        sb.append("----------------------------\n");
        return sb.toString();
    }

    public String mostrarClientesRegistrados() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- 👨‍💼LISTADO DE CLIENTES👨‍💼 ---\n");
        for (int i = 0; i < nClientes; i++) {
            sb.append(clientesRegistrados[i].mostrarInfoCliente()).append("\n");
        }
        sb.append("---------------------------\n");
        return sb.toString();
    }
}