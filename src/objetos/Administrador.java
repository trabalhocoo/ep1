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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador(String nome, boolean adm, String login,
			String senha) {
		super(nome, adm, login, senha);
	}

	//Filme filme, Date hora, Sala sala, double preco, boolean is3d
	void adicionarSessao() {
		ArrayList dadosSessao = InterfaceCinema.obterDadosSessao();
		long fim_horario = (long) (hora.getTime() + filme.getDuracao());
		// falta nao sei como fazer isso teria que somar o horario do inicio
		// +tempo de filme
		long duracao_final = fim - hora.getTime();
		Date duracao = new Date(duracao_final);
		// nao sei como manipular horas
		Sessao sessaoNova = new Sessao(filme, hora, fim, sala, preco, duracao,
				sala.getCapacidade());
	}

	void alterarSessao() {
		// Filme filme, Date inicio, long fim, Sala sala, double preco,
		// Date duracao, int disp
		ArrayList dadosSessao = InterfaceCinema.alterarSessao();
		Sessao sessaoAAlterar = Banco.obterSessao((Date) dadosSessao.get(1),
				(Integer) dadosSessao.get(6));
		Banco.modificarSessao(sessaoAAlterar, (Filme) dadosSessao.get(0),
				(Date) dadosSessao.get(1), (Long) dadosSessao.get(2),
				(Sala) dadosSessao.get(3), (Double) dadosSessao.get(4));
	}

	void removerSessao() {
		// Aqui havera o horario de inicio da sessao e a sala
		ArrayList dadosSessao = InterfaceCinema.removerSessao();
		Sessao sessaoARemover = Banco.obterSessao((Date) dadosSessao.get(0),
				(Integer) dadosSessao.get(1));
		Banco.removerSessao(sessaoARemover);
	}

	public static void adicionarSala() {
		ArrayList resposta = InterfaceCinema.adicionarSala();
		// int capacidade, int numero, boolean is3d
		int capacidade = (Integer) resposta.get(0);
		int numero = (Integer) resposta.get(1);
		boolean eh3d = (Boolean) resposta.get(2);
		Sala salaNova = new Sala(capacidade, numero, eh3d);
		Banco.addSala(salaNova);
	}

	void alterarSala() {
		ArrayList<Object> resposta = InterfaceCinema.alterarSala();
		Sala sala = (Sala) resposta.get(0);
		int capacidade = (Integer) resposta.get(1);
		int numero = (Integer) resposta.get(2);
		boolean eh3d = (Boolean) resposta.get(3);
		Banco.modificarSala(sala, capacidade, numero, eh3d);
	}

	void exibirUsuarios() {// listar os usuarios existentes
		TreeSet<Usuario> listaUsuarios = Banco.getUsuarios();
		Exibir.exibirUsuarios(listaUsuarios);
	}

	boolean adicionarCaixa() {
		Caixa caixaNova = new Caixa();
		// falta metodo adicionar caixa OK
		return Banco.addCaixa(caixaNova);
	}

	boolean removerCaixa() {
		int caixa = InterfaceCinema.removerCaixa();
		// falta removerCaixa(int) no banco OK
		return Banco.removerCaixa(caixa);
	}

	void adicionarFilme() {
		ArrayList<Object> resposta = InterfaceCinema.adicionarFilme();
		int faixa = (Integer) resposta.get(1);
		boolean eh3d = (Boolean) resposta.get(7);
		Date duracao = (Date) resposta.get(2);
		Filme filmeNovo = new Filme(resposta.get(0).toString(), faixa, duracao,
				resposta.get(3).toString(), resposta.get(4).toString(),
				resposta.get(5).toString(), resposta.get(6).toString(), eh3d);
		Banco.adicionarFilme(filmeNovo);
	}

	void alterarFilme() {
		// String nome, int faixa, Date duracao, String diretor, String sinopse,
		// String genero, String estreia, boolean is3d
		ArrayList resposta = InterfaceCinema.alterarFilme();
		Filme filmeAAlterar = Banco.obterFilme((String) resposta.get(0));
		Banco.modificarFilme(filmeAAlterar, (String) resposta.get(0),
				(Integer) resposta.get(1), (Date) resposta.get(2),
				(String) resposta.get(3), (String) resposta.get(4),
				(String) resposta.get(5), (String) resposta.get(6),
				(Boolean) resposta.get(7));
	}

	boolean removerFilme() {
		Filme filme = InterfaceCinema.removerFilme();
		return Banco.removerFilme(filme);
	}

	void adicionarUsuario() {
		ArrayList resposta = InterfaceCinema.adicionarUsuario();
		// String nomenome, boolean admadm, String loginlogin, String passwd
		boolean adm = (Boolean) resposta.get(1);
		String login = "0";
		if (adm == true) {
			login = "1";
		}
		Usuario novoUsuario = new Usuario(resposta.get(0).toString(), adm,
				login, resposta.get(3).toString());
		Banco.addUsuario(novoUsuario);
	}

	// teoricamente eu vou tirar os parametros de todos os m�todos
	boolean removerUsuario() {
		Usuario usuario = InterfaceCinema.removerUsuario();
		return Banco.removerUsuario(usuario);
	}

	void alterarUsuario() {
		ArrayList<Object> resposta = InterfaceCinema.alterarUsuario();
		boolean ehAdmin = (Boolean) resposta.get(2);
		String login = "0";
		if (ehAdmin == true) {
			login = "1";
		}
		Usuario usuarioAAlterar = (Usuario) resposta.get(1);
		Banco.modificarUsuario(usuarioAAlterar, resposta.get(1).toString(),
				ehAdmin, login, resposta.get(3).toString());
	}

}
