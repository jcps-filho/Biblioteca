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
    private static final long serialVersionUID = 3L;
    
    private String codigo;
    private String matricula;
    private String id;
    private String dataEmprestimo;
    private String dataDevolucao;
    
    
    public boolean checkLetters(String str) {
        return str.matches("[1-9]+");
    }

	@Override
	public String toString() {
		return "Registro [codigo=" + codigo + ", matricula=" + matricula + ", id=" + id + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucao=" + dataDevolucao + "]";
	}



	public String getDataEmprestimo() {
		return dataEmprestimo;
	}



	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}



	public String getDataDevolucao() {
		return dataDevolucao;
	}



	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		if(checkLetters(matricula)) {
			this.matricula = matricula;
		} else {
			System.out.println("Neste campo não é permitido letras ou caracteres especiais!");
		}
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	
}