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
        System.out.println("Ejercicio 9");

        System.out.println("Introduce las horas (0-23)");
        int horas = sc.nextInt();

        System.out.println("Introduce los minutos (0-59)");
        int minutos = sc.nextInt();

        System.out.println("Introduce los segundos (0-59)");
        int segundos = sc.nextInt();

        segundos = segundos + 1;

        if (segundos == 60) {
            segundos = 0;
            minutos = minutos + 1;
        }
        if (minutos == 60){
            minutos = 0;
            horas = horas + 1;
        }
        if (horas == 24){
            horas = 0;
        }
        System.out.println("Hora dentro de un segundo: " + horas + ":" + minutos + ":" + segundos);

        //Ejercicio 10

        sc = new Scanner(System.in);
        System.out.println("Ejercicio 10");

        boolean hayNegativos = false

        for (int i = 1; i <= 10; i ++){
            System.out.println("Introduce un numero distinto de cero: ");
            double numero = sc.nextInt();
            if (numero < 0) {
                hayNegativos = true;
            }
            }
        System.out.println("Hay numeros negativos: " + hayNegativos);

        //Ejercicio 11

        sc = new Scanner(System.in);
        System.out.println("Ejercicio 11");


        int contadorP = 0;
        int contadorN = 0;

        for (int i = 1; i <= 10; i ++){
            System.out.println("Introduce un numero distinto de cero: ");
            double n = sc.nextInt();
            if (n < 0){
                contadorN ++;
            }
            if (n > 0){
                contadorP ++;
            }
        }
        System.out.println("Hay" + contadorN + "numeros negativos y hay " + contadorP + "numeros positivos");

        //Ejercicio 12

        sc = new Scanner(System.in);
        System.out.println("Ejercicio 12");

        int numero2 = 0;
        int numNegativos = 0;
        int numPositivos = 0;

        do {
            System.out.println("Introduce el numero distinto de cero o cero para parar: ");
            numero2 = sc.nextInt();

            if (numero2 < 0){
                numNegativos++;
            }
            if(numero2 > 0){
                numPositivos++;
            }
        } while (numero2 != 0);


        System.out.println("Hay" + numNegativos + "numeros negativos hay " + numPositivos + "numeros positivos: ");

        //Ejercicio 13
        sc = new Scanner(System.in);
        System.out.println("Ejercicio 13");

        int suma = 0;
        int multiplica = 1;

        for (int i = 1; i <= 10; i++) {
            suma += i;
            multiplica *= i;
        }
        System.out.println("La suma de los 10 primeros números naturales es: " + suma);
        System.out.println("La multiplicacion de los 10 primeros números naturales es: " + multiplica);

        //Ejercicio 14
        sc = new Scanner(System.in);
        System.out.println("Ejercicio 14");

        System.out.println("Introduce el nombre del trabajador");
        String nombre = sc.nextLine();

        System.out.println("Introduce el numero de horas trabajadas");
        double horas1 = sc.nextDouble();

        System.out.println("Introduce la tarifa por hora (€): ");
        double tarifa = sc.nextDouble();

        double salariobruto;
        if (horas1 <= 35){
            salariobruto = horas1 * tarifa;
        } else {
            salariobruto = (35 * tarifa) + ((horas1 - 35) * tarifa * 1.5);
        }
        double impuestos;
        if (salariobruto <= 500){
            impuestos = 0;
        } else if (salariobruto <= 900) {
            impuestos = (salariobruto - 500) * 0.25;
        } else {
            impuestos = (400 * 0.25) + ((salariobruto - 900)* 0.45);
        }
        double salarioneto = salariobruto - impuestos;

        System.out.println("");
        System.out.println("Nombre del trabajador: " + nombre);
        System.out.println("Salario bruto: " + salariobruto);
        System.out.println("Impuestos: " + impuestos);
        System.out.println("Salario neto: " + salarioneto );

    }
    }