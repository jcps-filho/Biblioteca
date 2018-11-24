package biblioteca;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Principal {
    private static Scanner leitor;
	private static Scanner leitor1;
	private static Scanner leitor2;
    public static void main(String[] args) {
        leitor = new Scanner(System.in);
        leitor1 = new Scanner(System.in);
        leitor2 = new Scanner(System.in);
        LivrosDAO dao = new LivrosDAO();
        AlunoDAO dao1 = new AlunoDAO();
        RegistroDAO dao2 = new RegistroDAO();
        Random gerador = new Random();
        int opcao = 1;
        
        do{
            System.out.println("======== Biblioteca ========");
            System.out.println("1- Cadastrar livros;");
            System.out.println("2- Consultar livros;");
            System.out.println("3- Cadastrar aluno;");
            System.out.println("4- Consultar aluno;");
            System.out.println("5- Realizar empréstimo;");
            System.out.println("0- Sair.");
            System.out.printf("Sua opcão: ");
            opcao = leitor.nextInt();
            
            switch(opcao){
                case 1:
                	try {
                    Livros livro = new Livros();
                    System.out.printf("Informe o título: ");
                    livro.setTitulo(leitor.next());
                    System.out.printf("Informe o nome do autor: ");
                    livro.setAutor(leitor1.nextLine());
                    System.out.printf("Informe o código ISBN: ");
                    livro.setIsbn(leitor2.nextLine());
                	
                   
                    dao.salvar(livro);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Erro na criação do arquivo");
                    } catch (InputMismatchException e) {
                    	System.out.println("Erro na criação do arquivo!");
                    }
                    
                    break;
                    
                case 2:
                    String isbn;
                    System.out.println("Informe o código ISBN do livro: ");
                    isbn = leitor.next();

                    Livros con = dao.consultar(isbn);
                    if(con != null) {
                    	System.out.println(con);
                    }
                    break;
                    
                case 3:
                	Aluno aluno = new Aluno();
                    System.out.printf("Informe o nome do aluno: ");
                    aluno.setNome(leitor.next());
                    System.out.printf("Informe a matrícula do aluno: ");
                    aluno.setMatricula(leitor.next());
            
                    try {
                        dao1.salvar(aluno);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 4:
                	String matricula;
                    System.out.printf("Informe a matrícula do aluno: ");
                    matricula = leitor.next();
                    try {
                    	Aluno con1 = dao1.consultar(matricula);
                    	if(con1 != null) {
                        	System.out.println(con1);
                        }
                    } catch(ClassCastException e) {
                    	System.out.println("A matrícula informada está incorreta ou não pode ser encontradada");
                    }
                
                    break;
                    
                case 5:
                	Registro registro = new Registro();
                    System.out.printf("Informe o código isbn do livro: ");
                    registro.setCodigo(leitor.next());
                    System.out.printf("Informe a matrícula do aluno: ");
                    registro.setMatricula(leitor.next()); 
                    registro.setId(Integer.toString(gerador.nextInt(1000)));

            
                    try {
                        dao2.salvar(registro);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    System.out.println("Devolução prevista para 10 dias, código do emprestimo "+ registro.getId());
    
                	break;

                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção Invalida!");
                    break;
            }
        }while(opcao != 0);
    }
    
}
