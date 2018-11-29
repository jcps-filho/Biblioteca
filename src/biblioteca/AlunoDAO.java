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
    	System.out.println("Insira uma matrícula valida!");
	} catch (IOException e) {
        System.out.println("Erro na entrada de informação!");
	} catch (Exception e) {
		System.out.println("Erro inesperado!");
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
            System.out.println("O sistema não pode encontrar o arquivo especificado!");
	} catch (IOException e) {
            System.out.println("Erro na entrada de informação!");
	} catch (ClassNotFoundException e) {
            System.out.println("Erro na leitura do arquivo, a matrícula informada não existe ou está incorreta!");
	} catch (ClassCastException e) {
			System.out.println("Erro na leitura do arquivo, a matrícula informada não existe ou está incorreta!");
	} catch (Exception e){
		System.out.println("Erro insperado!");
	}
	return null;
    }

} 