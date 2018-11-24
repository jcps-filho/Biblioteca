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
public class AlunoDAO {
    
    public void salvar(Aluno aluno) throws IOException {
		
	String matricula = aluno.getMatricula();
		
	try {
			
            FileOutputStream fos = new FileOutputStream(matricula);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(aluno);
            oos.close();    
            fos.close();
			
        } catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	}	
}
	
    public Aluno consultar(String matricula) {
		
	try {
            FileInputStream fis = new FileInputStream(matricula);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Aluno aluno;
            aluno = (Aluno) ois.readObject();
            ois.close();
            fis.close();
            return aluno;
            
	} catch (FileNotFoundException e) {
            System.out.println("O sistema n�o pode encontrar o arquivo especificado.");
	} catch (IOException e) {
            e.printStackTrace();
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
	} catch (ClassCastException e) {
			System.out.println("A matr�cula informada n�o existe ou est� incorreta.");
	}
	return null;
    }

} 