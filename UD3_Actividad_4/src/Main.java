import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Agenda miAgenda = new Agenda(); // El objeto Agenda que usaremos para todo

    public static void main(String[] args) {
        // Añadimos contactos para que la agenda no empiece vacia
        miAgenda.añadirContacto(new Contacto("Juanka", "63398624"));
        miAgenda.añadirContacto(new Contacto("Aaron", "607769325"));

        int opcion = 0;
        do {
            mostrarMenu();
            System.out.print("✏️ Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: gestionarAñadirContacto(); break;
                case 2: gestionarEliminarContacto(); break;
                case 3: gestionarBuscarContacto(); break;
                case 4: miAgenda.listarContactos(); break;
                case 5: System.out.println("👋 ¡Hasta luego!"); break;
                default: System.out.println("❌ Opción no válida.");
            }
            System.out.println();
        } while (opcion != 5);

        scanner.close();
    }

    // metodo para imprimir menu
    public static void mostrarMenu() {
        System.out.println("--- MENÚ DE AGENDA JEREMIS SOCIETY ---");
        System.out.println("1. Añadir Contacto");
        System.out.println("2. Eliminar Contacto");
        System.out.println("3. Buscar si un contacto existe");
        System.out.println("4. Listar todos los Contactos");
        System.out.println("5. Salir");
        System.out.println("----------------------");
    }

    // añadir contacto
    private static void gestionarAñadirContacto() {
        System.out.println("\n--- Añadir Nuevo Contacto ---");
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el teléfono: ");
        String telefono = scanner.nextLine();

        Contacto nuevoContacto = new Contacto(nombre, telefono);

        if (miAgenda.añadirContacto(nuevoContacto)) {
            System.out.println("✅ Contacto añadido con éxito.");
        } else {
            System.out.println("❌ No se pudo añadir el contacto. Es posible que el nombre ya exista o que la agenda esté llena.");
        }
    }

    // eliminar contacto
    private static void gestionarEliminarContacto() {
        System.out.println("\n--- Eliminar Contacto ---");
        miAgenda.listarContactos(); // lista de usurios para saber lo que se puede borrar
        System.out.print("Introduce el nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();

        if (miAgenda.eliminarContacto(nombre)) {
            System.out.println("✅ Contacto eliminado con éxito.");
        } else {
            System.out.println("❌ No se encontró un contacto con ese nombre.");
        }
    }

    // buscar contacto
    private static void gestionarBuscarContacto() {
        System.out.println("\n--- Buscar Contacto ---");
        System.out.print("Introduce el nombre del contacto a buscar: ");
        String nombre = scanner.nextLine();

        if (miAgenda.existeContacto(nombre)) {
            // posicion en la agenda
            int posicion = miAgenda.buscaContacto(nombre);
            System.out.println("✅ El contacto '" + nombre + "' SÍ existe y está en la posición " + (posicion + 1) + ".");
        } else {
            System.out.println("❌ El contacto '" + nombre + "' NO existe en la agenda.");
        }
    }
}