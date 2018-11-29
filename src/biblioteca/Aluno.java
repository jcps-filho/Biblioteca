package biblioteca;
import java.io.Serializable;
/**
 *
 * @author Carlos
 */
public class Aluno implements Serializable{	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String matricula;
    private String nome;
    
    public boolean checkLetters(String str) {
        return str.matches("[a-zA-Z áéíóúýãõâôêîû]+");
    } 
    
    public boolean checkNumbers(String str) {
        return str.matches("[0-9]+");
    }

    @Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if(checkNumbers(matricula)) {
			this.matricula = matricula;
		} else {
			System.out.println("Neste campo não é permitido letras ou caracteres especiais!");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(checkLetters(nome)) {
			this.nome = nome;
		} else {
			System.out.println("Neste campo não é permitido números ou caracteres especiais!");
		}
	}
}
   
