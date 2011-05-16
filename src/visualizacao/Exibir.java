package visualizacao;
import java.util.ArrayList;
import java.util.TreeSet;
import objetos.*;

public class Exibir {
	
	public static void exibirSessoes(TreeSet<Sessao> sessoes){
		for(Sessao sessao : sessoes)
			System.out.println("Filme: " +sessao.getFilme()+ " Hora de inicio: " +sessao.getHorarioDeInicio()+ " Sala: " +sessao.getSala()+ " Preco: " +sessao.getPreco());
	}
	
	public static void exibirFilmes(ArrayList<Filme> listaFilmes){
		for(Filme filme : listaFilmes)
			System.out.println("Titulo: " +filme.getNome()+ " Duracao: " +filme.getDuracao());
	}	
	
	public static void exibirUsuarios(TreeSet<Usuario> usuarios){
		for(Usuario user: usuarios){
			String tipoUser;
			if(user.isEhAdministrador())
				tipoUser = "admin";
			else
				tipoUser = "user comum";
			System.out.println("Nome: " +user.getNome()+ " #registro: " +user.getRegistro()+ " Tipo de Usuario: " +tipoUser);
		}
	}
	
	public static void exibirMenu(boolean tipoUser){
		if(tipoUser == true){
			System.out.println("=====> MENU ADMIN <=====");
			System.out.println();
			System.out.println("1 - CRIAR USUARIO");
			System.out.println("2 - CRIAR FILME");
			System.out.println("3 - CRIAR SESSAO");
			System.out.println("4 - CRIAR SALA");
			System.out.println("5 - EDITAR USUARIO");
			System.out.println("6 - EDITAR FILME");
			System.out.println("7 - EDITAR SESSAO");
			System.out.println("8 - EDITAR SALA");
			System.out.println("9 - EXIBIR USUARIOS");
			System.out.println("10 - EXIBIR FILMES");
			System.out.println("11 - EXIBIR SESSOES");
			System.out.println("12 - EXIBIR SALAS");
			System.out.println("13 - EXIBIR USUARIOS");
			System.out.println("14 - EXIBIR FILMES");
			System.out.println("15 - EXIBIR SESSOES");
			System.out.println("16 - EXIBIR SALAS");
			//TODO fazer o resto do menu e o menu do usuario normal
		}
	}
}
