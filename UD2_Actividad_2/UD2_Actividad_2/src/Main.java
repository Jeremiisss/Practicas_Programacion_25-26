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
        else if (edad2 < 18 && edad2 >= 0){
            System.out.println("Eres menor de edad");
        }
        else {
            System.out.println("La edad no tiene sentido");
        }

        //Ejercicio 3
        System.out.println("Ejercicio 3\n");

        for (int i = 1; i <= 20; i++) {
            System.out.println("El numero es: " +i);

        }

        //Ejercicio 4
        System.out.println("Ejercicio 4\n");

        for (int i = 2; i <= 200; i += 2) {
            System.out.println("El numero par es: " + i );
        }

        //Ejercicio 5
        System.out.println("Ejercicio 5\n");

        for (int i = 1; i <= 200; i ++) {
            if ( i % 2 == 0) {
                System.out.println("El numero es " + i);
            }
        }

        //Ejercicio 6
        sc = new Scanner(System.in);
        System.out.println("Ejercicio 6");

        System.out.println("Escribe un valor");
        int random = sc.nextInt();

        for (int i = 1; i <= random; i++) {
            System.out.println("El numero es: " + i);
        }

        //Ejercicio 7
        sc = new Scanner(System.in);
        System.out.println(System.in);

        System.out.println("Introduce la nota del alumno: ");
        double nota = sc.nextDouble();

        if (nota < 0.0 || nota > 10.0) {
            System.out.println("La nota no puede ser negativa");
        }

        if (nota < 3.0) {
            System.out.println("La nota es MUY DEFICIENTE");
        }

        if (nota >=3.0 && nota < 5) {
            System.out.println("La nota es INSUFICIENTE.");
        }

        if (nota >= 5.0 && nota < 7) {
            System.out.println("La nota es BIEN.");
        }

        if (nota>=7.0 && nota < 9) {
            System.out.println("La nota es NOTABLE.");
        } else if (nota >=9 && nota <= 10) {
            System.out.println("La nota es SOBRESALIENTE");
        }

        //Ejercicio 8
        sc = new Scanner(System.in);
        System.out.println("Ejercicio 8");

        System.out.println("Escribe un valor");
        int N = sc.nextInt();

        int factorial = 1;
            for (int i = 1; i <= N; i++) {
                factorial *= i;
            }
            System.out.println("El factorial es " + factorial);

        //Ejercicio 9
        sc = new Scanner(System.in);
        System.out.println("");
    }
}