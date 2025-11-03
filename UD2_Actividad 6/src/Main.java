import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Ejercicio 1
        System.out.println("Ejercicio 1");
        Scanner sc = new Scanner(System.in);

        int filas = 5;
        int columnas = 5;

        int[][] matriz1 = new int[filas][columnas];

        int contador = 1;

        System.out.println("---Matriz de 5x5 con numeros del 1 al 25---");

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                matriz1[i][j] = contador;
                contador++;
            }
        }
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                System.out.print(matriz1[i][j]);

            }
            System.out.println();
        }

        //Ejercicio 2
        System.out.println("Ejercicio 2");
        sc = new Scanner(System.in);

        int filas1 = 10;
        int columnas1 = 10;

        int[][] tablas = new int[filas1][columnas1];

        int contador1 = 1;

        for (int i = 0; i < tablas.length; i++){
            for (int j = 0; j < tablas[i].length; j++){
                tablas[i][j] = (i + 1) * (j + 1);
                System.out.print(tablas[i][j] + " ");

            }
            System.out.print();
        }

//    }
//        //Ejercicio 3
//        System.out.println("Ejercicio 3");
//        sc = new Scanner(System.in);
//
//        int filas2 = 0;
//        int columnas2 = 0;
//
//        int mayor = 0;
//        int menor = 0;
//        int igual = 0;
//
//        System.out.println("Introduzca el numero de filas: ");
//        filas2 = sc.nextInt();
//
//        System.out.println("Introduzca el numero de columnas: ");
//        columnas2 = sc.nextInt();
//
//        int[][] tablas2 = new int[filas2][columnas2];
//
//        for (int i = 0; i < tablas2.length; i++){
//            for (int j = 0; j < tablas2[i].length; j++){
//                System.out.println("Introduzca el valor ["+i+"]"+"["+j+"]");
//                tablas2[i][j] = sc.nextInt();
//            }
//        }
//
//
//        for (int i = 0; i < tablas2.length; i++){
//            for (int j = 0; j < tablas2[i].length; j++){
//
//                if(tablas2[i][j] > 0){
//                    mayor++;
//                } else if (tablas2[i][j] < 0) {
//                    menor++;
//                }else{
//                    igual++;
//                }
//            }
//        }
//
//        System.out.println("La cantidad de números que son mayor que cero es: " + mayor);
//        System.out.println("La cantidad de números que son menores que cero es: " + menor);
//        System.out.println("La cantidad de números que son iguales que cero es: " + igual);

        //Ejercicio4
        System.out.println("Ejercicio 4");
        sc = new Scanner(System.in);

        int alumnos = 4;
        int asignaturas = 5;

        double[][] notas = new double[alumnos][asignaturas];

        System.out.println("Introduzca las notas de 0 a 10");

        for (int i = 0; i < alumnos; i++){
            System.out.println("Alumno " + (i + 1) + " ==");

            for (int j = 0; j < asignaturas; j++){
                System.out.print("Introduce la nota para la asignatura " + (j + 1) + ": ";
                notas[i][j] = sc.nextDouble();
            }
        }
        for (int i = 0; i < alumnos; i++){
            double suma = 0.0;
            double notaMinima = notas[i][0];
            double notaMaxima = notas[i][0];

            for (int j = 0; j < asignaturas; j++){
                suma = suma + notas[i][j];

                if (notas[i][j] > notaMaxima){
                    notaMaxima = notas[i][j];
                }
                if (notas[i][j] < notaMinima){
                    notaMaxima = notas[i][j];
                }
            }
            double media = suma / asignaturas;

            System.out.println("La nota maxima: " + notaMaxima);

        }

    }
}