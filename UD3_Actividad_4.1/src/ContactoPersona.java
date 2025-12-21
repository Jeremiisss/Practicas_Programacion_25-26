// Esta clase hereda de Contacto
public class ContactoPersona extends Contacto {

    private String cumpleaños;

    public ContactoPersona(String nombre, String telefono, String cumpleaños) {
        // super llama al constructor de la clase padre Contacto
        super(nombre, telefono);
        this.cumpleaños = cumpleaños;
    }

    public String getCumpleaños() {
        return this.cumpleaños;
    }
}