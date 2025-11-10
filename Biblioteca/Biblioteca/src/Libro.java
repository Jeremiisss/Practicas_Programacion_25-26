public class Libro {
    //Atributos o campos de la clase (encapsulacion)

    private String titulo;
    private String autor;
    private int nPaginas;
    private String ISBN;
    private String editora;
    private String fechaPublicacion;
    private int edicion;

    //Constructor / Constructores
    //Constructor con atributos  imprescindibles
    public Libro(String titulo, String autor, String ISBN, String fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = 1;
        this.nPaginas = 1;
        this.editora = "Auto-Publicacion";
    }
    //Constructor con todos los atributos
    public Libro(String titulo, String autor, String ISBN,String fechaPublicacion,
                 String editora, int edicion, int nPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.editora = editora;
        this.edicion = edicion;
        this.setnPaginas(nPaginas);
        this.fechaPublicacion = fechaPublicacion;
    }

    /*
        Definimos los Getter y Setter de los atributos
     */

    public String getTitulo() {
        return this.titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    public String getISBN() {
        return this.ISBN;
    }
    public String getFechaPublicacion() {
        return this.fechaPublicacion;
    }
    public int getEdicion() {
        return this.edicion;
    }
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
    public int getNpaginas() {
        return this.nPaginas;
    }
    public void setnPaginas(int nPaginas) {
        if (nPaginas > 0) {
            this.nPaginas = nPaginas;
        }
    }
    public String getEditora() {
        return this.editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }

    //Metodos
    /**
     *  Metodo: Mostrar informacion del Libro
     */
    public String infoLibro() {
        String infoLibro = "";
        infoLibro = "Titulo: " + this.titulo + "\n";
        infoLibro = "Autor: " + this.autor + "\n";
        infoLibro = "ISBN: " + this.ISBN + "\n";
        infoLibro = "Fecha de publicacion: " + this.fechaPublicacion + "\n";
        infoLibro = "Editora: " + this.editora + "\n";
        infoLibro = "Edicion: " + this.edicion + "\n";
        infoLibro = "NPaginas: " + this.nPaginas + "\n";

        //Opcion alternativa que es un String.format
        String info = String.format("Libro - Titulo: %s, Autor: %s, Fecha publicacion: %s, Numero de paginas: %s, Edicion: %s, Editora: %s, ISBN:%s",
                this.titulo, this.autor, this.fechaPublicacion, this.nPaginas, this.edicion, this.editora, this.ISBN);

        return infoLibro;
    }
}
