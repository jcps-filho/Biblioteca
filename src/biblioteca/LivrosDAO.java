package biblioteca;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;

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
            System.out.println("Erro na cria��o do arquivo!");
	} catch (IOException e) {
            System.out.println("Erro na cria��o do arquivo!");
	} catch (NullPointerException e) {
			System.out.println("O arquivo n�o pode estar em branco");
	} catch (InputMismatchException e) {
			System.out.println("Erro na cria��o do arquivo, o nome digitado � invalido!");
	} catch (Exception e) {
		System.out.println("Erro inesperado!");
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
            System.out.println("O sistema n�o pode encontrar o arquivo especificado.");
	} catch (IOException e) {
            System.out.println("Erro na leitura do arquivo, o c�digo informado n�o existe ou est� incorreto!");
	} catch (ClassNotFoundException e) {
            System.out.println("Erro na leitura do arquivo!");
	} catch (ClassCastException e) {
			System.out.println("O c�digo informado n�o existe ou est� incorreto.");
	} catch (Exception e) {
		System.out.println("Erro inesperado!");
	}
	return null;
    }

} 

