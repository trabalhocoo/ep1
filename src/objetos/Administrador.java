package objetos;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
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

	// String filme, int year, int month, int date, int hourOfDay, int minute,
	// int sala, double preco, int disp
	public void adicionarSessao() {
		ArrayList dadosSessao = InterfaceCinema.adicionarSessao();
		String nomeFilme = (String) dadosSessao.get(0);
		int ano = (Integer) dadosSessao.get(1);
		int mes = (Integer) dadosSessao.get(2);
		int dia = (Integer) dadosSessao.get(3);
		int hora = (Integer) dadosSessao.get(4);
		int minuto = (Integer) dadosSessao.get(5);
		int numSala = (Integer) dadosSessao.get(6);
		double preco = (Double) dadosSessao.get(7);

		Filme filme = Banco.obterFilme(nomeFilme);
		Sala sala = Banco.obterSala(numSala);

		Sessao sessaoNova = new Sessao(filme, ano, mes, dia, hora, minuto,
				sala, preco, sala.getCapacidade());
		Banco.addSessao(sessaoNova);
	}

	public void alterarSessao() {
		ArrayList dadosSessao = InterfaceCinema.alterarSessao();
		Calendar dataOriginal = (Calendar) dadosSessao.get(0);
		String nomeFilme = (String) dadosSessao.get(1);
		int ano = (Integer) dadosSessao.get(2);
		int mes = (Integer) dadosSessao.get(3);
		int dia = (Integer) dadosSessao.get(4);
		int hora = (Integer) dadosSessao.get(5);
		int minuto = (Integer) dadosSessao.get(6);
		int numSala = (Integer) dadosSessao.get(7);
		double preco = (Double) dadosSessao.get(8);
		int disp = (Integer) dadosSessao.get(9);

		Filme filme = Banco.obterFilme(nomeFilme);
		Calendar inicio = Calendar.getInstance();
		inicio.set(ano, mes, dia, hora, minuto);
		Sessao sessaoAAlterar = Banco.obterSessao(inicio, numSala);
		Sala salaASerUsada = Banco.obterSala(numSala);

		Banco.modificarSessao(sessaoAAlterar, filme, inicio, salaASerUsada,
				preco);
	}

	public void removerSessao() {
		// Aqui havera o horario de inicio da sessao e a sala
		// int year, int month, int date, int hourOfDay, int minute, int numSala
		// e retornar nessa sequencia
		ArrayList<Integer> dadosSessao = InterfaceCinema.removerSessao();
		int ano = dadosSessao.get(0);
		int mes = dadosSessao.get(1);
		int dia = dadosSessao.get(2);
		int hora = dadosSessao.get(3);
		int minutos = dadosSessao.get(4);
		int numSala = dadosSessao.get(5);

		Calendar inicio = Calendar.getInstance();
		inicio.set(ano, mes, dia, hora, minutos);

		Sessao sessaoARemover = Banco.obterSessao(inicio, numSala);
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
		System.out.println ("Lista de usuarios:");
		Exibir.exibirUsuarios(listaUsuarios);
	}

	public boolean adicionarCaixa() {
		Caixa caixaNova = new Caixa();
		// falta metodo adicionar caixa OK
		System.out.println ("Caixa adicionado com sucesso");
		return Banco.addCaixa(caixaNova);
	}

	public boolean removerCaixa() {
		int caixa = InterfaceCinema.removerCaixa();
		// falta removerCaixa(int) no banco OK
		System.out.println ("Caixa removido com sucesso");
		return Banco.removerCaixa(caixa);
	}

	public void adicionarFilme() throws ParseException {
		// String nome, int faixa, Date duracao, String diretor, String sinopse,
		// String genero, String estreia, boolean is3d
		ArrayList<Object> resposta = InterfaceCinema.adicionarFilme();
		String nome = (String) resposta.get(0);
		int faixa = (Integer) resposta.get(1);
		int duracao = (Integer) resposta.get(2);
		String diretor = (String) resposta.get(3);
		String sinopse = (String) resposta.get(4);
		String genero = (String) resposta.get(5);
		String estreia = (String) resposta.get(6);
		boolean eh3d = (Boolean) resposta.get(7);

		Filme filmeNovo = new Filme(nome, faixa, duracao, diretor, sinopse,
				genero, estreia, eh3d);
		Banco.adicionarFilme(filmeNovo);
		System.out.println ("Filme adicionado com sucesso");
	}

	public void alterarFilme() {
		ArrayList dadosFilme = InterfaceCinema.alterarFilme();
		String nomeDoFilme = (String) dadosFilme.get(0);
		Filme filmeAAlterar = Banco.obterFilme(nomeDoFilme);

		int faixaEtaria = (Integer) dadosFilme.get(1);
		int duracao = (Integer) dadosFilme.get(2);
		String diretor = (String) dadosFilme.get(3);
		String sinopse = (String) dadosFilme.get(4);
		String genero = (String) dadosFilme.get(5);
		String estreia = (String) dadosFilme.get(6);
		boolean is3d = (Boolean) dadosFilme.get(7);

		Banco.modificarFilme(filmeAAlterar, nomeDoFilme, faixaEtaria, duracao,
				diretor, sinopse, genero, estreia, is3d);
		System.out.println ("Filme alterado com sucesso");
	}

	public boolean removerFilme() {
		Filme filme = InterfaceCinema.removerFilme();
		System.out.println ("Filme removido com sucesso");
		return Banco.removerFilme(filme);
	}

	public void adicionarUsuario() {
		ArrayList dadosUsuario = InterfaceCinema.adicionarUsuario();
		// TODO mexer isso, tem algo estranho
		// String nomenome, boolean admadm, String loginlogin, String passwd
		String nome = (String) dadosUsuario.get(0);
		boolean adm = (Boolean) dadosUsuario.get(1);
		String senha = (String) dadosUsuario.get(3);
		String login = "0";
		if (adm == true) {
			login = "1";
		}
		Usuario novoUsuario;
		if (adm) {
			novoUsuario = new Administrador(nome, adm, login, senha);
		} else {
			novoUsuario = new Usuario(nome, adm, login, senha);
		}
		Banco.addUsuario(novoUsuario);
		System.out.println ("Usuario criado com sucesso.Registro: " + novoUsuario.getRegistro());
	}

	
	public boolean removerUsuario() {
		int registro = InterfaceCinema.removerUsuario();
		Usuario usuario = Banco.obterUsuario(registro);
		System.out.println ("Usuario removido com sucesso");
		return Banco.removerUsuario(usuario);
	}

	public void alterarUsuario() {
		// 0: usuario, 1: nome, 2: ehadmin, 3: senha
		ArrayList<Object> resposta = InterfaceCinema.alterarUsuario();

		Usuario usuarioAAlterar = (Usuario) resposta.get(0);
		String nome = (String) resposta.get(1);
		boolean ehAdmin = (Boolean) resposta.get(2);
		String senha = (String) resposta.get(3);

		// Cuidado com os índices. ArrayList começa em 0
		Banco.modificarUsuario(usuarioAAlterar, nome, ehAdmin,
				usuarioAAlterar.getLogin(), senha);
		System.out.println ("Usuario alterado com sucesso");
	}

	public void removerSala() {
		Integer numSala = InterfaceCinema.removerSala();
		Sala salaASair = Banco.obterSala(numSala);
		Banco.removerSala(salaASair);
		System.out.println ("Sala removida com sucesso");
	}

	public void alterarCaixa() {
		ArrayList dadosCaixas = InterfaceCinema.alterarCaixa();
		int numero = (Integer) dadosCaixas.get(0);
		double dinheiro = (Double) dadosCaixas.get(1);
		Banco.modificarCaixa(numero, dinheiro);
		System.out.println ("Caixa alterado com sucesso");

	}

	public void exibirCaixas() {
		TreeSet<Caixa> listaCaixas = Banco.getCaixas();
		Exibir.exibirCaixas(listaCaixas);
	}

}
