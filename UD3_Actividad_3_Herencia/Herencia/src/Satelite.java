public class Satelite extends Astro {
    // Atributos
    private double distanciaAlPlaneta;
    private double orbitaPlanetaria;
    private String planetaAlQuePertenece;

    // Constructor
    public Satelite(String nombre, double masa, double radioEcuatorial, double rotacionSobreSuEje, double temperaturaMedia, double gravedad, double distanciaAlPlaneta, double orbitaPlanetaria, String planetaAlQuePertenece) {
        super(nombre, masa, radioEcuatorial, rotacionSobreSuEje, temperaturaMedia, gravedad);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planetaAlQuePertenece = planetaAlQuePertenece;
    }

    // Metodo que devuelve un string
    @Override
    public String muestra() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- INFORMACIÓN DEL SATÉLITE: ").append(this.nombre).append(" ---\n");
        sb.append("Pertenece al planeta: ").append(this.planetaAlQuePertenece).append("\n");
        sb.append("Masa: ").append(this.masa).append(" kg\n");
        sb.append("Radio Ecuatorial: ").append(this.radioEcuatorial).append(" km\n");
        sb.append("Rotación sobre su eje: ").append(this.rotacionSobreSuEje).append(" horas\n");
        sb.append("Temperatura Media: ").append(this.temperaturaMedia).append(" °C\n");
        sb.append("Gravedad: ").append(this.gravedad).append(" m/s^2\n");
        sb.append("Distancia al planeta: ").append(this.distanciaAlPlaneta).append(" km\n");
        sb.append("Órbita alrededor del planeta: ").append(this.orbitaPlanetaria).append(" días\n");
        sb.append("-----------------------------------------");
        return sb.toString();
    }
}