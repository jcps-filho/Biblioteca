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
    
    public boolean checkLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }

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
    	if(checkLetters(autor)) {
			this.autor = autor;
		} else {
			System.out.println("Neste campo não é permitido números ou caracteres especiais!");
		}
        
    }
      
}
