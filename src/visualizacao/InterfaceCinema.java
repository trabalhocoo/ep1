package visualizacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	/*
	 * OK
	 */
	public static int removerUsuario() {
		System.out
				.println("Digite o numero do registro de usuario que voce que remover: ");
		int registro = obterInteiro();
		return registro;
	}

	/*
	 * OK
	 */
	public static ArrayList<Object> alterarUsuario() {
		// 0: usuario, 1: nome, 2: ehadmin, 3: senha
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
			// DUVIDA E se o usuario nao for admin mas passar a ser? A gente o
			// remove e depois cria outro usuario como admin???
			// duvida extremamente pertinente. Acho que não há outra forma de
			// fazer isso, e foi o que eu implementei no Banco
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

	/*
	 * OK
	 */
	public static ArrayList removerSessao() {
		// Pede ao usuario:
		// int year 0, int month 1, int date 2, int hourOfDay 3, int minute 4,
		// int numSala 5 e retornar nessa sequencia
		ArrayList<Object> arrayListaDeSessao = new ArrayList<Object>();
		System.out
				.println("Digite o numero da sala que deseja remover a sessao:");
		arrayListaDeSessao.add(5, obterInteiro());
		System.out.println("Digite o ano:");
		arrayListaDeSessao.add(0, obterInteiro());
		System.out.println("Digite o mes:");
		arrayListaDeSessao.add(1, obterInteiro());
		System.out.println("Digite o dia:");
		arrayListaDeSessao.add(2, obterInteiro());
		System.out.println("Digite o horario do filme no formato HHMM:");
		int horaMinuto = obterInteiro();
		int hora = horaMinuto / 100;
		int minuto = horaMinuto % 100;
		arrayListaDeSessao.add(3, hora);
		arrayListaDeSessao.add(4, minuto);
		return arrayListaDeSessao;
	}

	/*
	 * OK
	 */
	public static ArrayList<Object> adicionarFilme() {
		// String nome, int faixa, Date duracao, String diretor, String sinopse,
		// String genero, String estreia, boolean is3d
		ArrayList<Object> arrayListDeFilme = new ArrayList<Object>();
		System.out.println("Digite o nome do filme: ");
		arrayListDeFilme.add(obterString());
		System.out.println("Digite a faixa et�ria do filme:");
		arrayListDeFilme.add(obterInteiro());
		System.out
				.println("Digite a duracao do filme (em minutos, apenas numeros):");
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

	/*
	 * Parece OK
	 */
	public static ArrayList alterarFilme() {
		ArrayList<Object> arrayListDeFilme = new ArrayList<Object>();
		System.out.println("Digite o nome do filme que deseja alterar: ");
		String nomeDoFilme = obterString();
		// Falta metodo obter filme no banco
		// Banco.modificarFilme(filmeAAlterar, nomeDoFilme, faixaEtaria,
		// duracao,
		// diretor, sinopse, genero, estreia, is3d)
		Filme filme = Banco.obterFilme(nomeDoFilme);
		arrayListDeFilme.add(filme);
		System.out
				.println("Digite o numero correspondente do par�metro que voce deseja alterar: ");
		// String nome 0, int faixa 1, Date duracao 2, String diretor 3, String
		// sinopse 4,
		// String genero 5, String estreia 6, boolean is3d 7
		System.out
				.println("0- nome 1- faixa etaria 2- duracao 3- diretor 4- sinopse 5- genero 6- data da estreia 7- 3D");
		int opcao = recebeOpcao();
		if (opcao == 0) {
			System.out.println("Digite o nome do filme: ");
			arrayListDeFilme.add(1, obterString());
		} else
			arrayListDeFilme.add(1, filme.getNome());

		if (opcao == 1) {
			System.out.println("Digite a faixa et�ria do filme:");
			arrayListDeFilme.add(2, obterString());
		} else
			arrayListDeFilme.add(2, filme.getFaixaEtaria());

		if (opcao == 2) {
			System.out.println("Digite a duracao do filme:");
			arrayListDeFilme.add(3, obterString());
		} else
			arrayListDeFilme.add(3, filme.getDuracao());

		if (opcao == 3) {
			System.out.println("Digite o nome do diretor do filme:");
			arrayListDeFilme.add(4, obterString());
		} else
			arrayListDeFilme.add(4, filme.getDiretor());

		if (opcao == 4) {
			System.out.println("Digite a sinopse do filme:");
			arrayListDeFilme.add(5, obterString());
		} else
			arrayListDeFilme.add(5, filme.getSinopse());

		if (opcao == 5) {
			System.out.println("Digite o genero do filme::");
			arrayListDeFilme.add(6, obterString());
		} else
			arrayListDeFilme.add(6, filme.getGenero());

		if (opcao == 6) {
			System.out.println("Digite a estreia do filme:");
			arrayListDeFilme.add(7, obterString());
		} else
			arrayListDeFilme.add(7, filme.getDataDeEstreia());

		if (opcao == 7) {
			System.out.println("Digite se o filme e 3D:");
			System.out.println("true- sim false- nao");
			arrayListDeFilme.add(8, obterBoolean());
		} else
			arrayListDeFilme.add(8, filme.isIs3d());

		System.out.println("Digite se o filme � 3D: ");
		System.out.println("true- sim false- nao");
		arrayListDeFilme.add(obterBoolean());

		return arrayListDeFilme;
	}

	/*
	 * OK
	 */
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

	/*
	 * OK
	 */
	public static Filme removerFilme() {
		System.out.println("Digite o nome do filme que voce deseja remover: ");
		String nomeDoFilme = obterString();
		Filme filme = Banco.obterFilme(nomeDoFilme);
		return filme;
	}

	/*
	 * OK
	 */
	public static int removerCaixa() {
		System.out.println("Digite o numero do caixa que deseja remover: ");
		int numeroDoCaixa = obterInteiro();
		return numeroDoCaixa;
	}

	/*
	 * PARECE OK
	 */
	public static ArrayList<Object> adicionarUsuario() {
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

	/*
	 * Parece OK
	 */
	public static ArrayList<Object> alterarSala() {
		ArrayList<Object> arrayListDaSala = new ArrayList<Object>();
		System.out.println("Digite o n�mero da sala:");
		int numeroDaSala = obterInteiro();
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

	// falta algo aqui?
	private static String obterString() {
		String string = scanPrincipal.next();
		return string;
	}

	// falta algo aqui?
	private static int obterInteiro() {
		int inteiro = -1;
		boolean continueLoop = true;
		do {
			try {
				Scanner scanPrincipal = new Scanner(System.in);
				inteiro = scanPrincipal.nextInt();
				continueLoop = false;
			} catch (InputMismatchException inputMismatchException) {
				System.err.printf("\nException: %s\n", inputMismatchException);
				System.out.println("Forneca inteiros. Tente novamente \n");
			}
		} while (continueLoop);
		return inteiro;
	}

	// falta algo aqui?
	private static boolean obterBoolean() {
		boolean continueLoop = true;
		boolean bool = false;
		do {
			try {
				Scanner scanPrincipal = new Scanner(System.in);
				bool = scanPrincipal.nextBoolean();
				continueLoop = false;
			} catch (InputMismatchException inputMismatchException) {
				System.err.printf("\nException: %s\n", inputMismatchException);
				System.out.printf("Digite true ou false. Digite novamente \n");
			}
		} while (continueLoop);
		return bool;
	}

	/*
	 * Parece ok
	 */
	public static ArrayList alterarSessao() {
		// Retorna um arrayList com os dados da sessao:
		// Calendar dataOriginal 0, String nomeFilme 1, ano 2, mes 3, dia 4,
		// hora 5, minuto 6, int numSala 7, double preco 8, int disp 9
		// depois o outro método que chamou este vai criar o Calendar
		ArrayList dadosDeSessao = new ArrayList();

		System.out.println("Digite o ano da sessão (apenas numeros)");
		int ano = obterInteiro();
		System.out.println("Digite o mes da sessao (apenas numeros)");
		int mes = obterInteiro();
		System.out.println("Digite o dia da sessao");
		int dia = obterInteiro();
		System.out.println("Digite o horario do filme no formato HHMM:");
		int horaMinuto = obterInteiro();
		int hora = horaMinuto / 100;
		int minuto = horaMinuto % 100;

		Calendar dataOriginal = Calendar.getInstance();
		dataOriginal.set(ano, mes, dia, hora, minuto);

		System.out.println("Digite o novo nome do Filme");
		String nome = obterString();
		System.out.println("Digite o novo ano");
		ano = obterInteiro();
		System.out.println("Digite o novo mes");
		mes = obterInteiro();
		System.out.println("Digite o novo dia");
		dia = obterInteiro();
		System.out.println("Digiteo o novo horario do filme no formato HHMM");
		horaMinuto = obterInteiro();
		hora = horaMinuto / 100;
		minuto = horaMinuto % 100;
		System.out.println("Digite o novo número da Sala");
		int numSala = obterInteiro();
		System.out.println("Digite o novo preço da sala");
		double preco = obterInteiro();
		System.out.println("Digite o novo numero de cadeiras disponíveis");
		int disp = obterInteiro();
		
		dadosDeSessao.add(dataOriginal);
		dadosDeSessao.add(nome);
		dadosDeSessao.add(ano);
		dadosDeSessao.add(mes);
		dadosDeSessao.add(dia);
		dadosDeSessao.add(hora);
		dadosDeSessao.add(minuto);
		dadosDeSessao.add(numSala);
		dadosDeSessao.add(preco);
		dadosDeSessao.add(disp);

		/*
		 * System.out.println ("Digite a sala da sessao que deseja alterar:");
		 * dadosDeSessao.add(6, obterInteiro());
		 * 
		 * Sessao sessao = Banco.obterSessao(hora, numeroDaSala)
		 * System.out.println (
		 * "Digite o numero correspondente do parametro que deseja alterar da sessao: \n"
		 * ); System.out.println(
		 * "0- filme 1- inicio 2- fim 3- sala 4- preco 5- duracao 6- lugares disponiveis"
		 * ); int opcao = recebeOpcao(); if (opcao == 0){
		 * System.out.println("Digite o nome do filme: ");
		 * arrayListDeFilme.add(1,obterString()); } else {
		 * arrayListDeFilme.add(1, filme.getNome()); }
		 * 
		 * 
		 * System.out.println(
		 * "Digite o horario de inicio da sessao que deseja remover:");
		 * dadosDeSessao.add(1,obterString()); //Filme filme, Date inicio, long
		 * fim, Sala sala, double preco, Date duracao, //int disp
		 * System.out.println ("Digite a sala de exibicao:"); int salaDeExibicao
		 * = obterInteiro(); Sessao sessaoAAlterar = Banco.obterSessao((Date)
		 * dadosDeSessao.get(1),salaDeExibicao);
		 */
		return dadosDeSessao;
	}

	/*
	 * parece ok
	 */
	public static ArrayList<Object> obterDadosLogin() {
		// TODO tratar excessões
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

	/*
	 * só precisa tratar msm
	 */
	public static int recebeOpcao() {
		// TODO tratar excessoes
		System.out.println("Digite uma opcao");
		int opcao = obterInteiro();
		return opcao;
	}

	/*
	 * OK
	 */
	public static ArrayList adicionarSessao() {
		// String filme, int year, int month, int date, int hourOfDay, int minute,
		// int sala, double preco
		ArrayList<Object> dadosDeSessao = new ArrayList<Object>();
		System.out.println("Digite o nome do filme dessa nova sessão");
		String nomeFilme = obterString();
		System.out.println("Digite o ano dessa nova sessão");
		int ano = obterInteiro();
		System.out.println("Digite o mes da nova sessao (apenas numeros)");
		int mes = obterInteiro();
		System.out.println("Digite o dia");
		int dia = obterInteiro();
		System.out.println("Digite o horario do filme no formato HHMM:");
		int horaMinuto = obterInteiro();
		int hora = horaMinuto / 100;
		int minuto = horaMinuto % 100;
		System.out.println("Digite o número da Sala onde será a nova sessao");
		int numSala = obterInteiro();
		System.out.println("Digite o preço");
		double preco = obterDouble();
		
		dadosDeSessao.add(nomeFilme);
		dadosDeSessao.add(ano);
		dadosDeSessao.add(mes);
		dadosDeSessao.add(dia);
		dadosDeSessao.add(hora);
		dadosDeSessao.add(minuto);
		dadosDeSessao.add(numSala);
		dadosDeSessao.add(preco);
		
		return dadosDeSessao;

	}

	/*
	 * tratar excessoes
	 */
	private static double obterDouble() {
		double real = -1;
		boolean continueLoop = true;
		do {
			try {
				Scanner scanPrincipal = new Scanner(System.in);
				real = scanPrincipal.nextDouble();
				continueLoop = false;
			} catch (InputMismatchException inputMismatchException) {
				System.err.printf("\nException: %s\n", inputMismatchException);
				System.out.println("Forneca inteiros. Tente novamente \n");
			}
		} while (continueLoop);
		return real;
	}
	
	

	public static Integer removerSala() {
		System.out.println("Qual é o número da sala a ser eliminada?");
		int numSala = obterInteiro();
		return numSala;
	}

	public static ArrayList alterarCaixa() {
		// TODO Auto-generated method stub
		ArrayList dadosCaixa = new ArrayList();
		System.out.println("Digite o novo numero do Caixa");
		dadosCaixa.add(0, obterInteiro());
		System.out.println("Digite o dinheiro no Caixa");
		dadosCaixa.add(1, obterDouble());
	
		return dadosCaixa;
	}

}
