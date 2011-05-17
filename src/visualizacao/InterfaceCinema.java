package visualizacao;

import java.util.ArrayList;
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
		System.out.println("Digite o numero do registro de usuario que voce que remover: ");
		int registro = obterInteiro();
		Usuario usuario = Banco.obterUsuario(registro);
		return usuario;
	}

	public static ArrayList<Object> alterarUsuario() {
		ArrayList<Object> arrayListDeUsuario = new ArrayList<Object>();
		System.out
				.println("Digite o numero do registro de usuario que voce deseja alterar: ");
		int numeroRegistro = obterInteiro();
		Usuario usuarioAAlterar = Banco.obterUsuario(numeroRegistro);
		arrayListDeUsuario.add(usuarioAAlterar);
		System.out
				.println("Digite o numero correspondente do par�metro que voce deseja alterar: ");
		System.out.println("0- nome \n1- administrador 2- senha");
		int numero = obterInteiro();
		if (numero == 0) {
			System.out.println("Digite o novo nome do usu�rio: ");
			String novoNome = obterString();
			arrayListDeUsuario.add(novoNome);
		} else {
			arrayListDeUsuario.add(usuarioAAlterar.getNome());
		}

		if (numero == 1) {
			System.out.println("Digite se o usu�rio e administrador: ");
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

	public static ArrayList<Sessao> removerSessao() {
		// TODO deve perguntar ao usuario qual é o horario de inicio e a sala da
		// sessao e retornar isso num arrayList
		System.out.println("");
		// Implementar isso
		return null;
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
		System.out.println("Digite se o filme � 3D: ");
		arrayListDeFilme.add(obterBoolean());
		return arrayListDeFilme;
	}

	public static ArrayList<Filme> alterarFilme() {
		ArrayList arrayListDeFilme = new ArrayList();
		System.out.println("Digite o nome do filme que deseja alterar: ");
		String nomeDoFilme = obterString();
		// Falta metodo obter filme no banco
		Filme filme = Banco.obterFilme(nomeDoFilme);
		// modificarFilme(Filme filme, String nome, int faixaEtaria, Date
		// horaInicio,
		// Date duracao, String Diretor, String genero, Date dataEstreia
		arrayListDeFilme.add(filme);
		System.out
				.println("Digite o numero correspondente do par�metro que voce deseja alterar: ");
		// String nome, int faixa, Date duracao, String diretor, String sinopse,
		// String genero, String estreia, boolean is3d
		System.out.println("0- nome \n1- administrador 2- senha");
		// falta terminar
		return arrayListDeFilme;
	}

	public static ArrayList<Object> adicionarSala() {
		ArrayList<Object> arrayListDeSala = new ArrayList<Object>();
		System.out.println("Digite a capacidade da sala: ");
		arrayListDeSala.add(obterInteiro());
		System.out.println("Digite o numero da sala:");
		arrayListDeSala.add(obterInteiro());
		System.out.println("Digite se a sala e 3D:");
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
		Scanner sc = new Scanner(System.in);
		// Ei, esse scaner numca é utilizado!!!!!
		//Usar o metodo
		ArrayList<Object> arrayListDeUsuario = new ArrayList<Object>();
		System.out.println("Digite o nome do Usu�rio: ");
		arrayListDeUsuario.add(obterString());
		System.out.println("Digite se o usu�rio � administrador: ");
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
				.println("Digite o numero correspondente do par�metro que voce deseja alterar: \n");
		System.out.println("0- capacidade \n1- numero 2- login 3- 3D");
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
		int inteiro = scanPrincipal.nextInt();
		return inteiro;
	}

	// falta tratar excecao de tipo
	private static boolean obterBoolean() {
		System.out.println("(Digite true ou false)");
		boolean bool = scanPrincipal.nextBoolean();
		return bool;
	}

	public static ArrayList<Sessao> alterarSessao() {
		// TODO Deve retornar um arrayList com os dados da sessao: 
		//Filme filme, ano, mes dia, hora, minuto, int numSala, double preco, int disp
		//depois o outro método vai criar o Calendar
		
		return null;
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
