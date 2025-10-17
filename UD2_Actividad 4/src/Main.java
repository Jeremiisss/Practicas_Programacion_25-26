import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        System.out.println("Ejercicio 1");
        Scanner Scanner = new Scanner(System.in);

        int tamano_array =10;
        double[] numeros = new double[tamano_array];

        System.out.println("Por favor, introduce" + tamano_array + "numeros reales");

        for (int i = 0; i <tamano_array; i++){
            System.out.println("Introduce un numero real");
            numeros[i] = Scanner.nextDouble();
        }
        System.out.println("Los números introducidos son: ");

        for (int i = 0; i < tamano_array; i++) {
            System.out.println("Numero " + (i + 1) + ": " + numeros[i]);
        }

        //Ejercicio 2
        System.out.println("Ejercicio 2");
        Scanner = new Scanner(System.in);

        int tamano_array =10;
        double[] numeros = new double[tamano_array];
        double sumaTotal = 0.0;

        System.out.println("Por favor, introduce" + tamano_array + "numeros reales");

        for (int i = 0; i <tamano_array; i++){
            System.out.println("Introduce un numero real" + (i + 1) + ": ");
            numeros[i] = Scanner.nextDouble();

            sumaTotal += numeros[i];
        }
        System.out.println("La suma de todos los números introducidos es: ");

        for (int i = 0; i < tamano_array; i++) {
            System.out.println("Numero " + (i + 1) + ": " + numeros[i]);
        }

    }
}