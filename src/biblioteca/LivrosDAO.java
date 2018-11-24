package biblioteca;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Carlos
 */
public class LivrosDAO {
    
    public void salvar(Livros livros) throws IOException {
		
	String isbn = livros.getIsbn();
		
	try {
			
            FileOutputStream fos = new FileOutputStream(isbn);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(livros);
            oos.close();    
            fos.close();
			
        } catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	}	
}
	
    public Livros consultar(String isbn) {
		
	try {
            FileInputStream fis = new FileInputStream(isbn);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Livros livros;
            livros = (Livros) ois.readObject();
            ois.close();
            fis.close();
            return livros;
            
	} catch (FileNotFoundException e) {
            System.out.println("O sistema não pode encontrar o arquivo especificado.");
	} catch (IOException e) {
            e.printStackTrace();
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
	} catch (ClassCastException e) {
			System.out.println("O código informado não existe ou está incorreto.");
	}
	return null;
    }

} 

