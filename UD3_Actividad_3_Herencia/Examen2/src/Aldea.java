import java.time.LocalDate;
import java.util.Scanner;

public class Aldea {
    private String nombreAldea;
    private String codigoAldea;
    private LocalDate fechaCreacion;
    private Sensei Kage;
    private int maximoEquipos;
    private Equipo[] equipos;

    public Aldea(String codigo, String nombreAldea, LocalDate fechaCreacion, Sensei kage, int maximoEquipos, Equipo[] equipos) {
        this.codigoAldea = codigo;
        this.nombreAldea = nombreAldea;
        this.fechaCreacion = fechaCreacion;
        Kage = kage;
        this.maximoEquipos = maximoEquipos;
        this.equipos = equipos;
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getMaximoEquipos() {
        return maximoEquipos;
    }

    public void setNombreAldea(String nombreAldea) {
        this.nombreAldea = nombreAldea;
    }

    public void setCodigoAldea(String codigoAldea) {
        this.codigoAldea = codigoAldea;
    }

    public void setKage(Sensei kage) {
        Kage = kage;
    }
    public  void setMaximoEquipos(int maximoEquipos) {
        this.maximoEquipos = maximoEquipos;
    }
    public static void agregarAldea() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre de la Aldea:\n");
        String nombreAldea = scanner.nextLine();
        System.out.println("Codigo de la Aldea(5 letras mayusculas y 5 digitos): ");
        String codigoAldea = scanner.nextLine();
    }

}

