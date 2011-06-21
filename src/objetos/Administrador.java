package objetos;

import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.TreeSet;

import registro.RegistroOutros;

import visualizacao.Exibir;
import visualizacao.InterfaceCinema;

import banco.Banco;

public class Administrador extends Decorator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario userDecorado;
	
	

	public Usuario getUserDecorado() {
		return userDecorado;
	}

	public Administrador(Usuario userDecorado) {
		super(userDecorado.getNome(), true, userDecorado.getLogin(), userDecorado.getSenha());
		this.userDecorado = userDecorado;
		this.setRegistro(getRegistro()-1);
		
	}

	// String filme, int year, int month, int date, int hourOfDay, int minute,
	// int sala, double preco, int disp
	public void adicionarSessao(Usuario usuario, ArrayList dadosSessao ) {
		String nomeFilme = (String) dadosSessao.get(0);
		int ano = (Integer) dadosSessao.get(1);
		int mes = (Integer) dadosSessao.get(2);
		int dia = (Integer) dadosSessao.get(3);
		int hora = (Integer) dadosSessao.get(4);
		int minuto = (Integer) dadosSessao.get(5);
		int numSala = (Integer) dadosSessao.get(6);
		double preco = (Double) dadosSessao.get(7);

		Filme filme = Banco.obterFilme(nomeFilme);
		if(filme == null){
			System.out.println("O Filme que voc� escolheu n�o existe. Tente novamente");
			return;
		}
		Sala sala = Banco.obterSala(numSala);
		if(sala == null){
			System.out.println("A sala que voc� escolheu n�o existe. Tente novamente");
			return;
		}
		if(filme.isIs3d() == true && sala.is3d() == false){
			System.out.println("Esta sala n�o suporta um filme em 3d");
			return;
		}

		Sessao sessaoNova = new Sessao(filme, ano, mes, dia, hora, minuto,
				sala, preco, sala.getCapacidade());
		Banco.addSessao(sessaoNova);
		RegistroOutros.registrarSessao(" Registrou sessao ", sessaoNova,
				usuario);
		System.out.println("Sessao adicionada com sucesso.\n");
	}

	public boolean alterarSessao(Usuario usuario, ArrayList dadosSessao) {
		//ArrayList dadosSessao = InterfaceCinema.alterarSessao();
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

		boolean alterou = Banco.modificarSessao(sessaoAAlterar, filme, inicio,
				salaASerUsada, preco);
		if (alterou == true) {
			
			RegistroOutros.registrarSessao(" Alterou sessao ", sessaoAAlterar,
					usuario);
			return true;
		} else
			return false;
	}

	public boolean removerSessao(Usuario usuario, int nroSessao) {
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

		boolean removeu = Banco.removerSessao(nroSessao);
		if (removeu == true) {
			RegistroOutros.registrarSessao(" Removeu sessao ", null, usuario);
			return true;
		} else
			return false;
			
	}

	public void adicionarSala(ArrayList sala) {
		// int capacidade, int numero, boolean is3d
		int capacidade = (Integer) sala.get(0);
		int numero = (Integer) sala.get(1);
		boolean eh3d = (Boolean) sala.get(2);
		Sala salaNova = new Sala(capacidade, numero, eh3d);
		Banco.addSala(salaNova);
		//System.out.println("Sala adicionada com sucesso.\n");
		//RegistroOutros.registrarSala(" Adicionou sala \n", salaNova, usuario);
	}

	public boolean alterarSala(ArrayList salaAdd) {
		Sala sala = (Sala) salaAdd.get(0);
		int capacidade = (Integer) salaAdd.get(1);
		int numero = (Integer) salaAdd.get(2);
		boolean eh3d = (Boolean) salaAdd.get(3);
		boolean alterou = Banco.modificarSala(sala, capacidade, numero, eh3d);
		/*if (alterou == true) {
			System.out.println("Sala alterada com sucesso.\n");
			//RegistroOutros.registrarSala(" Alterou sala ", sala, usuario);
		} else
			//System.out.println("Sala nao encontrada.\n");*/
			return alterou;
	}

	public void exibirUsuarios() {// listar os usuarios existentes
		TreeSet<Usuario> listaUsuarios = Banco.getUsuarios();
		System.out.println("Lista de usuarios:");
		Exibir.exibirUsuarios(listaUsuarios);
	}
	
	public String[][] exibirUsuariosTabela() {// listar os usuarios existentes
		TreeSet<Usuario> listaUsuarios = Banco.getUsuarios();
		System.out.println("Lista de usuarios:");
		return Exibir.exibirUsuariosTabela(listaUsuarios);
	}

	public boolean adicionarCaixa() {
		Caixa caixaNova = new Caixa();
		//System.out.println("Caixa adicionado com sucesso.\n");
		return Banco.addCaixa(caixaNova);
	}

	public boolean removerCaixa(int caixa) {
		boolean removeu = Banco.removerCaixa(caixa);
		/*if (removeu == true)
			System.out.println("Caixa removido com sucesso.\n");
		else
			System.out.println("Caixa nao encontrado.\n");*/
		return removeu;

	}

	public void adicionarFilme(ArrayList dadosFilme) {
		// String nome, int faixa, Date duracao, String diretor, String sinopse,
		// String genero, String estreia, boolean is3d
		String nome = (String) dadosFilme.get(0);
		int faixa = (Integer) dadosFilme.get(1);
		int duracao = (Integer) dadosFilme.get(2);
		String diretor = (String) dadosFilme.get(3);
		String sinopse = (String) dadosFilme.get(4);
		String genero = (String) dadosFilme.get(5);
		String estreia = (String) dadosFilme.get(6);
		boolean eh3d = (Boolean) dadosFilme.get(7);

		Filme filmeNovo = new Filme(nome, faixa, duracao, diretor, sinopse,
				genero, estreia, eh3d);
		Banco.adicionarFilme(filmeNovo);
		//System.out.println("Filme adicionado com sucesso.\n");
	}

	public boolean alterarFilme(ArrayList dadosFilme) {
		String nomeDoFilme = (String) dadosFilme.get(0);
		Filme filmeAAlterar = Banco.obterFilme(nomeDoFilme);

		String novoNome = (String) dadosFilme.get(1);
		int faixaEtaria = (Integer) dadosFilme.get(2);
		int duracao = (Integer) dadosFilme.get(3);
		String diretor = (String) dadosFilme.get(4);
		String sinopse = (String) dadosFilme.get(5);
		String genero = (String) dadosFilme.get(6);
		String estreia = (String) dadosFilme.get(7);
		boolean is3d = (Boolean) dadosFilme.get(8);

		boolean alterou = Banco.modificarFilme(filmeAAlterar, novoNome,
				faixaEtaria, duracao, diretor, sinopse, genero, estreia, is3d);
		return alterou;
	}

	public boolean removerFilme(String nomeDoFilme) {
		Filme filme = Banco.obterFilme(nomeDoFilme);
		boolean removeu = Banco.removerFilme(filme);
		/*
		if (removeu == true)
			System.out.println("Filme removido com sucesso.\n");
		else
			System.out.println("Filme nao encontrado.\n");*/
		return removeu;
	}

	public void adicionarUsuario(ArrayList dadosUsuario) {
		//ArrayList dadosUsuario = InterfaceCinema.adicionarUsuario();
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
			novoUsuario = new Vendedor(nome, adm, login, senha);
			novoUsuario = new Administrador(novoUsuario);
		} else {
			novoUsuario = new Vendedor(nome, adm, login, senha);
		}
		Banco.addUsuario(novoUsuario);
		/*System.out.println("Usuario criado com sucesso.Registro: "
				+ novoUsuario.getRegistro() + "\n");*/
	}

	public boolean removerUsuario(int registro) {
		Usuario usuario = Banco.obterUsuario(registro);

		boolean removeu = Banco.removerUsuario(usuario);
		/*
		if (removeu == true)
			System.out.println("Usuario removido com sucesso.\n");
		else
			System.out.println("Usuario nao encontrado.\n");*/
		return removeu;
	}

	public boolean alterarUsuario(ArrayList<Object> resposta) {
		// 0: usuario, 1: nome, 2: ehadmin, 3: senha
		//ArrayList<Object> resposta = InterfaceCinema.alterarUsuario();

		Usuario usuarioAAlterar = (Usuario) resposta.get(0);
		String nome = (String) resposta.get(1);
		boolean ehAdmin = (Boolean) resposta.get(2);
		String senha = (String) resposta.get(3);

		boolean modificou = Banco.modificarUsuario(usuarioAAlterar, nome,
				ehAdmin, usuarioAAlterar.getLogin(), senha);
		return modificou;
	}

	public boolean removerSala(int registro) {
		Sala sala = Banco.obterSala(registro);

		boolean removeu = Banco.removerSala(sala);
		/*
		if (removeu == true)
			System.out.println("Usuario removido com sucesso.\n");
		else
			System.out.println("Usuario nao encontrado.\n");*/
		return removeu;
	}

	public boolean alterarCaixa(ArrayList dadosCaixas) {
		int numero = (Integer) dadosCaixas.get(0);
		double dinheiro = (Double) dadosCaixas.get(1);
		boolean alterou = Banco.modificarCaixa(numero, dinheiro);
		return alterou;

	}

	public void exibirCaixas() {
		TreeSet<Caixa> listaCaixas = Banco.getCaixas();
		//System.out.println("Lista de Caixas:");
		Exibir.exibirCaixas(listaCaixas);
	}
	
	public String[][] exibirCaixasTabela() {
		TreeSet<Caixa> listaCaixas = Banco.getCaixas();
		System.out.println("Lista de Caixas:");
		return Exibir.exibirCaixasTabela(listaCaixas);
	}

}
