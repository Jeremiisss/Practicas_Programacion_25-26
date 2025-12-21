// Esta clase también hereda de Contacto.
public class ContactoEmpresa extends Contacto {

    private String paginaWeb;

    public ContactoEmpresa(String nombre, String telefono, String paginaWeb) {
        super(nombre, telefono);
        this.paginaWeb = paginaWeb;
    }

    public String getPaginaWeb() {
        return this.paginaWeb;
    }
}