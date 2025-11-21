import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🪙Bienvenido a DawBank - Jeremis Enterprise🪙");
        System.out.println("==================================================");

        //pedir que el usuario ponga sus datos
        System.out.print("Introduce el nombre del titular: ");
        String titular = scanner.nextLine();
        System.out.print("Introduce el IBAN (p. ej., ES6621000418401234567891): ");
        String iban = scanner.nextLine();

        //objeto cuentaBancaria
        cuentaBancaria cuenta = new cuentaBancaria(iban, titular);

        // comprobar que la cuenta a creado correctamente
        if (cuenta.esValida()) {
            System.out.println("\n¡Cuenta creada con éxito!");
            // si es valido le enseñamos al usuario el menu
            gestionarMenu(cuenta);
        } else {
            //si no es valida nos aparece este mensaje de error
            System.out.println("\n ❌Error: No se pudo crear la cuenta. El IBAN o el titular son incorrectos.❌");
        }

        scanner.close();
        System.out.println("Gracias por utilizar DawBank.🙋‍♂️¡Hasta pronto!🙋‍♂️");
    }

    // bucle para enseñar el menu y pedir la opcion
    public static void gestionarMenu(cuentaBancaria cuenta) {
        int opcion = 0;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");

            // para comprobar que el usuario escribio un numero
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1: // datos de la cuenta
                        System.out.printf("IBAN: %s | Titular: %s | Saldo: %.2f €\n",
                                cuenta.getIban(), cuenta.getTitular(), cuenta.getSaldo());
                        break;
                    case 2: // IBAN
                        System.out.println("IBAN: " + cuenta.getIban());
                        break;
                    case 3: // titular
                        System.out.println("Titular: " + cuenta.getTitular());
                        break;
                    case 4: // saldo
                        System.out.printf("Saldo disponible: %.2f €\n", cuenta.getSaldo());
                        break;
                    case 5: // ingreso
                        System.out.print("Introduce la cantidad a ingresar: ");
                        if (scanner.hasNextDouble()) {
                            double ingreso = scanner.nextDouble();
                            scanner.nextLine();
                            cuenta.ingresar(ingreso);
                        } else {
                            System.out.println("❌Error: Cantidad no válida.❌");
                            scanner.nextLine();
                        }
                        break;
                    case 6: // retirada
                        System.out.print("Introduce la cantidad a retirar: ");
                        if (scanner.hasNextDouble()) {
                            double retirada = scanner.nextDouble();
                            scanner.nextLine();
                            cuenta.retirar(retirada);
                        } else {
                            System.out.println("❌Error: Cantidad no válida.❌");
                            scanner.nextLine();
                        }
                        break;
                    case 7: // movimientos
                        cuenta.mostrarMovimientos();
                        break;
                    case 8: // salir
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } else {
                System.out.println("❌Error: Debe introducir un número del 1 al 8.❌");
                scanner.nextLine();
            }
            System.out.println();

        } while (opcion != 8);
    }

    //para mostrar por pantalla las opciones del menu
    public static void mostrarMenu() {
        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("1. 💳Datos de la cuenta");
        System.out.println("2. 🔐IBAN");
        System.out.println("3. 🤵‍♂️Titular");
        System.out.println("4. 💰Saldo");
        System.out.println("5. 🤑Ingreso");
        System.out.println("6. 💸Retirada");
        System.out.println("7. 🧾Movimientos");
        System.out.println("8. 🙋‍♂️Salir");
        System.out.println("----------------------");
    }
}