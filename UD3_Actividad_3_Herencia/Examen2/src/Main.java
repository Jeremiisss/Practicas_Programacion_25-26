import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre de la Aldea:\n");
        String nombreAldea = scanner.nextLine();
        System.out.println("Codigo de la Aldea(5 letras mayusculas y 5 digitos): ");
        String codigoAldea = scanner.nextLine().toUpperCase();

        int opcion = 0;

        do {
            imprimirMenuOpciones();
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        Equipo.crearEquipo();
                        break;
                    case 2:
                        Ninja.RegistrarNinja();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:

                        break;
                    case 6:
                        break;
                    case 7:

                        break;
                    case 8: System.out.println("🙋‍♂️Saliendo del programa.🙋‍♂️");
                        break;

                    default: System.out.println("❌Opción no válida.❌");
                }
            } else {
                System.out.println("⚠️Error: Debe introducir un número.⚠️");
                scanner.nextLine();
            }
            System.out.println();
        } while (opcion != 8);
        scanner.close();
    }

    private static void imprimirMenuOpciones() {
        System.out.println("1. Crear equipo");
        System.out.println("2. Registrar Ninja en el equipo");
        System.out.println("3. Mostrar el numero de ninjas totales en la Aldea");
        System.out.println("4. Mostrar informacion de un equipo");
        System.out.println("5. Mostrar informacion de todos los equipos");
        System.out.println("6. Mostrar informacion de toda la Aldea");
        System.out.println("7. Calcular estadisticas de toda la Aldea");
        System.out.println("8. Cambiar ninja de un equipo");
        System.out.println("9. Eliminar ninja de la aldea");
        System.out.println("10. Salir");
    }

}