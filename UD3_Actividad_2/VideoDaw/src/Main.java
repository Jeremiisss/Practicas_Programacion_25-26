import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
    private static boolean validarDNI (String DNI){
        String validador = "[0-9]{8}[A-Z]$";
        return Pattern.matches(validador, DNI);
    }
}