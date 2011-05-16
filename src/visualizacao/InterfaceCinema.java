package visualizacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import banco.Banco;

import objetos.Filme;
import objetos.Sala;
import objetos.Sessao;
import objetos.Usuario;

public class InterfaceCinema {
/*
 * Sessao sessaoAAlterar = InterfaceCinema.alterarSessao();
 */
	public static boolean logar (){//tratar as excecoes
		System.out.println("Digite o seu login");
		 int login = obterInteiro();
		 System.out.println("Digite a sua senha");
		 String senha = obterString();
		 boolean ehAdimin = Controlador.logar(login, senha);
		 return (ehAdimin);
	}
	
	public static boolean ehAdmin(){
		//nao sei por que tem esse metodo
		return false;
	}
	
	public static Usuario removerUsuario(){
		System.out.println ("Digite o numero do registro de usuario que voce que remover: ");
		int registro = obterInteiro();
		Usuario usuario = Banco.obterUsuario(registro);
		return usuario;
		}
	
	public static ArrayList alterarUsuario(){
		ArrayList <Object> arrayListDeUsuario = new ArrayList <Object> ();
		System.out.println ("Digite o numero do registro de usuario que voce deseja alterar: ");
		int numeroRegistro = obterInteiro();
		Usuario usuarioAAlterar = Banco.obterUsuario(numeroRegistro);
		arrayListDeUsuario.add(usuarioAAlterar);
		System.out.println ("Digite o numero correspondente do parâmetro que voce deseja alterar: ");
		System.out.println ("0- nome \n1- administrador 2- senha");
		int numero = obterInteiro();
		if (numero == 0){
			System.out.println ("Digite o novo nome do usuário: ");
			String novoNome = obterString();
			arrayListDeUsuario.add(novoNome);
		}
		else {
			arrayListDeUsuario.add(usuarioAAlterar.getNome());
		}
		
		if (numero == 1){
			System.out.println ("Digite se o usuário e administrador: ");
			boolean ehAdmin = obterBoolean();
			arrayListDeUsuario.add(ehAdmin);
		}
		else {
			arrayListDeUsuario.add(usuarioAAlterar.isEhAdministrador());
		}
		
		if (numero == 2){
			System.out.println ("Digite a nova senha do usuário: ");
			String senha = obterString();
			arrayListDeUsuario.add(senha);
		}
		else {
			arrayListDeUsuario.add(usuarioAAlterar.getSenha());
		}
		return arrayListDeUsuario;
	}
	
	public static Sessao removerSessao(){
		System.out.println ("");
	}
		
