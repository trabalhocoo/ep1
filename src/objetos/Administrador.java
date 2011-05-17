package objetos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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

	public Administrador(String nome, boolean adm, String login, String senha) {
		super(nome, adm, login, senha);
	}

	// Filme filme, Date hora, Sala sala, double preco, boolean is3d
	public void adicionarSessao() {
		// TODO fazer esta coisa funcionar
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

	public void alterarSessao() {
		ArrayList dadosSessao = InterfaceCinema.alterarSessao();
		Filme filme = (Filme) dadosSessao.get(0);
		int ano = (Integer) dadosSessao.get(1);
		int mes = (Integer) dadosSessao.get(2);
		int dia = (Integer) dadosSessao.get(3);
		int hora = (Integer) dadosSessao.get(4);
		int minuto = (Integer) dadosSessao.get(5);
		int numSala = (Integer) dadosSessao.get(6);
		double preco = (Double) dadosSessao.get(7);
		int disp = (Integer) dadosSessao.get(8);
		
		Calendar inicio = Calendar.getInstance();
		inicio.set(ano, mes, dia, hora, minuto);
		
		Sessao sessaoAAlterar = Banco.obterSessao(inicio, numSala);
		Sala salaASerUsada = Banco.obterSala(numSala);
		Banco.modificarSessao(sessaoAAlterar, filme, inicio, salaASerUsada, preco);
	}


	public void removerSessao() {
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

	public void alterarSala() {
		ArrayList<Object> resposta = InterfaceCinema.alterarSala();
		Sala sala = (Sala) resposta.get(0);
		int capacidade = (Integer) resposta.get(1);
		int numero = (Integer) resposta.get(2);
		boolean eh3d = (Boolean) resposta.get(3);
		Banco.modificarSala(sala, capacidade, numero, eh3d);
	}

	public void exibirUsuarios() {// listar os usuarios existentes
		TreeSet<Usuario> listaUsuarios = Banco.getUsuarios();
		Exibir.exibirUsuarios(listaUsuarios);
	}

	public boolean adicionarCaixa() {
		Caixa caixaNova = new Caixa();
		// falta metodo adicionar caixa OK
		return Banco.addCaixa(caixaNova);
	}

	public boolean removerCaixa() {
		int caixa = InterfaceCinema.removerCaixa();
		// falta removerCaixa(int) no banco OK
		return Banco.removerCaixa(caixa);
	}

	public void adicionarFilme() {
		ArrayList<Object> resposta = InterfaceCinema.adicionarFilme();
		int faixa = (Integer) resposta.get(1);
		boolean eh3d = (Boolean) resposta.get(7);
		Date duracao = (Date) resposta.get(2);
		Filme filmeNovo = new Filme(resposta.get(0).toString(), faixa, duracao,
				resposta.get(3).toString(), resposta.get(4).toString(),
				resposta.get(5).toString(), resposta.get(6).toString(), eh3d);
		Banco.adicionarFilme(filmeNovo);
	}

	public void alterarFilme() {
		ArrayList dadosFilme = InterfaceCinema.alterarFilme();
		String nomeDoFilme = (String) dadosFilme.get(0);
		Filme filmeAAlterar = Banco.obterFilme(nomeDoFilme);

		int faixaEtaria = (Integer) dadosFilme.get(1);
		Date duracao = (Date) dadosFilme.get(2);
		String diretor = (String) dadosFilme.get(3);
		String sinopse = (String) dadosFilme.get(4);
		String genero = (String) dadosFilme.get(5);
		String estreia = (String) dadosFilme.get(6);
		boolean is3d = (Boolean) dadosFilme.get(7);

		Banco.modificarFilme(filmeAAlterar, nomeDoFilme, faixaEtaria, duracao,
				diretor, sinopse, genero, estreia, is3d);
	}

	public boolean removerFilme() {
		Filme filme = InterfaceCinema.removerFilme();
		return Banco.removerFilme(filme);
	}

	public void adicionarUsuario() {
		ArrayList dadosUsuario = InterfaceCinema.adicionarUsuario();
		// TODO mexer isso, tem algo estranho
		// String nomenome, boolean admadm, String loginlogin, String passwd
		boolean adm = (Boolean) dadosUsuario.get(1);
		String login = "0";
		if (adm == true) {
			login = "1";
		}
		Usuario novoUsuario = new Usuario(dadosUsuario.get(0).toString(), adm,
				login, dadosUsuario.get(3).toString());
		Banco.addUsuario(novoUsuario);
	}

	// teoricamente eu vou tirar os parametros de todos os m�todos
	public boolean removerUsuario() {
		Usuario usuario = InterfaceCinema.removerUsuario();
		return Banco.removerUsuario(usuario);
	}

	public void alterarUsuario() {
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

	public void removerSala() {
		// TODO Auto-generated method stub
		
	}

	public void alterarCaixa() {
		// TODO Auto-generated method stub
		
	}

	public void exibirCaixas() {
		// TODO Auto-generated method stub
		
	}

}
