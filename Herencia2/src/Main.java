import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// clase que interactua con el usuario
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Inventario miInventario = new Inventario();

    public static void main(String[] args) {
        // Datos de ejemplo para empezar el programa con algunos animales.
        miInventario.insertarAnimal(new Perro("Kidd Keo", LocalDate.of(2020, 5, 15), "Labrador", false));
        miInventario.insertarAnimal(new Gato("Gati", LocalDate.of(2022, 1, 10), "Naranja", true));
        miInventario.insertarAnimal(new Loro("Javi", LocalDate.of(2018, 10, 2), "Curvo", true, "Amazonas"));

        int opcion = 0;
        do {
            mostrarMenu();
            System.out.print("✏️ Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el scanner

            switch (opcion) {
                case 1:
                    gestionarMostrarListaAnimales();
                break;
                case 2:
                    gestionarMostrarUnAnimal();
                break;
                case 3:
                    gestionarMostrarTodosLosDatos();
                break;
                case 4:
                    gestionarInsertarAnimal();
                break;
                case 5:
                    gestionarEliminarAnimal();
                break;
                case 6:
                    gestionarVaciarInventario();
                break;
                case 7: System.out.println("👋 ¡Hasta pronto, Jeremis Pets!"); break;
                default: System.out.println("❌ Opción no válida.");
            }
            System.out.println();
        } while (opcion != 7);
        scanner.close();
    }

    // Menu de oopciones
    public static void mostrarMenu() {
        System.out.println("🐾 --- Inventario de Mascotas de Jeremis --- 🐾");
        System.out.println("1. 📋 Mostrar lista de animales (tipo y nombre)");
        System.out.println("2. 🔍 Mostrar datos de un animal");
        System.out.println("3. 📂 Mostrar datos de TODOS los animales");
        System.out.println("4. ➕ Añadir animal al inventario");
        System.out.println("5. ➖ Eliminar animal del inventario");
        System.out.println("6. 🗑️ Vaciar el inventario");
        System.out.println("7. 👋 Salir");
        System.out.println("----------------------------------------------");
    }

    private static void gestionarMostrarListaAnimales() {
        System.out.println("📋 --- LISTA DE ANIMALES EN INVENTARIO --- 📋");
        if (miInventario.getNumAnimalesActuales() == 0) {
            System.out.println("ℹ️ El inventario está vacío.");
        } else {
            for (int i = 0; i < miInventario.getNumAnimalesActuales(); i++) {
                Mascotas animal = miInventario.getAnimal(i);
                String tipoAnimal = animal.getClass().getSimpleName();
                String icono = "🐾"; //

                if (tipoAnimal.equals("Perro")) icono = "🐶";
                else if (tipoAnimal.equals("Gato")) icono = "🐱";
                else if (tipoAnimal.equals("Loro")) icono = "🦜";
                else if (tipoAnimal.equals("Canario")) icono = "🐦";

                System.out.println(icono + " Tipo: " + tipoAnimal + ", Nombre: " + animal.getNombre());
            }
        }
        System.out.println("--------------------------------------------");
    }

    // Metodos
    private static void gestionarMostrarUnAnimal() {
        System.out.println("🔍 --- MOSTRAR DATOS DE UN ANIMAL --- 🔍");

        // 1.comprobar que hay animales
        if (miInventario.getNumAnimalesActuales() == 0) {
            System.out.println("ℹ️ No hay animales en el inventario para mostrar.");
            return; // Salimos del método.
        }

        // 2.si hay animales nos enseñe la lista
        gestionarMostrarListaAnimales();

        // 3.pedir nombre del animal
        System.out.print("✏️ Introduce el nombre del animal a buscar: ");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < miInventario.getNumAnimalesActuales(); i++) {
            Mascotas animal = miInventario.getAnimal(i);
            if (animal.getNombre().equalsIgnoreCase(nombre)) {
                String info = animal.muestra();
                System.out.println(info);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("❌ No se ha encontrado ningún animal con el nombre '" + nombre + "'.");
        }
    }

    private static void gestionarMostrarTodosLosDatos() {
        System.out.println("📂 --- INVENTARIO COMPLETO --- 📂");
        if (miInventario.getNumAnimalesActuales() == 0) {
            System.out.println("ℹ️ El inventario está vacío.");
        } else {
            for (int i = 0; i < miInventario.getNumAnimalesActuales(); i++) {
                String info = miInventario.getAnimal(i).muestra();
                System.out.println(info);
                System.out.println();
            }
        }
        System.out.println("-------------------------------");
    }

    private static void gestionarInsertarAnimal() {
        System.out.println("--- ➕ AÑADIR NUEVO ANIMAL ---");
        System.out.println("1. Perro | 2. Gato | 3. Loro | 4. Canario");
        System.out.print("✏️ Elige una opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("✏️ Nombre: ");
        String nombre = scanner.nextLine();

        LocalDate fecha = null;
        while (fecha == null) {
            System.out.print("✏️ Fecha de nacimiento (dd/MM/yyyy): ");
            String fechaInput = scanner.nextLine();
            try {
                fecha = LocalDate.parse(fechaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Formato de fecha incorrecto. Inténtalo de nuevo.");
            }
        }

        Mascotas nuevaMascota = null;
        //  Crear aniamales
        switch (tipo) {
            case 1:
                System.out.print("✏️ Raza: "); String raza = scanner.nextLine();
                System.out.print("✏️ ¿Tiene pulgas? (s/n): "); boolean pulgas = scanner.nextLine().equalsIgnoreCase("s");
                nuevaMascota = new Perro(nombre, fecha, raza, pulgas);
                break;
            case 2:
                System.out.print("✏️ Color: "); String colorGato = scanner.nextLine();
                System.out.print("✏️ ¿Pelo largo? (s/n): "); boolean peloLargo = scanner.nextLine().equalsIgnoreCase("s");
                nuevaMascota = new Gato(nombre, fecha, colorGato, peloLargo);
                break;
            case 3:
                System.out.print("✏️ Tipo de pico: "); String picoLoro = scanner.nextLine();
                System.out.print("✏️ Origen: "); String origen = scanner.nextLine();
                System.out.print("✏️ ¿Puede volar? (s/n): "); boolean vuelaLoro = scanner.nextLine().equalsIgnoreCase("s");
                nuevaMascota = new Loro(nombre, fecha, picoLoro, vuelaLoro, origen);
                break;
            case 4:
                System.out.print("✏️ Tipo de pico: "); String picoCanario = scanner.nextLine();
                System.out.print("✏️ Color: "); String colorCanario = scanner.nextLine();
                System.out.print("✏️ ¿Puede volar? (s/n): "); boolean vuelaCanario = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("✏️ ¿Canta bien? (s/n): "); boolean canta = scanner.nextLine().equalsIgnoreCase("s");
                nuevaMascota = new Canario(nombre, fecha, picoCanario, vuelaCanario, colorCanario, canta);
                break;
            default:
                System.out.println("❌ Tipo de animal no válido. Operación cancelada.");
                return;
        }

        if (miInventario.insertarAnimal(nuevaMascota)) {
            System.out.println("✅ " + nombre + " ha sido añadido al inventario.");
        } else {
            System.out.println("❌ Error: El inventario está lleno.");
        }
    }

    // metodo para eliminar animal
    private static void gestionarEliminarAnimal() {
        System.out.println("➖ --- ELIMINAR ANIMAL DEL INVENTARIO --- ➖");

        // 1 comprobar que hay animales
        if (miInventario.getNumAnimalesActuales() == 0) {
            System.out.println("ℹ️ No hay animales en el inventario para eliminar.");
            return;
        }

        // 2.mostrar la lista de los animales para eliminar
        gestionarMostrarListaAnimales();

        // 3nombre del animal
        System.out.print("✏️ Introduce el nombre del animal a eliminar: ");
        String nombre = scanner.nextLine();

        if (miInventario.eliminarAnimal(nombre)) {
            System.out.println("✅ " + nombre + " ha sido eliminado del inventario.");
        } else {
            System.out.println("❌ No se ha encontrado ningún animal con el nombre '" + nombre + "'.");
        }
    }

    private static void gestionarVaciarInventario() {
        miInventario.vaciarInventario();
        System.out.println("🗑️ El inventario ha sido vaciado.");
    }
}