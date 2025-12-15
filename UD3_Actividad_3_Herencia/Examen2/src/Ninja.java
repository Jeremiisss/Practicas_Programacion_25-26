import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ninja {
    private String nombreNinja;
    private Chakra chakra;
    private Rango rango;
    private int idNinja;
    private String TecnicaSecreta;
    private LocalDate fechaAlta;
    private double Ataque;
    private double Defensa;


    private static final double porcentajeAtaqueMaximo = 100;
    private static final double porcentajeDefensaMaximo = 100;
    private static int contadorNinjas = 0;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Ninja(String nombreNinja, Chakra chakra, Rango rango, int idNinja, String tecnicaSecreta, double ataque, double defensa) {
        this.nombreNinja = nombreNinja;
        this.chakra = chakra;
        this.rango = rango;
        this.idNinja = idNinja;
        TecnicaSecreta = tecnicaSecreta;
        this.fechaAlta = LocalDate.now();
        Ataque = ataque;
        Defensa = defensa;
    }

    //getters
    public static int getContadorNinjas() {
        return contadorNinjas;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public int getIdNinja() {
        return idNinja;
    }
    //setters


    public void setChakra(Chakra chakra) {
        this.chakra = chakra;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public void setTecnicaSecreta(String tecnicaSecreta) {
        TecnicaSecreta = tecnicaSecreta;
    }

    public void setAtaque(double ataque) {
        Ataque = porcentajeAtaqueMaximo;
    }

    public void setDefensa(double defensa) {
        Defensa = porcentajeDefensaMaximo;
    }
    public void setNombreNinja(String nombreNinja) {
        this.nombreNinja = nombreNinja;
    }

    public static void RegistrarNinja() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo");
        String nombreEquipo = sc.nextLine();
        System.out.println("Introduce el nombre del Ninja");
        String nombreNinja = sc.nextLine();
        System.out.println("Introduce el Chakra" );
        System.out.println("Opciones:" + "TIERRA,FUEGO,AIRE,AGUA y RAYO");
        String chakra = sc.nextLine();
        System.out.println("Introduce el rango");
        System.out.println("Opciones:" + "GENIN, CHUNIN, JONIN, AMBU y KAGE");
        String rango = sc.nextLine();
        System.out.println("Introduce el Ataque");
        double ataque = sc.nextDouble();
        System.out.println("Introduce su defensa de 0-100");
        double defensa = sc.nextInt();

    }
}
