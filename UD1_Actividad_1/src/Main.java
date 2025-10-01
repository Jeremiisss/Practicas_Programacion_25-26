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
        System.out.println("Ejercicio 06");
        Scanner sc4 = new Scanner(System.in);

        System.out.println("Precio de articulo");
        double precio_articulo = sc4.nextDouble();

        System.out.println("Precio de venta");
        double precio_venta = sc4.nextDouble();

        System.out.println("Precio con descuento " + ((precio_articulo - precio_venta) / precio_articulo) * 100);

        //Ejercicio 7
        System.out.println("Ejercicio 07");
        Scanner sc5 = new Scanner(System.in);

        System.out.println("Escriba la distancia en millas marinas");
        double millas = sc5.nextDouble();

        System.out.println("La distancia en metros " + millas * 1.852 );

        //Ejercicio 8
        System.out.println("Ejercicio 08");
        Scanner sc6 = new Scanner(System.in);

        System.out.println("Escriba numero uno");
        double numerouno = sc6.nextDouble();

        System.out.println("Escriba numero dos");
        double numerodos = sc6.nextDouble();

        double maximo = Math.max(numerouno, numerodos);
        double minimo = Math.min(numerouno, numerodos);

        System.out.println("Resultado " + minimo + " " + maximo);


        //Ejercicio 9
        System.out.println("Ejercicio 09");
        Scanner sc7 = new Scanner(System.in);

        System.out.println("Escriba numero uno");
        double numero1 = sc7.nextDouble();

        System.out.println("Escriba numero dos");
        double numero2 = sc7.nextDouble();

        System.out.println("Numero uno es mayor que numero dos " + (numero1 > numero2));
        System.out.println("Numero dos es mayor que numero uno " + (numero1 < numero2));
        System.out.println("Numero uno es igual que numero dos " + (numero1 == numero2));

        //Ejercicio 10
        System.out.println("Ejercicio 10");
        Scanner sc8 = new Scanner(System.in);

        System.out.println("Escribir numero uno ");
        double uno = sc8.nextDouble();

        System.out.println("Escribir numero dos ");
        double dos = sc8.nextDouble();

        System.out.println("Escribir numero tres ");
        double tres = sc8.nextDouble();

        double maximo1 = Math.max( uno, dos);
        double maximo2 = Math.max( dos, tres);
        double maximo3 = Math.max(maximo1, maximo2);

        System.out.println("El numero mayor es el " + maximo3);

        //Ejercicio 11
        System.out.println("Ejercicio 11");
        Scanner sc9 = new Scanner(System.in);

        System.out.println("Introduce el valor del primer numero");
        double num3 = sc9.nextDouble();

        System.out.println("Introduce el valor del segundo numero No se puede ultilizar el 0");
        double num4 = sc9.nextDouble();

        System.out.println("La suma es" + (num1 + num2));
        System.out.println("La resta es" + (num1 - num2));
        System.out.println("La multiplicacion es" + (num1 * num2));
        System.out.println("La division es" + (num1 / num2));

        //Ejercicio 12
        System.out.println("Ejercicio 12");
        Scanner sc10 = new Scanner(System.in);

        System.out.println("Numero uno ");
        double num5 = sc10.nextDouble();

        System.out.println("Escriba numero dos");
        double num6 = sc6.nextDouble();

        System.out.println("Resultado " + Math.max(num5, num6) );

        //Ejercicio 13
        System.out.println("Ejercicio 13");
        Scanner sc11 = new Scanner(System.in);

        System.out.println("Un numero");
        double num7 = sc11.nextDouble();

        System.out.println("El valor es " + (num7 >= 0));

    }

}