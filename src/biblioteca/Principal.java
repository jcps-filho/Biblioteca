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
	private static Scanner leitor3;
    public static void main(String[] args) {
        leitor = new Scanner(System.in);
        leitor1 = new Scanner(System.in);
        leitor2 = new Scanner(System.in);
        leitor3 = new Scanner(System.in);
        LivrosDAO dao = new LivrosDAO();
        AlunoDAO dao1 = new AlunoDAO();
        RegistroDAO dao2 = new RegistroDAO();
        Random gerador = new Random();
        String opcao = "";
        
        do{
            System.out.println("======== Biblioteca ========");
            System.out.println("1- Cadastrar livros;");
            System.out.println("2- Consultar livros;");
            System.out.println("3- Cadastrar aluno;");
            System.out.println("4- Consultar aluno;");
            System.out.println("5- Realizar empréstimo;");
            System.out.println("6- Consultar empréstimo;");
            System.out.println("0- Sair.");
            System.out.printf("Sua opcão: ");
            try {
            	opcao = leitor.nextLine();
            } catch(InputMismatchException e) {
            	System.out.println("Opção invalida ou incorreta");
            }
            switch(opcao){
                case "1":
                	try {
                    Livros livro = new Livros();
                    System.out.printf("Informe o título: ");
                    livro.setTitulo(leitor1.nextLine());
                    System.out.printf("Informe o nome do autor: ");
                    livro.setAutor(leitor2.nextLine());
                    System.out.printf("Informe o código ISBN: ");
                    livro.setIsbn(leitor3.nextLine());
                	
                   
                    dao.salvar(livro);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Erro na criação do arquivo");
                    } catch (InputMismatchException e) {
                    	System.out.println("Erro na criação do arquivo!");
                    } catch(Exception e) {
                    	System.out.println("Erro inesperado!");
                    }
                    
                    break;
                    
                case "2":
                    String isbn;
                    System.out.println("Informe o código ISBN do livro: ");
                    isbn = leitor.nextLine();

                    Livros con = dao.consultar(isbn);
                    if(con != null) {
                    	System.out.println(con);
                    }
                    break;
                    
                case "3":
                	Aluno aluno = new Aluno();
                    System.out.printf("Informe o nome do aluno: ");
                    aluno.setNome(leitor.nextLine());
                    System.out.printf("Informe a matrícula do aluno: ");
                    aluno.setMatricula(leitor1.nextLine());
            
                    try {
                        dao1.salvar(aluno);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception e) {
                    	System.out.println("Erro inesperado!");
                    }
                    break;
                case "4":
                	String matricula;
                    System.out.printf("Informe a matrícula do aluno: ");
                    matricula = leitor.nextLine();
                    try {
                    	Aluno con1 = dao1.consultar(matricula);
                    	if(con1 != null) {
                        	System.out.println(con1);
                        }
                    } catch(ClassCastException e) {
                    	System.out.println("A matrícula informada está incorreta ou não pode ser encontradada");
                    }
                
                    break;
                    
                case "5":
                	Registro registro = new Registro();
                    System.out.printf("Informe o código isbn do livro: ");
                    registro.setCodigo(leitor1.nextLine());
                    System.out.printf("Informe a matrícula do aluno: ");
                    registro.setMatricula(leitor2.nextLine()); 
                    registro.setId(Integer.toString(gerador.nextInt(5000)));

            
                    try {
                        dao2.salvar(registro);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    System.out.println("Devolução prevista para 10 dias, código do emprestimo "+ registro.getId());
    
                	break;
                case "6":
                	String codigo;
                	System.out.println("Informe o código do emprestimo: ");
                	codigo = leitor.nextLine();
                	
                	try {
                    	Registro con2 = dao2.consultar(codigo);
                    	if(con2 != null) {
                        	System.out.println(con2);
                        }
                    } catch(ClassCastException e) {
                    	System.out.println("O código informado está incorreta ou não pode ser encontradada");
                    }
                	break;

                case "0":
                    System.out.println("Encerrando...");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Opção Invalida!");
                    break;
            }
        }while(opcao != "0");
    }
    
}
