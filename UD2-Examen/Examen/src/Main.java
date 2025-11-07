import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Examen");

        Scanner sc = new Scanner(System.in);
        int num = 0;
        double suma = 0.0, maximoColeccion = Integer.MIN_VALUE, minimoColeccion = Integer.MAX_VALUE;
        int contadorPosicion = 0;
        int media = 0;



        System.out.print("Introduce el total de numero a almacenar: \n");
        num = sc.nextInt();

        int[] tamanoColeccion = new int[num];
        String opcion = "4";

        do {
            System.out.println("Elige una opcion: \n");
            System.out.println("1. Modificar coleccion");
            System.out.println("2. Estadisticas");
            System.out.println("3. Ampliar el valor de la coleccion");
            System.out.println("4. Salir");

            opcion = sc.next();
            switch (opcion) {
                case "1": // Modificar coleccion

                    System.out.println("Insertar numero pulse 1, borrar numero pulse 2 y modificar pulse 3: ");
                    num = sc.nextInt();
                    if (num == 1) {
                        sc = new Scanner(System.in);
                        int num2 = 0;
                        System.out.println("¿Deseas almacenar en una posicion especifica? 0 = no y 1 = si: ");
                        num2 = sc.nextInt();
                        if (num2 == 1) {
                            System.out.println("Introduce la posicion donde quieres guardar el valor: ");
                            contadorPosicion = sc.nextInt();
                            System.out.println("Introducir el valor");
                            if(contadorPosicion < tamanoColeccion.length || contadorPosicion > num){
                                tamanoColeccion[contadorPosicion] = sc.nextInt();
                                suma += tamanoColeccion[contadorPosicion];
                            }
                        }else if (num2 == 0) {
                            System.out.println("Introducir el valor");
                            tamanoColeccion[contadorPosicion] = sc.nextInt();
                            break;
                        }
                    }else if (num == 2) {

                    }
                        break;

                case "2":
                    for (int i = 0; i < tamanoColeccion.length; i++) {
                        maximoColeccion = Math.max(tamanoColeccion[i], maximoColeccion);
                        minimoColeccion = Math.min(tamanoColeccion[i], minimoColeccion);
                        media = (tamanoColeccion[i] / tamanoColeccion[i]);
                        suma += tamanoColeccion[i];
                        System.out.println("La maxima es " + maximoColeccion);
                        System.out.println("El minimo es " + minimoColeccion);
                        System.out.println("La suma es " + suma);
                        System.out.println("El media es " + media);

                    }
                    break;

                case "3":
                    System.out.println(Arrays.toString(tamanoColeccion));
                    break;

                case "4":
                    System.out.print("Hasta luego");
                    break;
                default:
                    System.out.println("Error la opcion introducida debe estar entre 1 y 4");

            }
        }while (!opcion.equals("4"));
    }
}