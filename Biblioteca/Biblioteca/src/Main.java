import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Biblioteca biblio = new Biblioteca("Bib001", "BMS Jado"
                ,"Paseo de Altamira 23","Info@bmsjado.es","942-20-23-25");

        Libro l1 = new Libro("La comunidad del anillo", "JRR Tolkien", "ISBN123", "23-7-1942");
        Libro l2 = new Libro("Las dos torres", "JRR Tolkien", "ISBN456", "23-7-1944");
        Libro l3 = new Libro("El retorno del Rey", "JRR Tolkien", "ISBN789", "23-7-1946");
        Libro l4 = new Libro("Juego de tronos", "GRR Martin", "ISBN976", "23-7-1947");

        boolean estado = biblio.insertarLibro(l1);
        if(estado) {
            System.out.println("Libro insertado");
        }else  {
            System.out.println("Libro no insertado");
        }
        estado = biblio.insertarLibro(l2);
        estado = biblio.insertarLibro(l3);
        estado = biblio.insertarLibro(l4);

        /*
        Insertar un libro por teclado
         */

        Scanner sc = new Scanner(System.in);
        String titulo = "", autor = "", ISBN ="", fechaPublicacion ="";
        System.out.print("Ingrese el titulo del libro: ");
        titulo = sc.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        autor = sc.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        ISBN = sc.nextLine();
        System.out.print("Ingrese el fecha del libro: ");
        fechaPublicacion = sc.nextLine();

        Libro lTeclado = new Libro(titulo,autor,ISBN,fechaPublicacion);
        biblio.insertarLibro(lTeclado);

        System.out.println(biblio.infoBiblioteca());

        System.out.println(biblio.infoLibros());

        biblio.eliminarLibro(l2);

        boolean isElimnado = biblio.eliminarLibro(l2);
        if(isElimnado) {
            System.out.println("Libro eliminado");
        }

        l1.setnPaginas(537);
        l3.setnPaginas(645);

        System.out.println(biblio.infoLibros());

        sc = new Scanner(System.in);
        System.out.print("Ingrese el ISBN del libro que desea eliminar: ");
        String isbnEliminar = sc.nextLine();

        Libro lEliminar = biblio.getLibroByISBN(isbnEliminar);
        biblio.eliminarLibro(lEliminar);
    }
}