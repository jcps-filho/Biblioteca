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

    @Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if(matricula == "" || matricula == null) {
			System.out.println("O matrícula precisa ser informada!");
		} else {
			this.matricula = matricula;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == "" || nome == null) {
			System.out.println("O nome precisa ser informado!");
		} else {
			this.nome = nome;
		}
	}
}
   
