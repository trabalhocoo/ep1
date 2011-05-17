package visualizacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.Controlador;

import banco.Banco;

import objetos.Filme;
import objetos.Sala;
import objetos.Sessao;
import objetos.Usuario;

public class InterfaceCinema {
	
	public static Scanner scanPrincipal = new Scanner(System.in);
	
	public static Usuario removerUsuario() {
		System.out.println("Digite o numero do registro de usuario que deseja remover: ");
		int registro = obterInteiro();
		Usuario usuario = Banco.obterUsuario(registro);
		return usuario;
	}

	
	public static ArrayList<Object> alterarUsuario() {
		ArrayList<Object> arrayListDeUsuario = new ArrayList<Object>();
		System.out
				.println("Digite o numero do registro de usuario que deseja alterar: ");
		int numeroRegistro = obterInteiro();
		Usuario usuarioAAlterar = Banco.obterUsuario(numeroRegistro);
		arrayListDeUsuario.add(usuarioAAlterar);
		System.out
				.println("Digite o numero correspondente do par�metro que deseja alterar: ");
		System.out.println("0- nome 1- administrador 2- senha");
		int numero = obterInteiro();
		if (numero == 0) {
			System.out.println("Digite o novo nome do usu�rio: ");
			String novoNome = obterString();
			arrayListDeUsuario.add(novoNome);
		} else {
			arrayListDeUsuario.add(usuarioAAlterar.getNome());
		}

		if (numero == 1) {
			System.out.println("Digite a nova permissao do usuario: ");
			System.out.println("true- admin\nfalse- usuario\n");
			//DUVIDA E se o usuario nao for admin mas passar a ser? A gente o remove e depois cria outro usuario como admin??? 
			boolean ehAdmin = obterBoolean();
			arrayListDeUsuario.add(ehAdmin);
		} else {
			arrayListDeUsuario.add(usuarioAAlterar.isEhAdministrador());
		}

		if (numero == 2) {
			System.out.println("Digite a nova senha do usu�rio: ");
			String senha = obterString();
			arrayListDeUsuario.add(senha);
		} else {
			arrayListDeUsuario.add(usuarioAAlterar.getSenha());
		}
		return arrayListDeUsuario;
	}


	public static ArrayList removerSessao() {
		// TODO 
		//Deve pedir ao usuario:
		//int year 0, int month 1, int date 2, int hourOfDay 3, int minute 4, int numSala 5 e retornar nessa sequencia
		ArrayList <Object> arrayListaDeSessao = new ArrayList <Object> (); 
		System.out.println("Digite a sala que deseja remover a sessao:");
		arrayListaDeSessao.add(5, obterInteiro());
		System.out.println("Digite o ano:");
		arrayListaDeSessao.add(0, obterInteiro());
		System.out.println("Digite o mes:");
		arrayListaDeSessao.add(1, obterInteiro());
		System.out.println("Digite o dia:");
		arrayListaDeSessao.add(2, obterInteiro());
		System.out.println("Digite o horario do filme no formato HHMM:");
		int horaMinuto = obterInteiro();
		int hora = horaMinuto/100;
		int minuto = horaMinuto%100;
		arrayListaDeSessao.add(3, hora);
		arrayListaDeSessao.add(4, minuto);
		return arrayListaDeSessao;
	}

