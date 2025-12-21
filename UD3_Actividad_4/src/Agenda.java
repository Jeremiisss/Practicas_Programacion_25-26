public class Agenda {

    private Contacto[] contactos;
    private int numContactos;
    private static final int MAX_CONTACTOS = 10;

    // Constructor
    public Agenda() {
        this.contactos = new Contacto[MAX_CONTACTOS];
        this.numContactos = 0;
    }

    //Metodos

    // Añadir un contacto a la agenda
    public boolean añadirContacto(Contacto c) {
        // Comprobacion de que no existe
        if (existeContacto(c.getNombre())) {
            return false;
        }
        // Comprobacion de que la agenda no esté llena
        if (this.numContactos >= MAX_CONTACTOS) {
            return false;
        }

        // añadir nuevo contacto
        contactos[this.numContactos] = c;
        this.numContactos++;
        return true;
    }

    // Elimina el contacto de la agenda
    public boolean eliminarContacto(String nombre) {
        int posicion = buscaContacto(nombre);

        if (posicion == -1) {
            return false;
        }

        for (int i = posicion; i < numContactos - 1; i++) {
            contactos[i] = contactos[i + 1];
        }

        numContactos--;
        contactos[numContactos] = null;

        return true;
    }

    // comprobar si el contacto existe
    public boolean existeContacto(String nombre) {
        int posicion = buscaContacto(nombre);

        if (posicion != -1) {
            return true;
        } else {
            return false;
        }
    }

    // Muestra por pantalla toda la agenda
    public void listarContactos() {
        System.out.println("--- LISTA DE CONTACTOS (" + this.numContactos + "/" + MAX_CONTACTOS + ") ---");
        if (this.numContactos == 0) {
            System.out.println("La agenda está vacía.");
        } else {
            for (int i = 0; i < this.numContactos; i++) {
                Contacto c = contactos[i];
                System.out.println((i + 1) + ". Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono());
            }
        }
        System.out.println("---------------------------------");
    }

    // Busca un contacto por su nombre
    public int buscaContacto(String nombre) {
        for (int i = 0; i < this.numContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return i; // Devuelve la posición (el índice del array).
            }
        }
        return -1; // Devuelve -1 si no se encuentra.
    }
}