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
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	} catch (NullPointerException e) {
			e.printStackTrace();
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
            System.out.println("O sistema não pode encontrar o arquivo especificado");
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