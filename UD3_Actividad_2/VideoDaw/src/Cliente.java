import java.time.LocalDate;

public class Cliente {
    private static boolean validarDNIFormato(String dni) {
        if (dni == null || dni.length() != 9) return false;
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(dni.charAt(i))) return false;
        }
        char letra = dni.charAt(8);
        if (!Character.isLetter(letra)) return false;
        // opcional: convertir a mayúscula
        letra = Character.toUpperCase(letra);
        return true;
    }
    private String nombre;
    private int NumSocio;
    private String Direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private

}