	public static ArrayList<Object> adicionarFilme() {
		ArrayList<Object> arrayListDeFilme = new ArrayList<Object>();
		System.out.println("Digite o nome do filme: ");
		arrayListDeFilme.add(obterString());
		System.out.println("Digite a faixa et�ria do filme:");
		arrayListDeFilme.add(obterInteiro());
		System.out.println("Digite a duracao do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println("Digite o nome do diretor do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println("Digite a sinopse do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println("Digite o genero do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println("Digite a estreia do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println("Digite se a sala e 3D:");
		System.out.println("true- sim\nfalse- nao\n");
		arrayListDeFilme.add(obterBoolean());
		return arrayListDeFilme;
	}

	public static ArrayList alterarFilme() {
		ArrayList <Object> arrayListDeFilme = new ArrayList <Object> ();
		System.out.println("Digite o nome do filme que deseja alterar: ");
		String nomeDoFilme = obterString();
		// Falta metodo obter filme no banco
		//Banco.modificarFilme(filmeAAlterar, nomeDoFilme, faixaEtaria, duracao,
		//	diretor, sinopse, genero, estreia, is3d)
		Filme filme = Banco.obterFilme(nomeDoFilme);
		arrayListDeFilme.add(filme);
		System.out
				.println("Digite o numero correspondente do par�metro que voce deseja alterar: ");
		// String nome 0, int faixa 1, Date duracao 2, String diretor 3, String sinopse 4,
		// String genero 5, String estreia 6, boolean is3d 7
		System.out.println("0- nome 1- faixa etaria 2- duracao 3- diretor 4- sinopse 5- genero 6- data da estreia 7- 3D");
		int opcao = recebeOpcao();
		if (opcao == 0){
			System.out.println("Digite o nome do filme: ");
			arrayListDeFilme.add(1,obterString());
		}
		else {
			arrayListDeFilme.add(1, filme.getNome());
		}
		if (opcao == 1){
			System.out.println("Digite a faixa et�ria do filme:");
			arrayListDeFilme.add(2, obterString());
		}
		else {
			arrayListDeFilme.add(2, filme.getFaixaEtaria());
		}
		
		if (opcao == 2){
			System.out.println("Digite a duracao do filme:");
			arrayListDeFilme.add(3, obterString());
		}
		else {
			arrayListDeFilme.add(3, filme.getDuracao());
		}
		
		if (opcao == 3){
			System.out.println("Digite o nome do diretor do filme:");
			arrayListDeFilme.add(4, obterString());
		}
		else {
			arrayListDeFilme.add(4, filme.getDiretor());
		}
		
		if (opcao == 4){
			System.out.println("Digite a sinopse do filme:");
			arrayListDeFilme.add(5, obterString());
		}
		else {
			arrayListDeFilme.add(5, filme.getSinopse());
		}
		
		if (opcao == 5){
			System.out.println("Digite o genero do filme::");
			arrayListDeFilme.add(6, obterString());
		}
		else {
			arrayListDeFilme.add(6,filme.getGenero());
		}
		
		if (opcao == 6){
			System.out.println("Digite a estreia do filme:");
			arrayListDeFilme.add(7, obterString());
		}
		else {
			arrayListDeFilme.add(7, filme.getDataDeEstreia());
		}
		
		if (opcao == 7){
			System.out.println("Digite se o filme e 3D:");
			System.out.println("true- sim false- nao");
			arrayListDeFilme.add(8, obterBoolean());
		}
		else {
			arrayListDeFilme.add(8, filme.isIs3d());
		}
		System.out.println("Digite se o filme � 3D: ");
		System.out.println("true- sim false- nao");
		arrayListDeFilme.add(obterBoolean());
		return arrayListDeFilme;
	}

	public static ArrayList<Object> adicionarSala() {
		ArrayList<Object> arrayListDeSala = new ArrayList<Object>();
		System.out.println("Digite a capacidade da sala: ");
		arrayListDeSala.add(obterInteiro());
		System.out.println("Digite o numero da sala:");
		arrayListDeSala.add(obterInteiro());
		System.out.println("Digite se a sala e 3D:");
		System.out.println("true- sim false- nao");
		arrayListDeSala.add(obterBoolean());
		return arrayListDeSala;
	}

	public static Filme removerFilme() {
		System.out.println("Digite o nome do filme que voce deseja remover: ");
		String nomeDoFilme = obterString();
		// falta o metodo obterFilme (nome) do banco
		Filme filme = Banco.obterFilme(nomeDoFilme);
		return filme;
	}

	public static int removerCaixa() {
		System.out.println("Digite o numero do caixa que deseja remover: ");
		int numeroDoCaixa = obterInteiro();
		return numeroDoCaixa;
	}

	public static ArrayList<Object> adicionarUsuario() {
		//Usar o metodo
		ArrayList<Object> arrayListDeUsuario = new ArrayList<Object>();
		System.out.println("Digite o nome do Usu�rio: ");
		arrayListDeUsuario.add(obterString());
		System.out.println("Digite a permissao do usuario: ");
		System.out.println("true- admin\nfalse- usuario\n");
		arrayListDeUsuario.add(obterBoolean());
		arrayListDeUsuario.add("login temporario");
		System.out.println("Digite a senha do usu�rio: ");
		arrayListDeUsuario.add(obterString());
		return arrayListDeUsuario;
	}

	public static ArrayList<Object> alterarSala() {
		ArrayList<Object> arrayListDaSala = new ArrayList<Object>();
		System.out.println("Digite o n�mero da sala:");
		int numeroDaSala = obterInteiro();
		// Falta metodo obterSala no banco
		Sala sala = Banco.obterSala(numeroDaSala);
		arrayListDaSala.add(sala);
		System.out
				.println("Digite o numero correspondente do par�metro que voce deseja alterar:");
		System.out.println("0- capacidade 1- numero 2- login 3- 3D");
		int numeroAAlterar = obterInteiro();
		if (numeroAAlterar == 0) {
			System.out.println("Digite a nova capacidade da sala:");
			int capacidade = obterInteiro();
			arrayListDaSala.add(capacidade);
		} else {
			arrayListDaSala.add(sala.getCapacidade());
		}
		if (numeroAAlterar == 1) {
			System.out.println("Digite o novo n�mero da sala:");
			int numero = obterInteiro();
			arrayListDaSala.add(numero);
		} else {
			arrayListDaSala.add(sala.getNumero());
		}

		if (numeroAAlterar == 2) {
			System.out.println("Digite se a sala e 3D:");
			boolean bool = obterBoolean();
			arrayListDaSala.add(bool);
		} else {
			arrayListDaSala.add(sala.is3d());
		}
		return arrayListDaSala;
	}

	// falta tratar excecao de tipo
	private static String obterString() {
		String string = scanPrincipal.next();
		return string;
	}

	// falta tratar excecao de tipo
	//NÃO ESQUECER DE FECHAR OS FLUXOS
	private static int obterInteiro() {
		int inteiro = -1;
		boolean continueLoop = true;
		do{
			try{
				inteiro = scanPrincipal.nextInt();
				continueLoop=false;
			}
			catch (InputMismatchException inputMismatchException )
			{
				System.err.printf( "\nException: %s\n", inputMismatchException );
				System.out.println("Forneca inteiros. Tente novamente \n");
			}
		} while (continueLoop);
		
		return inteiro;
	}

	private static boolean obterBoolean() {
		boolean continueLoop = true;
		boolean bool= false;
		do{
			try{
				bool = scanPrincipal.nextBoolean();
				continueLoop=false;
			}
			catch (InputMismatchException inputMismatchException )
			{
				System.err.printf( "\nException: %s\n", inputMismatchException );
				System.out.println("Digite true ou false. Tente novamente \n");
			}
		} while (continueLoop);
		return bool;
	}

	public static ArrayList alterarSessao() {
		// TODO Deve retornar um arrayList com os dados da sessao: 
		//Filme filme 0, ano 1, mes 2, dia 3, hora 4, minuto 5, int numSala 6, double preco 7, int disp 8
		//depois o outro método vai criar o Calendar
		ArrayList <Object> arrayListDeSessao = new ArrayList <Object> ();
		System.out.println ("Digite a sala da sessao que deseja alterar:");
		arrayListDeSessao.add(6, obterInteiro());
		/*alterando Elaine
		
		
		Sessao sessao = Banco.obterSessao(hora, numeroDaSala)
		System.out.println ("Digite o numero correspondente do parametro que deseja alterar da sessao: \n");
		System.out.println("0- filme 1- inicio 2- fim 3- sala 4- preco 5- duracao 6- lugares disponiveis");
		int opcao = recebeOpcao();
		if (opcao == 0){
			System.out.println("Digite o nome do filme: ");
			arrayListDeFilme.add(1,obterString());
		}
		else {
			arrayListDeFilme.add(1, filme.getNome());
		}
		
		
		System.out.println("Digite o horario de inicio da sessao que deseja remover:");
		arrayListDeSessao.add(1,obterString());
		//Filme filme, Date inicio, long fim, Sala sala, double preco, Date duracao, 
		//int disp
		System.out.println ("Digite a sala de exibicao:");
		int salaDeExibicao = obterInteiro();
		Sessao sessaoAAlterar = Banco.obterSessao((Date) arrayListDeSessao.get(1),salaDeExibicao);
		*/
		return arrayListDeSessao;
	}

	public static ArrayList<Object> obterDadosLogin() {
		// TODO tratar excessões
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu numero de registro:");
		int registro = obterInteiro();
		System.out.println();
		System.out.println("Digite sua senha: ");
		String senha = obterString();
		ArrayList<Object> dadosLogin = new ArrayList<Object>();
		dadosLogin.add(registro);
		dadosLogin.add(senha);
		return dadosLogin;
	}

	public static int recebeOpcao(){
		//TODO tratar excessoes
		System.out.println("Digite uma opcao");
		int opcao = obterInteiro();
		return opcao;
	}

	public static ArrayList<Sessao> obterDadosSessao() {
		// TODO Auto-generated method stub
		//deve pedir ao usuario o ano, o mes, o dia, hora, minutos e o numero da  sala, e retornar nessa ordem
		return null;
	}
	
}
