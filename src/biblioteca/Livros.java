package biblioteca;
import java.io.Serializable;
/**
 *
 * @author Carlos
 */
public class Livros implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 2L;
    
    private String isbn;
    private String titulo;
    private String autor;

    @Override
    public String toString() {
        return "Livro{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
      
}
