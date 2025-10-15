import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ejercicio 1
        System.out.println("Ejercicio 1");

        System.out.println("Introduce una cantidad multiplo de 5: ");
        int cantidad = sc.nextInt();

        if (cantidad % 5 != 0){
            System.out.println("La cantidad debe ser multiplo de 5.");
        } else {
            int [] billetes = {500, 200, 100,50, 20, 10, 5};
            int [] cantidadBilletes = new int[billetes.length];

            int resto = cantidad;

            for (int i = 0; i < billetes.length; i++);
            {
                cantidadBilletes[i] = resto / billetes[i];
                resto = resto % billetes[i];
            }
        }
    }
}