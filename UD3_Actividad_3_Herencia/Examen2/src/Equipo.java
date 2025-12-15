import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Equipo {
    private String nombreEquipo;
    private String codigoEquipo;
    private LocalDate fechaCreacion;
    private Sensei sensei;
    private int maximoNinjas;
    private Ninja[] ninjas;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Equipo(String nombreEquipo, String codigoEquipo, LocalDate fechaCreacion, Sensei sensei, int maximoNinjas, Ninja[] ninjas) {
        this.nombreEquipo = nombreEquipo;
        this.codigoEquipo = codigoEquipo;
        this.fechaCreacion = fechaCreacion;
        this.sensei = sensei;
        this.maximoNinjas = maximoNinjas;
        this.ninjas = ninjas;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public Sensei getSensei() {
        return sensei;
    }

    public void setSensei(Sensei sensei) {
        this.sensei = sensei;
    }

    public int getMaximoNinjas() {
        return maximoNinjas;
    }

    public void setMaximoNinjas(int maximoNinjas) {
        this.maximoNinjas = maximoNinjas;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public Ninja[] getNinjas() {
        return ninjas;
    }

    public void setNinjas(Ninja[] ninjas) {
        this.ninjas = ninjas;
    }
    public static void crearEquipo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo");
        String nombreEquipo = scanner.nextLine();
        System.out.println("Introduce el codigo del equipo");
        String codigoEquipo = scanner.nextLine();
        System.out.println("Introduce el sensei del equipo");
        String sensei = scanner.nextLine();
        System.out.println("Introduce el maximo de ninjas del equipo");
        int maximoNinjas = scanner.nextInt();
    }
}
