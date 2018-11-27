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
public class RegistroDAO {
    
    public void salvar(Registro registro) throws IOException {
		
	String id = registro.getId(); 
		
	try {
			
            FileOutputStream fos = new FileOutputStream(id);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(registro);
            oos.close();    
            fos.close();
			
    } catch (FileNotFoundException e) {
            System.out.println("Erro na cria��o do arquivo! ");
	} catch (IOException e) {
            System.out.println("Erro na cria��o do arquivo! ");
	} catch (NullPointerException e) {
			System.out.println("Erro na cria��o do aquivo!");
	} catch (Exception e) {
			System.out.println("Erro inesperado!");
	}
}
	
    public Registro consultar(String id) {
		
	try {
            FileInputStream fis = new FileInputStream(id);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Registro registro;
            registro = (Registro) ois.readObject();
            ois.close();
            fis.close();
            return registro;
            
	} catch (FileNotFoundException e) {
            System.out.println("O sistema n�o pode encontrar o arquivo especificado!");
	} catch (IOException e) {
            System.out.println("Erro na leitura do arquivo, o c�digo informado n�o existe ou est� incorreto!");
	} catch (ClassNotFoundException e) {
           System.out.println("Erro na leitura do arquivo, o c�digo informado n�o existe ou est� incorreto!");
	} catch (ClassCastException e) {
		System.out.println("Erro na leitura do arquivo, o c�digo informado n�o existe ou est� incorreto!");
	} catch (Exception e) {
		System.out.println("Erro inesperado!");
	}
	return null;
    }

} 