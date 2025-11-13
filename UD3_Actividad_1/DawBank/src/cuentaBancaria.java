public class cuentaBancaria {

    //Constante
    private static final int maxMovimientos=100;
    private static final double minSaldo=50.0;
    private static final double aviso=3000.0;

    //Atributos encapsulados
    private String IBAN;
    private String Titular;
    private double Saldo;
    private boolean esValido;

    private Movimiento[]movimientos;



    //Constructor
    public cuentaBancaria(String IBAN, String Titular, double Saldo, String Movimientos){
        if (IBAN.matches("^[A-Z]{2}\\d{22}$")){
            this.IBAN=IBAN;
        }else {
            System.out.println("Error: IBAN invalido. Debe contener 2 letras y 22 numeros");
            this.IBAN="IBAN no valido";
        }

        //El titular no puede estar vacio
        if(Titular == null || Titular.trim().isEmpty()){
            this.Titular="Titular no valido";
            this.esValida
        }

        this.Titular=Titular;
        this.Saldo=Saldo;
        this.Movimientos=Movimientos;
    }
    //Getter
    public String getIBAN() {
        return IBAN;
    }


}//final class