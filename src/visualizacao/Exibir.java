package visualizacao;
import java.io.ObjectInputStream.GetField;
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
	
}
