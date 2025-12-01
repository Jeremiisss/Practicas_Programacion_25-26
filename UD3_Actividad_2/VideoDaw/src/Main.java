import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static VideoDaw miVideoclub = null;

    public static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                if (miVideoclub == null && opcion != 1 && opcion != 8) {
                    System.out.println("Error: Primero debe crear y registrar un videoclub (Opción 1).");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        gestionarCrearVideoClub();
                    break;
                    case 2:
                        gestionarRegistrarPelicula();
                    break;
                    case 3:
                        gestionarRegistrarCliente();
                    break;
                    case 4:
                        gestionarAlquilarPelicula();
                    break;
                    case 5:
                        gestionarDevolverPelicula();
                    break;
                    case 6:
                        gestionarBajaCliente();
                    break;
                    case 7:
                        gestionarBajaPelicula();
                    break;
                    case 8: System.out.println("🙋‍♂️Saliendo del programa.🙋‍♂️");
                    break;

                    default: System.out.println("❌Opción no válida.❌");
                }
            } else {
                System.out.println("Error: Debe introducir un número.");
                scanner.nextLine();
            }
            System.out.println();
        } while (opcion != 8);
        scanner.close();
    }

    private static void gestionarRegistrarPelicula() {
        System.out.print("Nombre de la película: ");
        String nombre = scanner.nextLine();
        System.out.print("Director de la película: ");
        String director = scanner.nextLine();

        System.out.println("Selecciona un género de la lista:");
        for (Genero g : Genero.values()) {
            System.out.print(g + " ");
        }
        System.out.print("\nGénero: ");
        String generoInput = scanner.nextLine();

        Genero genero = validarGenero(generoInput);

        if (genero != null) {
            Pelicula nuevaPelicula = new Pelicula(nombre, director, genero);
            if (miVideoclub.registrarPelicula(nuevaPelicula)) {
                System.out.println("Película registrada con éxito.");
            } else {
                System.out.println("Error: No se pudo registrar la película (posiblemente el videoclub está lleno).");
            }
        } else {
            System.out.println("Error: Género no válido. La película no ha sido registrada.");
        }
    }

    private static void gestionarRegistrarCliente() {
        System.out.print("DNI del cliente (ej. 12345678A): ");
        String dni = scanner.nextLine();
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
        String fechaInput = scanner.nextLine();

        if (esFechaValida(fechaInput)) {
            String[] partes = fechaInput.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);
            LocalDate fechaNac = LocalDate.of(anio, mes, dia);

            Cliente nuevoCliente = new Cliente(dni, nombre, direccion, fechaNac);

            if (!nuevoCliente.esValido()) {
                System.out.println("Error: Datos del cliente no válidos (DNI incorrecto o menor de edad).");
                return;
            }

            boolean exito = miVideoclub.registrarCliente(nuevoCliente);
            if (exito) {
                System.out.println("Cliente registrado con éxito.");
            } else {
                System.out.println("Error: No se pudo registrar al cliente (posiblemente DNI ya existente o videoclub lleno).");
            }
        } else {
            System.out.println("Error: Formato de fecha o fecha inválida. El cliente no ha sido registrado.");
        }
    }

    private static Genero validarGenero(String texto) {
        for (Genero g : Genero.values()) {
            if (g.name().equalsIgnoreCase(texto)) {
                return g;
            }
        }
        return null;
    }

    private static boolean esFechaValida(String fechaTexto) {
        if (fechaTexto == null || !fechaTexto.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            return false;
        }
        String[] partes = fechaTexto.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int year = Integer.parseInt(partes[2]);
        if (mes < 1 || mes > 12 || year < 1900 || year > LocalDate.now().getYear()) {
            return false;
        }
        int diasEnMes;
        if (mes == 2) {
            boolean esBisiesto = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
            diasEnMes = esBisiesto ? 29 : 28;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            diasEnMes = 30;
        } else {
            diasEnMes = 31;
        }
        if (dia < 1 || dia > diasEnMes) {
            return false;
        }
        return true;
    }

    public static void mostrarMenu() {
        System.out.println("📀Gestion de VideoDaw Jeremis experience📀");
        if (miVideoclub != null) {
            System.out.println("Videoclub Activo: CIF " + miVideoclub.getCif());
        }
        System.out.println("1. 🎬Crear y registrar VideoClub");
        System.out.println("2. 📼Registrar película en videoclub");
        System.out.println("3. 👨‍💼Crear y registrar cliente en videoclub");
        System.out.println("4. 🎞️Alquilar película");
        System.out.println("5. 🔄️Devolver película");
        System.out.println("6. ❌Dar de baja cliente");
        System.out.println("7. 🗑️Dar de baja película");
        System.out.println("8. 🚪Salir");
        System.out.println("---------------------------");
    }

    private static void gestionarCrearVideoClub() {
        if (miVideoclub != null) {
            System.out.println("Error: Ya existe un videoclub registrado.");
            return;
        }
        System.out.print("Introduce el CIF del videoclub (ej. A12345678): ");
        String cif = scanner.nextLine().toUpperCase();
        System.out.print("Introduce la dirección: ");
        String direccion = scanner.nextLine();
        VideoDaw nuevoVideoclub = new VideoDaw(cif, direccion);
        if (nuevoVideoclub.esValido()) {
            miVideoclub = nuevoVideoclub;
            System.out.println("Videoclub registrado con éxito.");
        } else {
            System.out.println("Error: El CIF es incorrecto. No se ha creado el videoclub.");
        }
    }

    private static void gestionarAlquilarPelicula() {
        System.out.println(miVideoclub.mostrarPeliculasRegistradas());
        System.out.print("Introduce el código de la película a alquilar: ");
        String codPeli = scanner.nextLine().toUpperCase();
        Pelicula p = miVideoclub.buscarPeliculaPorCod(codPeli);
        System.out.println(miVideoclub.mostrarClientesRegistrados());
        System.out.print("Introduce el DNI del cliente que alquila: ");
        String dniCli = scanner.nextLine().toUpperCase();
        Cliente c = miVideoclub.buscarClientePorDNI(dniCli);
        if (p != null && c != null) {
            String resultado = miVideoclub.alquilarPelicula(p, c);
            System.out.println(resultado);
        } else {
            System.out.println("Error: Película o cliente no encontrado.");
        }
    }

    private static void gestionarDevolverPelicula() {
        System.out.print("Introduce el código de la película a devolver: ");
        String codPeli = scanner.nextLine().toUpperCase();
        Pelicula p = miVideoclub.buscarPeliculaPorCod(codPeli);
        System.out.print("Introduce el DNI del cliente que devuelve: ");
        String dniCli = scanner.nextLine().toUpperCase();
        Cliente c = miVideoclub.buscarClientePorDNI(dniCli);
        if (p != null && c != null) {
            String resultado = miVideoclub.devolverPelicula(p, c);
            System.out.println(resultado);
        } else {
            System.out.println("Error: Película o cliente no encontrado.");
        }
    }

    private static void gestionarBajaCliente() {
        System.out.println(miVideoclub.mostrarClientesRegistrados());
        System.out.print("Introduce el DNI del cliente a dar de baja: ");
        String dni = scanner.nextLine().toUpperCase();
        Cliente c = miVideoclub.buscarClientePorDNI(dni);
        if (c != null) {
            miVideoclub.darBajaCliente(c);
            System.out.println("Cliente " + c.getNumSocio() + " dado de baja con éxito.");
        } else {
            System.out.println("Error: Cliente no encontrado.");
        }
    }

    private static void gestionarBajaPelicula() {
        System.out.println(miVideoclub.mostrarPeliculasRegistradas());
        System.out.print("Introduce el código de la película a dar de baja: ");
        String cod = scanner.nextLine().toUpperCase();
        Pelicula p = miVideoclub.buscarPeliculaPorCod(cod);
        if (p != null) {
            miVideoclub.darBajaPelicula(p);
            System.out.println("Película " + p.getCodigo() + " dada de baja con éxito.");
        } else {
            System.out.println("Error: Película no encontrada.");
        }
    }
}