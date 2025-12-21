import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Agenda miAgenda = new Agenda();

    public static void main(String[] args) {
        // Datos de ejemplo para preseteados
        miAgenda.añadirContacto(new ContactoPersona("Jeremis", "633108271", "09/07"));
        miAgenda.añadirContacto(new ContactoEmpresa("Jeremis Enterprise", "633941833", "www.JeremisEnterprise.com"));

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
                case 4: gestionarListarContactos(); break;
                case 5: System.out.println("👋 ¡Hasta luego!"); break;
                default: System.out.println("❌ Opción no válida.");
            }
            System.out.println();
        } while (opcion != 5);
        scanner.close();
    }

    // metodo para mostrar menu
    public static void mostrarMenu() {
        System.out.println("--- MENÚ DE AGENDA (PERSONAS Y EMPRESAS) ---");
        System.out.println("1. Añadir Contacto");
        System.out.println("2. Eliminar Contacto");
        System.out.println("3. Buscar si un contacto existe");
        System.out.println("4. Listar todos los Contactos");
        System.out.println("5. Salir");
        System.out.println("------------------------------------------");
    }

    // El metodo de añadir pregunta el TIPO de contacto
    private static void gestionarAñadirContacto() {
        System.out.println("\n--- Añadir Nuevo Contacto ---");
        System.out.print("¿Qué tipo de contacto quieres añadir? (1: Persona, 2: Empresa): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el teléfono: ");
        String telefono = scanner.nextLine();

        Contacto nuevoContacto = null;
        if (tipo == 1) {
            System.out.print("Introduce el cumpleaños: ");
            String cumple = scanner.nextLine();
            nuevoContacto = new ContactoPersona(nombre, telefono, cumple);
        } else if (tipo == 2) {
            System.out.print("Introduce la página web: ");
            String web = scanner.nextLine();
            nuevoContacto = new ContactoEmpresa(nombre, telefono, web);
        } else {
            System.out.println("❌ Tipo no válido. Operación cancelada.");
            return;
        }

        if (miAgenda.añadirContacto(nuevoContacto)) {
            System.out.println("✅ Contacto añadido con éxito.");
        } else {
            System.out.println("❌ No se pudo añadir el contacto (agenda llena o nombre duplicado).");
        }
    }


    private static void gestionarListarContactos() {
        System.out.println("--- LISTA DE CONTACTOS ---");
        if (miAgenda.getNumContactos() == 0) {
            System.out.println("ℹ️ La agenda está vacía.");
        } else {
            for (int i = 0; i < miAgenda.getNumContactos(); i++) {
                Contacto c = miAgenda.getContacto(i);
                System.out.print((i + 1) + ". ");

                // Con instanceof preguntamos de que tipo es el objeto persona o empresa
                if (c instanceof ContactoPersona) {
                    ContactoPersona p = (ContactoPersona) c;
                    System.out.println("[PERSONA] Nombre: " + p.getNombre() + ", Teléfono: " + p.getTelefono() + ", Cumpleaños: " + p.getCumpleaños());
                } else if (c instanceof ContactoEmpresa) {
                    ContactoEmpresa e = (ContactoEmpresa) c;
                    System.out.println("[EMPRESA] Nombre: " + e.getNombre() + ", Teléfono: " + e.getTelefono() + ", Web: " + e.getPaginaWeb());
                }
            }
        }
        System.out.println("--------------------------");
    }


    private static void gestionarEliminarContacto() {
        System.out.println("\n--- Eliminar Contacto ---");
        gestionarListarContactos(); // Mostramos la lista para que el usuario vea las opciones.
        System.out.print("Introduce el nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();

        if (miAgenda.eliminarContacto(nombre)) {
            System.out.println("✅ Contacto eliminado con éxito.");
        } else {
            System.out.println("❌ No se encontró un contacto con ese nombre.");
        }
    }

    private static void gestionarBuscarContacto() {
        System.out.println("\n--- Buscar Contacto ---");
        System.out.print("Introduce el nombre del contacto a buscar: ");
        String nombre = scanner.nextLine();

        if (miAgenda.existeContacto(nombre)) {
            int posicion = miAgenda.buscaContacto(nombre);
            System.out.println("✅ El contacto '" + nombre + "' SÍ existe y está en la posición " + (posicion + 1) + ".");
        } else {
            System.out.println("❌ El contacto '" + nombre + "' NO existe en la agenda.");
        }
    }
}