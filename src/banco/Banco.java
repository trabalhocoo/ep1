package banco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

import objetos.Administrador;
import objetos.Filme;
import objetos.Sala;
import objetos.Sessao;
import objetos.Usuario;

//Eu tive uma ideia pro banco: a gente poderia
//colocar já de cara um vetore 
public class Banco {

	private ArrayList <Filme> filmes;
	private ArrayList <Sala> salas;
	private ArrayList  caixas;
	private ArrayList <Usuario> usuarios;
	private ArrayList <Sessao> sessoes;

	Scanner entrada = new Scanner(System.in);

	//colocar os atributos. NÃ£o sei quais collections serÃ£o

	void recuperarDados() {

	}

	void addSessao(Sessao sessao) {
		private Filme filme;
		private String horarioDeInicio;
		private String horarioDeFim;
		private Sala sala;
		private double preco;
		private boolean eh3d;
		private Date duracao;
		private int lugaresDisponiveis;
		
		
	}

		

	}

	void modificarSessao(Sessao sessao, Filme filme, String hora, Sala sala, double Preco, boolean is3d) {

	}

	void removerSessao(Sessao sessao) {

	}

	void addSala(Sala sala) {

		 int capacidade;//qdo eu coloco as coisas private da uns erros malignos / sera q num tem um jeito mais facil de fazer isso?
		 int numero;
		 boolean is3d;
		 boolean continues = true;

		do{
			try{
				System.out.println("Entre com os seguintes dados da nova sala:");
				System.out.println("Capacidade de pessoas:");
				capacidade = entrada.nextInt();
				System.out.println("Numero:");//que numero eh esse?
				numero = entrada.nextInt();
				System.out.println("A sessao eh 3D? Escreva 'true' ou 'false'"); throw new Exception();
				is3d = entrada.next() != null;

				//criacao da Sala

				Sala _sala = new Sala (capacidade,numero,is3d);
				ListIterator <Sala> it = salas.listIterator(salas.size());
				it.add(_sala);
				System.out.println("Operacao realizada com sucesso!");
				continues = false;
			}

			catch (InputMismatchException e){
				System.err.printf( "\nException: %s\n", e ); 
				entrada.nextLine(); 
				System.out.println("Por favor digite digite numeros inteiros e tente de novo! \n" );
			}
			//precisa criar uma execao caso a pessoa naum coloque true or false...
		}while (continues);


	}

	void modificarSala(Sala sala, int capacidade, int numero, boolean is3d) {

	}

	void removerSala(Sala sala) {
		
		


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

			System.out.println("Entre com os seguintes dados:");
			System.out.println("Nome do filme:");
			nome=entrada.next();
			System.out.println("Diretor do filme:");
			diretor=entrada.next();
			System.out.println("Sinopse do filme:");
			sinopse=entrada.next();
			System.out.println("Genero do filme:");
			genero=entrada.next();
			System.out.println("Data de estreia:");
			dataDeEstreia=entrada.next();
			System.out.println("Duracao do filme, em minutos:");
			duracao=entrada.nextDouble();
			System.out.println("Faixa etaria (digite a idade minima):");
			faixaEtaria=entrada.nextInt();
		}
		//Agora sim, vamos criar esse filme que será um sucesso de audiencia!
		Filme filmao = new Filme(nome,faixaEtaria,duracao,diretor,
				sinopse,genero,dataDeEstreia);
		ListIterator <Filme> it = filmes.listIterator(filmes.size());
		it.add(filmao);
		System.out.println("Operacao realizada com sucesso!");

		//Aqui embaixo ficam as verificações de erros para os inteiros.
		catch (InputMismatchException erroDeTipoDeValor)
		{
			System.err.printf("\nFoi encontrado um erro:\n%s\nPor favor, tente novamente.", erroDeTipoDeValor);
			entrada.nextLine();
		}
	}

	void modificarFilme(Filme filme, String nome, int faixaEtaria, int horas,
			int minutos, String Diretor, String gÃªnero, Date dataEstreia) {

	}

	void removerFilme(Filme filme) {

	}

	void addUsuario(){
		int adm = -1; //Variavel auxiliar usada mais embaixo...
		try{
			//Variáveis de uso local
			String nome;
			int registro;
			boolean ehAdministrador;
			String login;
			String senha;

			Scanner entrada = new Scanner(System.in);

			System.out.println("Entre com os seguintes dados:");
			System.out.println("Nome do usuario:");
			nome=entrada.next();
			System.out.println("Login de usuario:");
			login=entrada.next();
			System.out.println("Senha de usuario:");
			senha=entrada.next();

			do{//acrescentei um laco pra tentar refazer a entrada de usuario
				System.out.println("O usuario sera administrador? Entre 1 para SIM ou 0 para NAO");
				adm = entrada.nextInt();

				if (adm!=1 && adm!=0)
				{
					IllegalArgumentException NemUmNemZero = new IllegalArgumentException ("Valor fornecido para administrador incorreto!");
					throw NemUmNemZero;
				}
				else
				{
					if (adm == 1)
						ehAdministrador=true;
					if (adm == 0)
						ehAdministrador=false;
				}
			}while (adm != 0 || adm != 1);

			System.out.println("Numero de registro do usuario:");
			registro = entrada.nextInt();

			//Agora sim, vamos criar um usuário!
			if (adm == 1)
			{Administrador user = new Administrador(nome,registro,ehAdministrador,login,senha);}
			else
			{Usuario user = new Usuario(nome,registro,ehAdministrador,login,senha);}

			//Aqui eu adicionei na lista de usuários o "user"
			ListIterator it = usuarios.listIterator(usuarios.size());
			it.add(user);//arrumar o escopo (naum sei como arruma isso)=/
			System.out.println("Operação realizada com sucesso!");


			//Aqui embaixo ficam as verificações de erros para os inteiros.
			catch (InputMismatchException erroDeTipoDeValor)
			{
				System.err.printf("\nFoi encontrado um erro:\n%s\nPor favor, tente novamente.", erroDeTipoDeValor);
				entrada.nextLine();
			}
			catch (IllegalArgumentException nemUmNemZero)
			{
				System.err.printf("\nFoi encontrado um erro:\n%s\nPor favor, tente novamente.", nemUmNemZero);
				entrada.nextLine();
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

		void modificarUsuario(Usuario usuario, String nome, boolean ehAdmin,
				String login, String senha) {

		}
	}