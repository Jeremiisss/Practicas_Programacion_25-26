import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Ejercicio 1
        System.out.println("Ejercicio 01");
        System.out.println("Buenos dias\n");

        //Ejercicio 2
        System.out.println("Ejercicio 02");
        double lado = 5;
        double area = lado * lado;
        System.out.println("Lado: " + lado);
        System.out.println("Area: " + area);

        //Ejercicio 3
        System.out.println("Ejercicio 03");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el valor del lado del cuadrado");

        double lado2 = sc.nextDouble();
        double area2 = lado2 * lado2;
        System.out.println("Lado: " + lado2);
        System.out.println("Area: " + area2);

        //Ejercicio 4
        System.out.println("Ejercicio 04");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Introduce el valor del primer numero");
        double num1 = sc2.nextDouble();
        System.out.println("Introduce el valor del segundo numero");
        double num2 = sc2.nextDouble();

        System.out.println("La suma es" + (num1 + num2));
        System.out.println("La resta es" + (num1 - num2));
        System.out.println("La multiplicacion es" + (num1 * num2));
        System.out.println("La division es" + (num1 / num2));

        //Ejercicio 5
        System.out.println("Ejercicio 05");
        Scanner sc3 = new Scanner(System.in);

        System.out.println("Radio");
        double radio = sc3.nextDouble();
        System.out.println("Longitud circunferencia: " + (2 * Math.PI * (radio)));
        System.out.println("Area del circulo: " + (Math.PI * (radio * radio)));
        System.out.println("Volumen de la esfera: " + ( 4 * (Math.PI * (radio * radio * radio)))/3);

        //Ejercicio 6
        System.out.println("Ejercicio 07");
        Scanner sc4 = new Scanner(System.in);

        System.out.println("Precio de articulo");
        double precio_articulo = sc4.nextDouble();

        System.out.println("Precio de venta");        Scanner sc = new Scanner(System.in);

        double precio_venta = sc4.nextDouble();

        System.out.println("Precio con descuento " + ((precio_articulo - precio_venta) / precio_venta));

        //Ejercic
    }
}