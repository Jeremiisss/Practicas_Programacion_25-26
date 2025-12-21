public class Agenda {

    private Contacto[] contactos;
    private int numContactos;
    private static final int MAX_CONTACTOS = 10;

    public Agenda() {
        this.contactos = new Contacto[MAX_CONTACTOS];
        this.numContactos = 0;
    }

    //Metodos
    public int getNumContactos() {
        return this.numContactos;
    }

    public Contacto getContacto(int posicion) {
        if (posicion >= 0 && posicion < this.numContactos) {
            return this.contactos[posicion];
        }
        return null;
    }

    public int buscaContacto(String nombre) {
        for (int i = 0; i < this.numContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public boolean existeContacto(String nombre) {
        return buscaContacto(nombre) != -1;
    }

    public boolean añadirContacto(Contacto c) {
        if (this.numContactos >= MAX_CONTACTOS || existeContacto(c.getNombre())) {
            return false;
        }
        contactos[this.numContactos] = c;
        this.numContactos++;
        return true;
    }

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
}