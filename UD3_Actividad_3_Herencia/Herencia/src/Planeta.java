public class Planeta extends Astro {
    // Atributos
    private double distanciaAlSol;
    private double orbitaAlSol;
    private Satelite[] listaSatelites;
    private int nSatelitesActuales;
    private static final int MAX_SATELITES = 10;

    // Constructor
    public Planeta(String nombre, double masa, double radioEcuatorial, double rotacionSobreSuEje, double temperaturaMedia, double gravedad, double distanciaAlSol, double orbitaAlSol) {
        super(nombre, masa, radioEcuatorial, rotacionSobreSuEje, temperaturaMedia, gravedad);
        this.distanciaAlSol = distanciaAlSol;
        this.orbitaAlSol = orbitaAlSol;
        this.listaSatelites = new Satelite[MAX_SATELITES];
        this.nSatelitesActuales = 0;
    }

    // Metodos de Lógica
    public boolean anadirSatelite(Satelite s) {
        if (this.nSatelitesActuales < MAX_SATELITES) {
            this.listaSatelites[this.nSatelitesActuales] = s;
            this.nSatelitesActuales++;
            return true;
        }
        return false;
    }

    // Metodo que devuelve un string
    @Override
    public String muestra() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- INFORMACIÓN DEL PLANETA: ").append(this.nombre).append(" ---\n");
        sb.append("Masa: ").append(this.masa).append(" kg\n");
        sb.append("Radio Ecuatorial: ").append(this.radioEcuatorial).append(" km\n");
        sb.append("Rotación sobre su eje: ").append(this.rotacionSobreSuEje).append(" horas\n");
        sb.append("Temperatura Media: ").append(this.temperaturaMedia).append(" °C\n");
        sb.append("Gravedad: ").append(this.gravedad).append(" m/s^2\n");
        sb.append("Distancia al Sol: ").append(this.distanciaAlSol).append(" km\n");
        sb.append("Órbita alrededor del Sol: ").append(this.orbitaAlSol).append(" días\n");

        if (nSatelitesActuales > 0) {
            sb.append("Satélites que lo orbitan:\n");
            for (int i = 0; i < this.nSatelitesActuales; i++) {
                sb.append("- ").append(this.listaSatelites[i].getNombre()).append("\n");
            }
        } else {
            sb.append("No tiene satélites registrados.\n");
        }
        sb.append("---------------------------------");
        return sb.toString();
    }
}