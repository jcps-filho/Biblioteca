package biblioteca;
import java.io.Serializable;
/**
 *
 * @author Carlos
 */
public class Registro implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String matricula;
    private String id;

	@Override
	public String toString() {
		return "Registro [codigo ISBN=" + codigo + ", matricula=" + matricula + ", id=" + id + "]";
	}


	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String titulo) {
		this.codigo = titulo;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String aluno) {
		this.matricula = aluno;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	
}