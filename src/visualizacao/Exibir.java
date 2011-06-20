package visualizacao;
import java.util.Date;
import java.util.ArrayList;
import java.util.TreeSet;
import objetos.*;

public class Exibir {
	
	public static void exibirSessoes(TreeSet <Sessao> sessoes){
		for(Sessao sessao : sessoes)
			System.out.println("Filme: " + sessao.getFilme().getNome()+ "\tHora de inicio: " + sessao.getHorarioDeInicio().getTime() + "\tSala: " +sessao.getSala().getNumero()+ "\tPreco: " +sessao.getPreco());
	}
	
	public static String[][] exibirSessoesTabela(TreeSet <Sessao> sessoes){
		String[][] sessao = new String[sessoes.size()][4];
		int i = 0;
		for(Sessao tipo : sessoes){
			for(int j=0; j < 4; j++){
				Date data = (Date) tipo.getHorarioDeInicio().getTime();
				sessao[i][0] = tipo.getFilme().getNome();
				sessao[i][1] = String.valueOf(data);
				sessao[i][2] = String.valueOf(tipo.getSala().getNumero());
				sessao[i][3] = String.valueOf(tipo.getPreco());
			}
			i++;
		}
		return sessao;
	}	
	
	public static void exibirFilmes(ArrayList<Filme> listaFilmes){
		for(Filme filme : listaFilmes)
			System.out.println("Titulo: " +filme.getNome()+ "\tDuracao: " +filme.getDuracao() + "\tGenero: " + filme.getGenero());
	}
	
	public static String[][] exibirFilmesTabela(ArrayList<Filme> listaFilmes){
		String[][] filmes = new String[listaFilmes.size()][3];
		int i = 0;
		for(Filme filme : listaFilmes){
			for(int j=0; j < 3; j++){
				int duracao =  filme.getDuracao();
				filmes[i][0] = filme.getNome();
				filmes[i][1] = String.valueOf(duracao);
				filmes[i][2] = filme.getGenero();
			}
			i++;
		}
		return filmes;
	}	
	
	public static void exibirUsuarios(TreeSet<Usuario> usuarios){
		for(Usuario user: usuarios){
			String tipoUser;
			if(user.isEhAdministrador())
				tipoUser = "admin";
			else
				tipoUser = "user comum";
			System.out.println("Nome: " +user.getNome()+ "\t#registro: " +user.getRegistro()+ "\tTipo de Usuario: " +tipoUser);
		}
	}
	
	public static String[][] exibirUsuariosTabela(TreeSet<Usuario> usuarios){
		String[][] users = new String[usuarios.size()][3];
		int i = 0;
		for(Usuario user: usuarios){
			for(int j=0; j < 3; j++){
				String tipoUser;
				if(user.isEhAdministrador())
					tipoUser = "admin";
				else
					tipoUser = "user comum";
				int registro =  user.getRegistro();
				users[i][0] = user.getNome();
				users[i][1] = String.valueOf(registro);
				users[i][2] = tipoUser;
			}
			i++;
		}
		return users;
	}
	
	public static void exibirSalas(TreeSet<Sala> listaSalas) {
		for(Sala sala : listaSalas){
			System.out.println("Numero: " + sala.getNumero() + "\tCapacidade: " + sala.getCapacidade());
		}
	}
	
	public static String[][] exibirSalasTabela(TreeSet<Sala> listaSalas){
		String[][] salas = new String[listaSalas.size()][3];
		int i = 0;
		for(Sala sala : listaSalas){
			for(int j=0; j < 2; j++){
				int capacidade =  sala.getCapacidade();
				String tres_d;
				if(sala.is3d())
					tres_d = "sim";
				else
					tres_d = "nao";
				salas[i][0] = String.valueOf(capacidade);
				salas[i][1] = String.valueOf(sala.getNumero());
				salas[i][2] = String.valueOf(tres_d);
			}
			i++;
		}
		return salas;
	}
	
	public static void exibirCaixas(TreeSet<Caixa> listaDeCaixas) {
		for(Caixa caixa : listaDeCaixas){
			System.out.println("Número " + caixa.getNumCaixa() + "\tDinheiro: " + caixa.getDinheiro());
		}	
	}
	
	public static String[][] exibirCaixasTabela(TreeSet<Caixa> listaDeCaixas){
		String[][] caixas = new String[listaDeCaixas.size()][2];
		int i = 0;
		for(Caixa caixa : listaDeCaixas){
			for(int j=0; j < 2; j++){
				caixas[i][0] = String.valueOf(caixa.getNumCaixa());
				caixas[i][1] = String.valueOf(caixa.getDinheiro());
			}
			i++;
		}
		return caixas;
	}
	
	public static void exibirMenu(boolean tipoUser){
		//sempre que for true é admin
		if(tipoUser == true){
			System.out.println("=====> MENU ADMIN <=====");
			System.out.println();
			System.out.println("1  - CRIAR USUARIO	5  - CRIAR FILME	9  - CRIAR SALA");
			System.out.println("2  - EDITAR USUARIO	6  - EDITAR FILME	10 - EDITAR SALA");
			System.out.println("3  - DELETAR USUARIO	7  - REMOVER FILME	11 - REMOVER SALA");
			System.out.println("4  - LISTAR USUARIOS	8  - LISTAR FILMES	12 - LISTAR SALAS");
			System.out.println();
			System.out.println("13 - CRIAR SESSAO	17 - CRIAR CAIXA	21 - DESLOGAR");
			System.out.println("14 - EDITAR SESSAO	18 - EDITAR CAIXA	22 - SAIR DO PROGRAMA");
			System.out.println("15 - REMOVER SESSAO	19 - REMOVER CAIXA");
			System.out.println("16 - LISTAR SESSOES	20 - LISTAR CAIXAS");
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