	public static ArrayList adicionarFilme(){
		ArrayList <Object> arrayListDeFilme = new ArrayList <Object> ();
		System.out.println ("Digite o nome do filme: ");
		arrayListDeFilme.add(obterString());
		System.out.println ("Digite a faixa etária do filme:"); 
		arrayListDeFilme.add(obterInteiro());
		System.out.println ("Digite a duracao do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println ("Digite o nome do diretor do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println ("Digite a sinopse do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println ("Digite o genero do filme:");
		arrayListDeFilme.add(obterString());
		System.out.println ("Digite a estreia do filme:");
		arrayListDeFilme.add (obterString());
		System.out.println ("Digite se o filme é 3D: ");
		arrayListDeFilme.add(obterBoolean());
		return arrayListDeFilme;
	}	
	
	public static ArrayList alterarFilme(){
		ArrayList <Object> arrayListDeFilme = new ArrayList <Object> ();
		System.out.println ("Digite o nome do filme que deseja alterar: ");
		String nomeDoFilme = obterString();
		//Falta metodo obter filme no banco
		Filme filme  = Banco.obterFilme(nomeDoFilme);
		//modificarFilme(Filme filme, String nome, int faixaEtaria, Date horaInicio, 
		//Date duracao, String Diretor, String genero, Date dataEstreia
		arrayListDeFilme.add(filme);
		System.out.println ("Digite o numero correspondente do parâmetro que voce deseja alterar: ");
		//String nome, int faixa, Date duracao, String diretor, String sinopse, 
		//String genero, String estreia, boolean is3d
		System.out.println ("0- nome \n1- administrador 2- senha");
		//falta terminar
		return arrayListDeFilme;
	}	
	
	public static ArrayList adicionarSala(){
		ArrayList <Object> arrayListDeSala = new ArrayList <Object> ();
		System.out.println ("Digite a capacidade da sala: ");
		arrayListDeSala.add(obterInteiro());
		System.out.println ("Digite o numero da sala:"); 
		arrayListDeSala.add(obterInteiro());
		System.out.println ("Digite se a sala e 3D:");
		arrayListDeSala.add(obterBoolean());
		return arrayListDeSala;
	}
	
	public static Filme removerFilme(){
		System.out.println ("Digite o nome do filme que voce deseja remover: ");
		String nomeDoFilme = obterString();
		// falta o metodo obterFilme (nome) do banco
		Filme filme = Banco.obterFilme(nomeDoFilme);
		return filme;
	}
	
	public static int removerCaixa(){
		System.out.println ("Digite o numero do caixa que deseja remover: ");
		int numeroDoCaixa = obterInteiro();
		return numeroDoCaixa;
	}

	public static ArrayList adicionarUsuario(){
		Scanner sc = new Scanner (System.in);
		ArrayList <Object> arrayListDeUsuario = new ArrayList <Object> ();
		System.out.println ("Digite o nome do Usuário: ");
		arrayListDeUsuario.add(obterString());
		System.out.println ("Digite se o usuário é administrador: ");
		arrayListDeUsuario.add(obterBoolean());
		arrayListDeUsuario.add("login temporario");
		System.out.println ("Digite a senha do usuário: ");
		arrayListDeUsuario.add(obterString());
		return arrayListDeUsuario;
	}
	
	
	public static ArrayList alterarSala(){
		ArrayList <Object> arrayListDaSala = new ArrayList <Object> ();
		System.out.println ("Digite o número da sala:");
		int numeroDaSala = obterInteiro();
		//Falta metodo obterSala no banco
		Sala sala = Banco.obterSala(numeroDaSala);
		arrayListDaSala.add(sala);
		System.out.println ("Digite o numero correspondente do parâmetro que voce deseja alterar: \n");
		System.out.println ("0- capacidade \n1- numero 2- login 3- 3D");
		int numeroAAlterar = obterInteiro();
		if (numeroAAlterar == 0){
			System.out.println ("Digite a nova capacidade da sala:");
			int capacidade = obterInteiro();
			arrayListDaSala.add(capacidade);
		}
		else {
			arrayListDaSala.add(sala.getCapacidade());
		}
		if (numeroAAlterar == 1){
			System.out.println ("Digite o novo número da sala:");
			int numero = obterInteiro();
			arrayListDaSala.add(numero);
		}
		else {
			arrayListDaSala.add (sala.getNumero());
		}
		
		if (numeroAAlterar == 2){
			System.out.println ("Digite se a sala e 3D:");
			boolean bool = obterBoolean();
			arrayListDaSala.add(bool);
		}
		else {
			arrayListDaSala.add (sala.is3d());
		}
		return arrayListDaSala;
	}
	
	//falta tratar excecao de tipo
	public static String obterString (){
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		return string;
	}
	
	//falta tratar excecao de tipo
	private static int obterInteiro() {
		Scanner sc = new Scanner(System.in);
		int inteiro = sc.nextInt();
		return inteiro;
	}
	
	//falta tratar excecao de tipo
	private static boolean obterBoolean() {
		Scanner sc = new Scanner(System.in);
		System.out.println ("(Digite true ou false)");
		boolean bool = sc.nextBoolean();
		return bool;
	}
	
	
}
