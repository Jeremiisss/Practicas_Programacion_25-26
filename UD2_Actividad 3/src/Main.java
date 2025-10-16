import com.sun.jdi.event.BreakpointEvent;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ejercicio 1
        System.out.println("Ejercicio 1");
        int dinero;

        do {
            System.out.println("Introduce una cantidad multiplo de 5: ");
            dinero = sc.nextInt();
            if (dinero % 5 != 0 || dinero <= 0) {
                System.out.println("Error, La cantidad debe ser multiplo de 5 y mayor que 0");
            }
        }
        while (dinero % 5 != 0 || dinero <= 0);

        int [] valores = {500, 200, 100, 50, 20, 10, 5};
        System.out.println("Para " + dinero + "€, se necesita los siguientes billetes: ");

        for (int valor : valores) {
            int numBilletes = dinero / valor;
            if (numBilletes > 0) ;
            {
                System.out.println(numBilletes + " billete(s) de " + valor + "€");
                dinero %= valor;
            }
            if (dinero == 0) {
                break;
            }
        }

        //Ejercicio 2
        System.out.println("Ejercicio 2");

        int opcion;
        double num1, num2;

        do {
            System.out.println("Menu de opciones");
            System.out.println("1. Sumar");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.println("Elige una opcion: ");

            opcion = sc.nextInt();

            switch (opcion){
                case 1: //Sumar
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("Resultado: " + (num1 + num2));
                    break;

                case 2: //Restar
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("Resultado: " + (num1 - num2));
                    break;

                case 3: //Multiplicar
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("Resultado: " + (num1 * num2));
                    break;

                case 4: //Dividir
                    System.out.println("Introduce el dividiendo: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el divisor: ");
                    num2 = sc.nextDouble();
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Error: No se puede dividir por cero.");
                    }
                    break;
                case 5: //Salir
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no valida.Elige una opción del 1 al 5.");
            }
        }while (opcion != 5);
    }
}