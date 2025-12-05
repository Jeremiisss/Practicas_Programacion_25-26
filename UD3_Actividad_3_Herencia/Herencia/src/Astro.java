public abstract class Astro {
    // Atributos
    protected String nombre;
    protected double masa;
    protected double radioEcuatorial;
    protected double rotacionSobreSuEje;
    protected double temperaturaMedia;
    protected double gravedad;

    // Constructor
    public Astro(String nombre, double masa, double radioEcuatorial, double rotacionSobreSuEje, double temperaturaMedia, double gravedad) {
        this.nombre = nombre;
        this.masa = masa;
        this.radioEcuatorial = radioEcuatorial;
        this.rotacionSobreSuEje = rotacionSobreSuEje;
        this.temperaturaMedia = temperaturaMedia;
        this.gravedad = gravedad;
    }

    // Getters
    public String getNombre() { return nombre; }

    // Metodo Abstracto que devuelve un String
    public abstract String muestra();
}