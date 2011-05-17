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
		//sempre que for true é admin
		if(tipoUser == true){
			System.out.println("=====> MENU ADMIN <=====");
			System.out.println();
			System.out.println("1  - CRIAR USUARIO");
			System.out.println("2  - EDITAR USUARIO");
			System.out.println("3  - DELETAR USUARIO");
			System.out.println("4  - LISTAR USUARIOS");
			System.out.println();
			System.out.println("5  - CRIAR FILME");
			System.out.println("6  - EDITAR FILME");
			System.out.println("7  - REMOVER FILME");
			System.out.println("8  - LISTAR FILMES");
			System.out.println();
			System.out.println("9  - CRIAR SALA");
			System.out.println("10 - EDITAR SALA");
			System.out.println("11 - REMOVER SALA");
			System.out.println("12 - LISTAR SALAS");
			System.out.println();
			System.out.println("13 - CRIAR SESSAO");
			System.out.println("14 - EDITAR SESSAO");
			System.out.println("15 - REMOVER SESSAO");
			System.out.println("16 - LISTAR SESSOES");
			System.out.println();
			System.out.println("17 - CRIAR CAIXA");
			System.out.println("18 - EDITAR CAIXA");
			System.out.println("19 - REMOVER CAIXA");
			System.out.println("20 - LISTAR CAIXAS");
			System.out.println();
			System.out.println("21 - DESLOGAR");
			System.out.println("22 - SAIR DO PROGRAMA");
		}else{
			System.out.println("=====> MENU USUARIO <=====");
			System.out.println();
			System.out.println("1 - LISTAR FILMES");
			//TODO decidir se ele pode listar salas
			System.out.println("2 - LISTAR SALAS");
			System.out.println("3 - LISTAR SESSOES");
			System.out.println("4 - VENDER INGRESSO");
			System.out.println("5 - DESLOGAR");
			System.out.println("6 - SAIR DO PROGRAMA");
		}
	}
}
