import com.sun.jdi.event.BreakpointEvent;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ejercicio 1
        System.out.println("Ejercicio 1");
        int dinero =0;
        int n500 = 0, n200 = 0, n100 = 0, n50 = 0, n20 = 0, n10 = 0, n5 = 0;
        int dineroRestante =0;

        do {
            System.out.println("Introduce una cantidad multiplo de 5: ");
            dinero = sc.nextInt();

        } while (dinero % 5 != 0);

        String textoDinero = "Se necesitan \n ";
        dineroRestante = dinero;
        if (dineroRestante >= 500){
            n500 = dineroRestante / 500;
            dineroRestante = dineroRestante - (n500 * n500);
            textoDinero = textoDinero + "\n" + n500 + " billetes de 500€";
        }
        if (dineroRestante >= 200){
            n200 = dineroRestante / 200;
            dineroRestante = dineroRestante - (n200 * 200);
            textoDinero = textoDinero + "\n" + n200 + " billetes de 200€";
        }
        if (dineroRestante >= 100){
            n100 = dineroRestante / 100;
            dineroRestante = dineroRestante - (n100 * 100);
            textoDinero = textoDinero + "\n" + n100 + " billetes de 100€";

        }
        if (dineroRestante >= 50){
            n50 = dineroRestante / 50;
            dineroRestante = dineroRestante - (n50 * 50);
            textoDinero = textoDinero + "\n" + n50 + " billetes de 50€";

        }
        if (dineroRestante >= 20){
            n20 = dineroRestante / 20;
            dineroRestante = dineroRestante - (n20 * 20);
            textoDinero = textoDinero + "\n" + n20 + " billetes de 20€";
        }
        if (dineroRestante >= 10){
            n10 = dineroRestante / 10;
            dineroRestante = dineroRestante - (n10 * 10);
            textoDinero = textoDinero + "\n" + n10 + " billetes de 10€";

        }
        if (dineroRestante >= 5){
            n5 = dineroRestante / 5;
            dineroRestante = dineroRestante - (n5 * 5);
            textoDinero = textoDinero + "\n" + n5 + " billetes de 5€";

        }
        System.out.println("El dinero total es: " + dinero);
        System.out.println("Se necesitan \n" + n500 + " billetes de 500€");
        System.out.println("Se necesitan \n" + n200 + " billetes de 200€");
        System.out.println("Se necesitan \n" + n100 + " billetes de 100€");
        System.out.println("Se necesitan \n" + n50 + " billetes de 50€");
        System.out.println("Se necesitan \n" + n20 + " billetes de 20€");
        System.out.println("Se necesitan \n" + n10 + " billetes de 10€");
        System.out.println("Se necesitan \n" + n5 + " billetes de 5€");


        //Ejercicio 2
        System.out.println("Ejercicio 2");

        double num1, num2;
        sc = new Scanner(System.in);
        String opcion = "5";

        do {
            System.out.println("Menu de opciones");
            System.out.println("1. Sumar");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.println("Elige una opcion: ");

            opcion = sc.next();

            switch (opcion){
                case "1": //Sumar
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("Resultado: " + (num1 + num2));
                    break;

                case "2": //Restar
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("Resultado: " + (num1 - num2));
                    break;

                case "3": //Multiplicar
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el primer numero: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = sc.nextDouble();
                    System.out.println("Resultado: " + (num1 * num2));
                    break;

                case "4": //Dividir
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el dividiendo: ");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el divisor: ");
                    num2 = sc.nextDouble();
                    if (num2 != 0.0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Error: No se puede dividir por cero.");
                    }
                    break;
                case "5": //Salir
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no valida.Elige una opción del 1 al 5.");
            }
        }while (!opcion.equals("5"));
    }
}