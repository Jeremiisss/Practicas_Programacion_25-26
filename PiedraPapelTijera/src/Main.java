import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Piedra papel y tijera");
        Scanner sc = new Scanner(System.in);
        Random random = new Random(); //jugada aleatoria ordenador

        //variables para guardar los puntos
        int victorias = 0;
        int derrotas = 0;
        int empates = 0;

        //Instrucciones

        System.out.println("Bienvenido a Piedra, Papel o Tijera prime");
        System.out.println("Reglas: letra (P para piedra, L para papel, T para tijeras, \n" +
                "o S para salir terminando la partida)");

        //Bucle juego
        //el bucle while (true) es un bucle infinito que se repetira hasta que le digamos que pare con un 'break'

        while (true) {

            //Ordenador
            int numeroAleatorio = random.nextInt(3);
            char jugadaOrdenador; //variable para guardar la opcion del ordenador

            if (numeroAleatorio == 0){
                jugadaOrdenador = 'p'; //si sale 0, el ordenador elige Piedra
            } else if (numeroAleatorio == 1) {
                jugadaOrdenador = 'l'; // si sale 1, el ordenador elige Papel
            }else {
                jugadaOrdenador = 't';//si no es 0 ni 1,el ordenador elige tijera
            }

            //Usuario
            System.out.println("Introduce tu jugada (P, L, T) o s para salir: ");

            String entrada = sc.next();
            char jugadaUsuario = Character.toLowerCase(entrada.charAt(0));

            //Comprobamos si el usuario quiere salir
            if (jugadaUsuario == 's'){
                System.out.println("Has elegido salir. !El juego ha terminado¡");
                break;
            }

            //Mostrar jugadas
            String textoUsuario; //variable para guardar el nombre de la jugada del usuario
            String textoOrdenador; //lo mismo que el anterior pero del ordenador

            //convertimos la letra que introducio el usuario en palabra
            if (jugadaUsuario == 'p') {
                textoUsuario = "Piedra";
            } else if (jugadaUsuario == 'l') {
                textoUsuario = "Papel";
            }else {
                textoUsuario = "Tijera";
            }

            //hacemos lo mismo para las jugadas del ordenador
            if (jugadaOrdenador == 'p') {
                textoOrdenador = "Piedra";
            } else if (jugadaOrdenador == 'l') {
                textoOrdenador = "Papel";
            }else {
                textoOrdenador = "Tijera";
            }
            
            System.out.println("Has elegido: " +textoUsuario);
            System.out.println("El ordenador ha elegido: " + textoOrdenador);

            //Resultado
            
            if (jugadaUsuario == jugadaOrdenador){
                System.out.println("Resultado: ¡EMPATE!");
                empates++; // suma 1 a la variable de empates
            } else if ((jugadaUsuario == 'p' && jugadaOrdenador == 't') ||
                        (jugadaUsuario == 'l' && jugadaOrdenador == 'p')||
                        (jugadaUsuario == 't' && jugadaOrdenador == 'l')){
                System.out.println("Resultado: ¡Has ganado!");
                victorias++; //suma 1 a la variable victorias

            //Si hemos perdido hara eso
            }else {
                System.out.println("Resultado: ¡Has perdido!");
                derrotas++;
            }
        }// Fin While

        //Resultados

        System.out.println("");

    }// Fin
}