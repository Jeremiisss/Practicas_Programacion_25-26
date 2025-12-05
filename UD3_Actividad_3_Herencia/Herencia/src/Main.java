import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MAX_ASTROS = 20;
        Astro[] listaAstros = new Astro[MAX_ASTROS];
        int nAstrosActuales = 0;

        // Creamos los objetos con sus nombres
        Planeta tierra = new Planeta("Tierra🌎", 5.97e24, 6371, 24, 15, 9.8, 1.5e8, 365.25);
        Planeta marte = new Planeta("Marte \uD83D\uDFE0", 6.42e23, 3389, 24.6, -63, 3.7, 2.28e8, 687);
        Satelite luna = new Satelite("Luna🌑", 7.35e22, 1737, 709, -23, 1.62, 384400, 27.3, "Tierra");
        Satelite fobos = new Satelite("Fobos", 1.07e16, 11.1, 7.6, -40, 0.0057, 9377, 0.3, "Marte");
        Satelite deimos = new Satelite("Deimos", 2.4e15, 6.2, 30.3, -40, 0.003, 23460, 1.26, "Marte");

        tierra.anadirSatelite(luna);
        marte.anadirSatelite(fobos);
        marte.anadirSatelite(deimos);

        listaAstros[nAstrosActuales++] = tierra;
        listaAstros[nAstrosActuales++] = marte;
        listaAstros[nAstrosActuales++] = luna;
        listaAstros[nAstrosActuales++] = fobos;
        listaAstros[nAstrosActuales++] = deimos;

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n=== 🪐MENÚ DEL SISTEMA SOLAR JEREMIS🪐 ===");
            for (int i = 0; i < nAstrosActuales; i++) {
                String tipoAstro = (listaAstros[i] instanceof Planeta) ? "Planeta" : "Satélite";
                System.out.println((i + 1) + ". Mostrar información de " + tipoAstro + " " + listaAstros[i].getNombre());
            }
            System.out.println("6. Salir");
            System.out.print("Elige un astro para ver sus detalles: ");

            opcion = scanner.nextInt();

            if (opcion > 0 && opcion <= nAstrosActuales) {
                // metodo que llama al string
                String info = listaAstros[opcion - 1].muestra();
                System.out.println(info);
            } else if (opcion != 6) {
                System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        System.out.println("🙋‍♂️Programa finalizado.🙋‍♂️");
        scanner.close();
    }
}