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
        
        System.out.println("Grupo: Luiz Carlos, Roosevelt, Jos� Carlos");
        System.out.println("Disciplina: Metodologia e linguagem de programa��o");
        System.out.println("Professor: Rodrigo Fujioka");
        
        do{
            System.out.println("================ Biblioteca ================");
            System.out.println("1- Cadastrar livros;");
            System.out.println("2- Consultar livros;");
            System.out.println("3- Cadastrar aluno;");
            System.out.println("4- Consultar aluno;");
            System.out.println("5- Realizar empr�stimo;");
            System.out.println("6- Consultar empr�stimo;");
            System.out.println("0- Sair.");
            System.out.printf("Sua opc�o: ");
            try {
            	opcao = leitor.nextLine();
            } catch(InputMismatchException e) {
            	System.out.println("Op��o invalida ou incorreta");
            } catch (Exception e) {
            	System.out.println("Erro inesperado!");
            }
            switch(opcao){
                case "1":
                	try {
                    Livros livro = new Livros();
                    System.out.printf("Informe o t�tulo: ");
                    livro.setTitulo(leitor1.nextLine());
                    System.out.printf("Informe o nome do autor: ");
                    livro.setAutor(leitor2.nextLine());
                    System.out.printf("Informe o c�digo ISBN: ");
                    livro.setIsbn(leitor3.nextLine());
                	
                   
                    	dao.salvar(livro);
                   
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Erro na cria��o do arquivo");
                    } catch (InputMismatchException e) {
                    	System.out.println("Erro na cria��o do arquivo!");
                    } catch(Exception e) {
                    	System.out.println("Erro inesperado!");
                    }
                    
                    break;
                    
                case "2":
                    String isbn;
                    try {
                    System.out.println("Informe o c�digo ISBN do livro: ");
                    isbn = leitor.nextLine();

                    Livros con = dao.consultar(isbn);
                    if(con != null) {
                    	System.out.println(con);
                    }} catch (InputMismatchException e) {
                    	System.out.println("Erro na entrada de informa��es!");
                    } catch (Exception e) {
                    	System.out.println("Erro inesperado!");
                    }
                   
                    break;
                    
                case "3":
                	Aluno aluno = new Aluno();
                	try {
                    System.out.printf("Informe o nome do aluno: ");
                    aluno.setNome(leitor.nextLine());
                    System.out.printf("Informe a matr�cula do aluno: ");
                    aluno.setMatricula(leitor1.nextLine());
            
                    
                        dao1.salvar(aluno);
                    } catch (IOException ex) {
                    	System.out.println("Erro na entrada de informa��es!");
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception e) {
                    	System.out.println("Erro inesperado!");
                    }
                    break;
                case "4":
                	String matricula;
                	try {
                    System.out.printf("Informe a matr�cula do aluno: ");
                    matricula = leitor.nextLine();
                   
                    	Aluno con1 = dao1.consultar(matricula);
                    	if(con1 != null) {
                        	System.out.println(con1);
                        }
                    } catch(ClassCastException e) {
                    	System.out.println("A matr�cula informada est� incorreta ou n�o pode ser encontradada");
                    } catch (InputMismatchException e) {
                    	System.out.println("Erro na entrada de informa��es");
                    } catch (Exception e) {
                    	System.out.println("Erro inesperado!");
                    }
                
                    break;
                    
                case "5":
                	Registro registro = new Registro();
                	try {
                    System.out.printf("Informe o c�digo isbn do livro: ");
                    registro.setCodigo(leitor1.nextLine());
                    System.out.printf("Informe a matr�cula do aluno: ");
                    registro.setMatricula(leitor2.nextLine()); 
                    registro.setId(Integer.toString(gerador.nextInt(5000)));

                        dao2.salvar(registro);
                    } catch (IOException ex) {
                    	System.out.println("Erro na entrada de informa��es!");
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InputMismatchException e) {
                    	System.out.println("Erro na entrada de informa��es!");
                    } catch (Exception e) {
                    	System.out.println("Erro inesperado!");
                    }
                    
                    System.out.println("Devolu��o prevista para 10 dias, c�digo do emprestimo "+ registro.getId());
    
                	break;
                case "6":
                	String codigo;
                	try {
                	System.out.println("Informe o c�digo do emprestimo: ");
                	codigo = leitor.nextLine();
                	
                	
                    	Registro con2 = dao2.consultar(codigo);
                    	if(con2 != null) {
                        	System.out.println(con2);
                    }
                    } catch(ClassCastException e) {
                    	System.out.println("O c�digo informado est� incorreta ou n�o pode ser encontradada!");
                    } catch (InputMismatchException e) {
                    	System.out.println("Erro na entrada de informa��es!");
                    } catch (Exception e) {
                    	System.out.println("Erro inesperado!");
                    }
                	break;

                case "0":
                    System.out.println("Encerrando...");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Op��o Invalida!");
                    break;
            }
        }while(opcao != "0");
    }
    
}
