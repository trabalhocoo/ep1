package visualizacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
				.println("Digite o numero do registro de usuario que voce que remover:\n");
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
				.println("Digite o numero do registro de usuario que deseja alterar:\n");
		int numeroRegistro = obterInteiro();
		Usuario usuarioAAlterar = Banco.obterUsuario(numeroRegistro);
		arrayListDeUsuario.add(usuarioAAlterar);
		System.out
				.println("Digite o numero correspondente do par�metro que deseja alterar:\n");
		System.out.println("0- nome 1- administrador 2- senha");
		int numero = obterInteiro();
		if (numero == 0) {
			System.out.println("Digite o novo nome do usu�rio:\n");
			String novoNome = obterString();
			arrayListDeUsuario.add(novoNome);
		} else {
			arrayListDeUsuario.add(usuarioAAlterar.getNome());
		}

		if (numero == 1) {
			System.out.println("Digite a nova permissao do usuario: \n");
			System.out.println("true- admin \nfalse- usuario\n");
			boolean ehAdmin = obterBoolean();
			arrayListDeUsuario.add(ehAdmin);
		} else {
			arrayListDeUsuario.add(usuarioAAlterar.isEhAdministrador());
		}

		if (numero == 2) {
			System.out.println("Digite a nova senha do usu�rio:\n");
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
				.println("Digite o numero da sala que deseja remover a sessao:\n");
		int numeroSala= obterInteiro();
		arrayListaDeSessao.add(5, numeroSala);
		System.out.println("Digite o ano:\n");
		int ano = obterInteiro();
		arrayListaDeSessao.add(0, ano);
		System.out.println("Digite o mes:\n");
		int mes = obterInteiro();
		arrayListaDeSessao.add(1, mes);
		System.out.println("Digite o dia:\n");
		int dia = obterInteiro();
		arrayListaDeSessao.add(2, dia);
		System.out.println("Digite o horario do filme no formato HHMM:\n");
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
		System.out.println("Digite o nome do filme:\n");
		String nome = obterString();
		arrayListDeFilme.add(nome);
		System.out.println("Digite a faixa et�ria do filme:\n");
		int faixa = obterInteiro();
		arrayListDeFilme.add(faixa);
		System.out
				.println("Digite a duracao do filme (em minutos, apenas numeros):\n");
		int duracao = obterInteiro();
		arrayListDeFilme.add(duracao);
		System.out.println("Digite o nome do diretor do filme:\n");
		String diretor = obterString();
		arrayListDeFilme.add(diretor);
		System.out.println("Digite a sinopse do filme:\n");
		String sinopse = obterString();
		arrayListDeFilme.add(sinopse);
		System.out.println("Digite o genero do filme:\n");
		String genero = obterString();
		arrayListDeFilme.add(genero);
		System.out.println("Digite a estreia do filme:\n");
		String estreia = obterString();
		arrayListDeFilme.add(estreia);
		System.out.println("Digite se a sala e 3D\n:");
		System.out.println("true- sim\nfalse- nao\n");
		boolean sala3D = obterBoolean();
		arrayListDeFilme.add(sala3D);
		return arrayListDeFilme;
	}

	/*
	 * Parece OK
	 */
	public static ArrayList alterarFilme() {
		ArrayList<Object> arrayListDeFilme = new ArrayList<Object>();
		System.out.println("Digite o nome do filme que deseja alterar:\n");
		String nomeDoFilme = obterString();
		// Falta metodo obter filme no banco
		// Banco.modificarFilme(filmeAAlterar, nomeDoFilme, faixaEtaria,
		// duracao,
		// diretor, sinopse, genero, estreia, is3d)
		Filme filme = Banco.obterFilme(nomeDoFilme);
		arrayListDeFilme.add(0, nomeDoFilme);
		System.out
				.println("Digite o numero correspondente do par�metro que voce deseja alterar:\n");
		// String nome 0, int faixa 1, Date duracao 2, String diretor 3, String
		// sinopse 4,
		// String genero 5, String estreia 6, boolean is3d 7
		System.out
				.println("0- nome 1- faixa etaria 2- duracao 3- diretor 4- sinopse 5- genero 6- data da estreia 7- 3D\n");
		int opcao = recebeOpcao();
		if (opcao == 0) {
			System.out.println("Digite o nome do filme:\n");
			String nome = obterString();
			arrayListDeFilme.add(1, nome);
		} else
			arrayListDeFilme.add(1, filme.getNome());

		if (opcao == 1) {
			System.out.println("Digite a faixa et�ria do filme:\n");
			int faixa = obterInteiro();
			arrayListDeFilme.add(2, faixa);
		} else
			arrayListDeFilme.add(2, filme.getFaixaEtaria());

		if (opcao == 2) {
			System.out.println("Digite a duracao do filme:\n");
			int duracao = obterInteiro();
			arrayListDeFilme.add(3, duracao);
		} else
			arrayListDeFilme.add(3, filme.getDuracao());

		if (opcao == 3) {
			System.out.println("Digite o nome do diretor do filme:\n");
			String diretor = obterString();
			arrayListDeFilme.add(4, diretor);
		} else
			arrayListDeFilme.add(4, filme.getDiretor());

		if (opcao == 4) {
			System.out.println("Digite a sinopse do filme:\n");
			String sinopse = obterString();
			arrayListDeFilme.add(5, sinopse);
		} else
			arrayListDeFilme.add(5, filme.getSinopse());

		if (opcao == 5) {
			System.out.println("Digite o genero do filme:\n");
			String genero = obterString();
			arrayListDeFilme.add(6, genero);
		} else
			arrayListDeFilme.add(6, filme.getGenero());

		if (opcao == 6) {
			System.out.println("Digite a estreia do filme:\n");
			String estreia = obterString();
			arrayListDeFilme.add(7, estreia);
		} else
			arrayListDeFilme.add(7, filme.getDataDeEstreia());

		if (opcao == 7) {
			System.out.println("Digite se o filme e 3D:\n");
			System.out.println("true- sim false- nao");
			boolean filme3D = obterBoolean();
			arrayListDeFilme.add(8, filme3D);
		} else
			arrayListDeFilme.add(8, filme.isIs3d());

		return arrayListDeFilme;
	}

	/*
	 * OK
	 */
	public static ArrayList<Object> adicionarSala() {
		ArrayList<Object> arrayListDeSala = new ArrayList<Object>();
		System.out.println("Digite a capacidade da sala:\n");
		int capacidade = obterInteiro();
		arrayListDeSala.add(capacidade);
		System.out.println("Digite o numero da sala:\n");
		int numero = obterInteiro();
		arrayListDeSala.add(numero);
		System.out.println("Digite se a sala e 3D:\n");
		System.out.println("true- sim\nfalse- nao\n");
		boolean sala = obterBoolean();
		arrayListDeSala.add(sala);
		return arrayListDeSala;
	}

	/*
	 * OK
	 */
	public static Filme removerFilme() {
		System.out.println("Digite o nome do filme que voce deseja remover: \n");
		String nomeDoFilme = obterString();
		Filme filme = Banco.obterFilme(nomeDoFilme);
		return filme;
	}

	/*
	 * OK
	 */
	public static int removerCaixa() {
		System.out.println("Digite o numero do caixa que deseja remover: \n");
		int numeroDoCaixa = obterInteiro();
		return numeroDoCaixa;
	}

	/*
	 * PARECE OK
	 */
	public static ArrayList<Object> adicionarUsuario() {
		ArrayList<Object> arrayListDeUsuario = new ArrayList<Object>();
		System.out.println("Digite o nome do Usu�rio: \n");
		String nome = obterString();
		arrayListDeUsuario.add(nome);
		System.out.println("Digite a permissao do usuario: ");
		System.out.println("true- admin\nfalse- usuario\n");
		boolean permissao = obterBoolean();
		arrayListDeUsuario.add(permissao);
		arrayListDeUsuario.add("login temporario");
		System.out.println("Digite a senha do usu�rio: \n");
		String senha = obterString();
		arrayListDeUsuario.add(senha);
		System.out.println ("Usuario adicionado com sucesso!");
		return arrayListDeUsuario;
	}

	/*
	 * Parece OK
	 */
	public static ArrayList<Object> alterarSala() {
		ArrayList<Object> arrayListDaSala = new ArrayList<Object>();
		System.out.println("Digite o n�mero da sala:\n");
		int numeroDaSala = obterInteiro();
		Sala sala = Banco.obterSala(numeroDaSala);
		arrayListDaSala.add(sala);
		System.out
				.println("Digite o numero correspondente do par�metro que voce deseja alterar:\n");
		System.out.println("0- capacidade 1- numero 2- login 3- 3D\n");
		int numeroAAlterar = obterInteiro();
		if (numeroAAlterar == 0) {
			System.out.println("Digite a nova capacidade da sala:\n");
			int capacidade = obterInteiro();
			arrayListDaSala.add(capacidade);
		} else {
			arrayListDaSala.add(sala.getCapacidade());
		}
		if (numeroAAlterar == 1) {
			System.out.println("Digite o novo n�mero da sala:\n");
			int numero = obterInteiro();
			arrayListDaSala.add(numero);
		} else {
			arrayListDaSala.add(sala.getNumero());
		}

		if (numeroAAlterar == 2) {
			System.out.println("Digite se a sala e 3D:\n");
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
				System.out.println("Forneca inteiros. Digite novamente: \n");
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
				System.out.printf("Digite true ou false. Digite novamente: \n");
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

		System.out.println("Digite o ano da sessão (apenas numeros)\n");
		int ano = obterInteiro();
		System.out.println("Digite o mes da sessao (apenas numeros)\n");
		int mes = obterInteiro();
		System.out.println("Digite o dia da sessao\n");
		int dia = obterInteiro();
		System.out.println("Digite o horario do filme no formato HHMM:\n");
		int horaMinuto = obterInteiro();
		int hora = horaMinuto / 100;
		int minuto = horaMinuto % 100;

		Calendar dataOriginal = Calendar.getInstance();
		dataOriginal.set(ano, mes, dia, hora, minuto);

		System.out.println("Digite o novo nome do Filme\n");
		String nome = obterString();
		System.out.println("Digite o novo ano\n");
		ano = obterInteiro();
		System.out.println("Digite o novo mes\n");
		mes = obterInteiro();
		System.out.println("Digite o novo dia\n");
		dia = obterInteiro();
		System.out.println("Digiteo o novo horario do filme no formato HHMM\n");
		horaMinuto = obterInteiro();
		hora = horaMinuto / 100;
		minuto = horaMinuto % 100;
		System.out.println("Digite o novo número da sala\n");
		int numSala = obterInteiro();
		System.out.println("Digite o novo preço da sala");
		double preco = obterInteiro();
		System.out.println("Digite o novo numero de cadeiras disponíveis\n");
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
		System.out.println("Digite sua senha:");
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
		System.out.println("Digite uma opcao:");
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
		System.out.println("Digite o nome do filme dessa nova sessão\n");
		String nomeFilme = obterString();
		System.out.println("Digite o ano dessa nova sessão\n");
		int ano = obterInteiro();
		System.out.println("Digite o mes da nova sessao (apenas numeros)\n");
		int mes = obterInteiro();
		System.out.println("Digite o dia\n");
		int dia = obterInteiro();
		System.out.println("Digite o horario do filme no formato HHMM:\n");
		int horaMinuto = obterInteiro();
		int hora = horaMinuto / 100;
		int minuto = horaMinuto % 100;
		System.out.println("Digite o número da Sala onde será a nova sessao\n");
		int numSala = obterInteiro();
		System.out.println("Digite o preço\n");
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
				System.out.println("Forneca inteiros. Digite novamente: \n");
			}
		} while (continueLoop);
		return real;
	}
	
	

	public static Integer removerSala() {
		System.out.println("Qual é o número da sala a ser eliminada?\n");
		int numSala = obterInteiro();
		return numSala;
	}

	public static ArrayList alterarCaixa() {
		// TODO Auto-generated method stub
		ArrayList dadosCaixa = new ArrayList();
		System.out.println("Digite o novo numero do caixa \n");
		int numeroDoCaixa = obterInteiro();
		dadosCaixa.add(0, numeroDoCaixa);
		System.out.println("Digite o dinheiro no caixa\n");
		double dinheiro = obterDouble();
		dadosCaixa.add(1, dinheiro);
	
		return dadosCaixa;
	}

	public static ArrayList venderIngresso() {
		ArrayList dadosDeSessao = new ArrayList();

		System.out.println("Digite o ano da sessão (apenas numeros)\n");
		int ano = obterInteiro();
		System.out.println("Digite o mes da sessao (apenas numeros)\n");
		int mes = obterInteiro();
		System.out.println("Digite o dia da sessao\n");
		int dia = obterInteiro();
		System.out.println("Digite o horario do filme no formato HHMM:\n");
		int horaMinuto = obterInteiro();
		int hora = horaMinuto / 100;
		int minuto = horaMinuto % 100;
		System.out.println("Digite o numero da sala:\n");
		int sala = obterInteiro();
		System.out.println("Digite a quantidade de ingressos:\n");
		int quantidade = obterInteiro();
		Calendar dataOriginal = Calendar.getInstance();
		dataOriginal.set(ano, mes, dia, hora, minuto);
		dadosDeSessao.add(dataOriginal);
		dadosDeSessao.add(sala);
		dadosDeSessao.add(quantidade);
		return dadosDeSessao;
	}

}
