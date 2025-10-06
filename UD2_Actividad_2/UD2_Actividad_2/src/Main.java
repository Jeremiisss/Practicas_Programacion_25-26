import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ejercicio 1

        System.out.println("Ejercicio1\n");

        System.out.println("Escriba tu edad");
        int edad = sc.nextInt();

        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }


        //Ejercicio 2
        System.out.println("Ejercicio2\n");

        System.out.println("Introduce tu edad");
        int edad2 = sc.nextInt();

        if (edad2 >= 18) {
            System.out.println("Eres mayor de edad");
        }
        else{
            System.out.println("Eres menor de edad");
        }

        //Ejercicio 3
        System.out.println("Ejercicio 3\n");

        int sumaN = 1 ;
        for (int i = 1; i <= 20; i++) {
            System.out.println("El numero es " +i);

        }

        //Ejercicio 4
        System.out.println("Ejercicio 4\n");

        int pares = 2 ;
        for (int i = 2; i <= 200; i += 2) {
            System.out.println("El numero es " + i );
        }

        //Ejercicio 5
        System.out.println("Ejercicio 5\n");

        int pares2 = 0 ;
        for (int i = 1; i <= 200; i ++) {
            System.out.println("El numero es " + i );
        }
    }
}