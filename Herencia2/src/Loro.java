import java.time.LocalDate;

// La clase Loro es un tipo de Ave
public class Loro extends Aves {
    private String origen;

    //Constructor
    public Loro(String nombre, LocalDate fechaNacimiento, String pico, boolean vuela, String origen) {
        super(nombre, fechaNacimiento, pico, vuela);
        this.origen = origen;
    }
    //Metodos
    @Override
    public String muestra() {
        return "--- FICHA DE LORO ---\n" +
                getInfoBase() + // Obtiene la info combinada de Mascota y Ave.
                "Origen: " + this.origen + "\n" +
                "---------------------";
    }

    @Override
    public String habla() {
        return "HOLA! SOY UN LORO BONITO";
    }

    @Override
    public String volar() {
        if (isVuela()) {
            return getNombre() + " está volando torpemente.";
        } else {
            return getNombre() + " no puede volar.";
        }
    }

    // Método que solo tienen los Loros.
    public String saluda() {
        return "Hola, me llamo " + getNombre() + " y vengo de " + this.origen;
    }
}