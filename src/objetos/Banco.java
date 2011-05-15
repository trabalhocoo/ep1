package objetos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.ListIterator;
import java.util.Scanner;


//Eu tive uma ideia pro banco: a gente poderia
//colocar já de cara um vetore 
public class Banco {

	private ArrayList<Usuario> filmes;
	private ArrayList salas;
	private ArrayList caixas;
	private ArrayList<Usuario> usuarios;
	private ArrayList sessões;
	
	//TODO colocar os atributos. NÃ£o sei quais collections serÃ£o
	
	void recuperarDados(){
		
	}
	
	void addSessao(Sessao sessao){		
		
	}
	
	void modificarSessao(Sessao sessao, Filme filme, String hora, Sala sala, double Preco, boolean is3d){
		
	}
	
	void removerSessao(Sessao sessao){
		
	}
	
	void addSala(Sala sala){
		
	}
	
	void modificarSala(Sala sala, int capacidade, int numero, boolean is3d){
		
	}
	
	void removerSala(Sala sala){
		
	}
	
	void adicionarFilme(Filme filme){
		try{
			//Variáveis de uso local
			private String nome;
			private int faixaEtaria;
			private double duracao;
			private String diretor;
			private String sinopse;
			private String genero;
			private String dataDeEstreia;
			
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("Entre com os seguintes dados:");
			System.out.println("Nome do filme:");
			nome=entrada.next();
			System.out.println("Diretor do filme:");
			diretor=entrada.next();
			System.out.println("Sinopse do filme:");
			sinopse=entrada.next();
			System.out.println("Gênero do filme:");
			genero=entrada.next();
			System.out.println("Data de estreia:");
			dataDeEstreia=entrada.next();
			System.out.println("Duração do filme, em minutos:");
			duracao=entrada.nextDouble();
			System.out.println("Faixa etária (digite a idade mínima):");
			faixaEtaria=entrada.nextInt();

			//Agora sim, vamos criar esse filme que será um sucesso de audiência!
			Filme filmao = new Filme(nome,faixaEtaria,duracao,diretor,
									 sinopse,genero,dataDeEstreia);
			ListIterator it = filmes.ListIterator(filmes.size());
			it.add(filmao);
			System.out.println("Operação realizada com sucesso!");
			}
			
			//Aqui embaixo ficam as verificações de erros para os inteiros.
		catch (InputMismatchException erroDeTipoDeValor)
			{
				System.err.printf("\nFoi encontrado um erro:\n%s\nPor favor, tente novamente.", erroDeTipoDeValor)
				Scanner.nextLine();
			}
	}
	
	void modificarFilme(Filme filme, String nome, int faixaEtaria, int horas, int minutos, String Diretor, String gÃªnero, Date dataEstreia)
	{
		
	}
	
	void removerFilme(Filme filme){
		
	}
	
	void addUsuario(){
		try{
		//Variáveis de uso local
		String nome;
		int registro;
		boolean ehAdministrador;
		String login;
		String senha;
		int adm; //Variável auxiliar usada mais embaixo...
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Entre com os seguintes dados:");
		System.out.println("Nome do usuário:");
		nome=entrada.next();
		System.out.println("Login de usuário:");
		login=entrada.next();
		System.out.println("Senha de usuário:");
		senha=entrada.next();
		System.out.println("O usuário será administrador? Entre 1 para SIM ou 0 para NÃO");
		adm = entrada.nextInt();
		if (adm!=1 && adm!=0)
			{
			IllegalArgumentException NemUmNemZero = new IllegalArgumentException ("Valor fornecido para administrador incorreto!");
			throw NemUmNemZero;
			}
		else
		{
		if (adm=1)ehAdministrador=true;
		if (adm=0)ehAdministrador=false;
		}
		
		System.out.println("Número de registro do usuário:");
		registro = entrada.nextInt();
		
		//Agora sim, vamos criar um usuário!
		if (adm=1)
			{Administrador user = new Administrador(nome,registro,ehAdministrador,login,senha);}
		else
			{Usuario user = new Usuario(nome,registro,ehAdministrador,login,senha);}
		
		//Aqui eu adicionei na lista de usuários o "user"
		ListIterator it = usuarios.ListIterator(usuarios.size());
		it.add(user);
		System.out.println("Operação realizada com sucesso!");
		}
		
		//Aqui embaixo ficam as verificações de erros para os inteiros.
		catch (InputMismatchException erroDeTipoDeValor)
		{
			System.err.printf("\nFoi encontrado um erro:\n%s\nPor favor, tente novamente.", erroDeTipoDeValor)
			Scanner.nextLine();
		}
		catch (IllegalArgumentException nemUmNemZero)
		{
			System.err.printf("\nFoi encontrado um erro:\n%s\nPor favor, tente novamente.", nemUmNemZero)
			Scanner.nextLine();
		}
	}
	
	
	void removerUsuario(Usuario usuario){
		//Tentei remover encontrando o usuário num "for".
		//Qualquer coisa, é alterar o código pra procurar pelo
		//iterador, mas acho que assim dá pra ir.
		
		int posicaoDoCabraNoVetor=-1;
		
		for (int i=0; i<usuarios.size(),i++)
			if (usuario.equals(usuarios.get(i)))
				posicaoDoCabraNoVetor=i;
		
		if (i>-1)
		{
			ListIterator it = usuarios.ListIterator(posicaoDoCabraNoVetor-1);
			it.next();
			it.remove();
			System.out.println("O usuário foi removido com sucesso!");
		}
		else
		System.out.println("O usuário não foi encontrado na lista de usuários do sistema.");
	}

	
	void modificarUsuario(Usuario usuario, String nome, boolean ehAdmin, String login, String senha){
		
	}
}