package objetos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.TreeSet;

import visualizacao.Exibir;
import visualizacao.InterfaceCinema;

import banco.Banco;

public class Administrador extends Usuario implements Serializable {
	
	
	Administrador (String nome, int registro, boolean adm, String login, String senha){
		super(nome, adm, login, senha);
	}
		
	void adicionarSessao(Filme filme, Date hora, Sala sala, double preco, boolean is3d){
		long fim_horario = (long) (hora.getTime() + filme.getDuracao()) ;//falta nao sei como fazer isso teria que somar o horario do inicio +tempo de filme 
		long duracao_final = fim - hora.getTime();
		Date duracao = new Date (duracao_final);
		//nao sei como manipular horas
		Sessao sessaoNova = new Sessao (filme, hora, fim, sala, preco,duracao, sala.getCapacidade());
	}
		
	void alterarSessão(){
		
		//Filme filme, Date inicio, long fim, Sala sala, double preco, 
		//Date duracao, int disp
		Sessao sessaoAAlterar = InterfaceCinema.alterarSessao();
		Banco.modificarSessao(sessaoAAlterar, filmeAAlterar, sessaoAAlterar.getHorarioDeInicio(), sessaoAAlterar.getHorarioDeFim(), sala, sessao.getPreco());
	}
	
	boolean removerSessão(){
		// se der tem que colocar no registro
		//NAO SEI COMO FAZER ISSO
		Sessao sessao = InterfaceCinema.removerSessao();
		//falta remover sessao no interface cinema
		return Banco.removerSessao(Sessao sessao);
	}
	
	public static void adicionarSala(){
		ArrayList resposta = InterfaceCinema.adicionarSala();
		//int capacidade, int numero, boolean is3d
		int capacidade = (Integer) resposta.get(0);
		int numero = (Integer) resposta.get(1);
		boolean eh3d = (Boolean) resposta.get(2);
		Sala salaNova = new Sala(capacidade, numero, eh3d);
		Banco.addSala(salaNova);
	}
	
	void alterarSala(){
		ArrayList <Object> resposta = InterfaceCinema.alterarSala();
		Sala sala = (Sala) resposta.get(0);
		int capacidade = (Integer) resposta.get(1); 
		int numero = (Integer) resposta.get(2);
		boolean eh3d = (Boolean) resposta.get(3);
		Banco.modificarSala(sala, capacidade, numero, eh3d);
	}
	
	void exibirUsuarios(){//listar os usuarios existentes
        TreeSet <Usuario> listaUsuarios = Banco.getUsuarios();
        Exibir.exibirUsuarios(listaUsuarios);
}
	boolean adicionarCaixa(){
		Caixa caixaNova = new Caixa();
		//falta metodo adicionar caixa OK
	return	Banco.addCaixa(caixaNova);
	}
	
	boolean removerCaixa(){
		int caixa = InterfaceCinema.removerCaixa();
		//falta removerCaixa(int) no banco OK
		return Banco.removerCaixa(caixa);
	}
	
	void adicionarFilme(){
		ArrayList <Object> resposta = InterfaceCinema.adicionarFilme();
		int faixa = (Integer) resposta.get(1);
		boolean eh3d = (Boolean) resposta.get(7);
		Date duracao = (Date) resposta.get(2);
		Filme filmeNovo = new Filme (resposta.get(0).toString(), faixa, duracao, resposta.get(3).toString(), resposta.get(4).toString(), resposta.get(5).toString(), resposta.get(6).toString(), eh3d);
		Banco.adicionarFilme (filmeNovo);
	}
	
	void alterarFilme(){
		ArrayList resposta = InterfaceCinema.alterarFilme();
		//falta método obter filme OK
		Filme filmeAAlterar= Banco.obterFilme(resposta.get(0));
		Banco.modificarFilme (filmeAAlterar, resposta.get(1), resposta.get(2), resposta.get(3), resposta.get(4), resposta.get(5);
	}
	
	boolean removerFilme(){
		Filme filme = InterfaceCinema.removerFilme();
		return Banco.removerFilme(filme);
	}
	
	void adicionarUsuario(){
		ArrayList resposta = InterfaceCinema.adicionarUsuario();
		//String nomenome, boolean admadm, String loginlogin, String passwd
		boolean adm = (Boolean) resposta.get(1);
		String login = "0";
		if (adm == true){
			login = "1";
		}
		Usuario novoUsuario = new Usuario (resposta.get(0).toString(), adm, login, resposta.get(3).toString());
		Banco.addUsuario (novoUsuario);
	}
	
	//teoricamente eu vou tirar os parametros de todos os métodos
	boolean removerUsuario(){
		Usuario usuario = InterfaceCinema.removerUsuario();
		return Banco.removerUsuario(usuario);
	}

	void alterarUsuario(){
		ArrayList <Object> resposta = InterfaceCinema.alterarUsuario();
		boolean ehAdmin = (Boolean)resposta.get(2);
		String login = "0";
		if (ehAdmin == true){
			login = "1";
		}
		Usuario usuarioAAlterar = (Usuario) resposta.get(1);
		Banco.modificarUsuario (usuarioAAlterar,resposta.get(1).toString(), ehAdmin,login , resposta.get(3).toString());
	}

}
