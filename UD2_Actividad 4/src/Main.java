import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        System.out.println("Ejercicio 1");
        Scanner scanner = new Scanner(System.in);

        int tamano_array =10;
        double[] numeros = new double[tamano_array];

        System.out.println("Por favor, introduce" + tamano_array + "numeros reales");

        for (int i = 0; i <tamano_array; i++){
            System.out.println("Introduce un numero real");
            numeros[i] = scanner.nextDouble();
        }
        System.out.println("Los números introducidos son: ");

        for (int i = 0; i < tamano_array; i++) {
            System.out.println("Numero " + (i + 1) + ": " + numeros[i]);
        }

        //Ejercicio 2
        System.out.println("Ejercicio 2");
        Scanner scanner1 = new Scanner(System.in);

        int tamano_array1 =10;
        double[] numeros1 = new double[tamano_array1];
        double sumaTotal = 0.0;

        System.out.println("Por favor, introduce " + tamano_array1 + " numeros reales");

        for (int i = 0; i <tamano_array1; i++){
            System.out.println("Introduce un numero real " + (i + 1) + ": ");
            numeros1[i] = scanner1.nextDouble();

            sumaTotal += numeros1[i];
        }
        System.out.println("La suma de todos los números introducidos es: ");

        for (int i = 0; i < tamano_array1; i++) {
            System.out.println("Numero " + (i + 1) + ": " + numeros1[i]);
        }
        System.out.println("La suma total de los numeros es: " +sumaTotal );

        //Ejercicio 3
        System.out.println("Ejercicio 3");
        Scanner scanner2 = new Scanner(System.in);

        int tamano_array2 =10;
        double[] numeros2 = new double[tamano_array2];
        double minimo = Double.MAX_VALUE;
        double maximo = Double.MIN_VALUE;

        System.out.println("Por favor, introduce " + tamano_array2 + " numeros reales");

        for (int i = 0; i <tamano_array2; i++) {
            System.out.println("Introduce un numero real " + (i + 1) + ": ");
            numeros2[i] = scanner2.nextDouble();
        }

        for (int i = 0; i < tamano_array2; i++) {
            if (numeros2[i] > maximo){
                maximo = numeros2[i];
            }
            if (numeros2[i] < minimo){
                minimo = numeros2[i];
            }
        }
        System.out.println("El número máximo introducido es: " + maximo );
        System.out.println("El número mínimo introducido es: " + minimo);

        //Ejercicio 4
        System.out.println("Ejercicio 4");
        Scanner scanner3 = new Scanner(System.in);

        int tamano_array3 =20;
        int[] numeros3 = new int[tamano_array3];

        int sumaPositivos = 0;
        int sumaNegativos = 0;

        System.out.println("Por favor, introduce " + tamano_array3 + " numeros enteros");

        for (int i = 0; i <tamano_array3; i++){
            System.out.println("Introduce un numero entero " + (i + 1) + ": ");
            numeros3[i] = scanner3.nextInt();
            if (numeros3[i] >= 0){
                sumaPositivos += numeros3[i];
            }
            else {
                sumaNegativos += numeros3[i];
            }
        }

        System.out.println("Suma de los números positivos: " +sumaPositivos );
        System.out.println("Suma de los números positivos: " +sumaNegativos );

        //Ejercicio 5
        System.out.println("Ejercicio 5");
        Scanner scanner4 = new Scanner(System.in);

        double[] numerosReales5 = new double[10];
        double suma5 = 0.0;

        for (int i = 0; i < numerosReales5.length; i++){
            System.out.println("Introduce el numero real " + (i + 1) + ": ");
            numerosReales5[i] = scanner4.nextDouble();
        }

        System.out.println("Suma total de los numeros: " + suma5);
        System.out.println("Media de los números: " + suma5 / numerosReales5.length);

        //Ejercicio 6
        System.out.println("Ejercicio 6");
        scanner4 = new Scanner(System.in);
        System.out.println("Introduce el valor N");
        int n = scanner4.nextInt();
        System.out.println("Introduce el valor M");
        double m = scanner4.nextDouble();

        if (n > 0){
            double arrayN [] = new double[n];
            Arrays.fill(arrayN, m);
            System.out.println(Arrays.toString(arrayN));
//            for (int i = 0; i < arrayN.length; i++){
//                arrayN[i] = m;
//                System.out.println(arrayN[i]);
//            }
        }else {
            System.out.println("No se puede crear arrays negativos");
        }

        //Ejercicio 7
        System.out.println("Ejercicio 7");
        scanner4 = new Scanner(System.in);
        System.out.println("Introduce el valor de P");
        int p = scanner4.nextInt();
        System.out.println("Introduce el valor de Q");
        int q = scanner4.nextInt();

        int [] numeros7 = new int[(q-p-1)];
        for (int i = 0; i <numeros7.length; i++ ){
            numeros7[i] = p + (i+1);
            System.out.println(numeros7[i]);
        }

        //Ejercicio 8
        scanner4 = new Scanner(System.in);
        double numeros8[] = new double[100];

        for (int i = 0; i < numeros8.length; i++);{
            numeros8 [i] = Math.random();
        }
        System.out.println("Introduce el valor de R (entre 0 y 1)");
        double r = scanner4.nextDouble();
        int contadorMayores = 0, contadorMenores = 0;

        for (int i = 0; i < numeros8.length; i++){
            if (numeros8 [i] >= r){
                contadorMayores++;
            }
            else {
                contadorMenores++;
            }
        }
        System.out.println();

        //Ejercicio 9
        scanner4 = new Scanner(System.in);
        int numeros9[] = new int[100];

        for (int i = 0; i < numeros9.length; i++);{
            numeros9 [i] = (int) (Math.random() * 10 + 1);
        }
        System.out.println("Introduce el valor N");
        int nBuscar = scanner4.nextInt();

        for (int i = 0; i < numeros9.length; i++){
            if (numeros9[i] == nBuscar){
                System.out.println("Aparece en la posicion: " +i);
            }
        }
        //Ejercicio 10
        scanner4 = new Scanner(System.in);
        System.out.println("Introduce el valor de N");
        int nAlturas = scanner4.nextInt();
        double [] alturas = new double[nAlturas];
        double sumaAlturas = 0.0, mediaAlturas = 0.0, maximaAlturas = Double.MIN_VALUE, minimaAlturas = Double.MAX_VALUE;

        for (int i = 0; i < alturas.length; i++){
            System.out.println("Introduce el valor de la altura " + (i+1) + ": ");
            alturas[i] = scanner4.nextDouble();
            sumaAlturas += alturas[i];
        }

        mediaAlturas = sumaAlturas / alturas.length;

        int contadorAlturas = 0;
        for (int i = 0; i < alturas.length; i++){
            maximaAlturas = Math.max(alturas[i], maximaAlturas);
            minimaAlturas = Math.min(alturas[i], minimaAlturas);
            if (alturas[i] >= mediaAlturas){
                contadorAlturas++;
            }
        }
        System.out.println("La media es: " + mediaAlturas);
        System.out.println("la altura maxima es: " + maximaAlturas);
        System.out.println("La altura minima es: " + minimaAlturas);
    }
}