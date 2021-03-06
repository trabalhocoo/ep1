package objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TreeSet;

import registro.RegistroVenda;
import visualizacao.Exibir;
import visualizacao.InterfaceCinema;
import banco.*;
import controlador.*;

public abstract class Usuario implements Serializable, Comparable<Usuario> {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected String nome;
	protected int registro;
	protected boolean ehAdministrador;
	protected String login;
	protected String senha;
	protected static int numeroDeUsuarios = 0;

	public static int getNumeroDeUsuarios() {
		return numeroDeUsuarios;
	}

	public static void setNumeroDeUsuarios(int numeroDeUsuarios) {
		Usuario.numeroDeUsuarios = numeroDeUsuarios;
	}

	public Usuario(String nomenome, boolean admadm, String loginlogin,
			String passwd) {

		this.nome = nomenome;
		this.registro = getNumeroDeUsuarios() + 1;
		this.ehAdministrador = admadm;
		this.login = loginlogin;
		this.senha = passwd;
	}

	public void exibirSessoes() {
		TreeSet<Sessao> listaSessoes = Banco.getSessoes();
		System.out.println("Lista de sessoes:");
		Exibir.exibirSessoes(listaSessoes);
	}

	public String[][] exibirSessoesTabela() {
		TreeSet<Sessao> listaSessoes = Banco.getSessoes();
		System.out.println("Lista de sessoes:");
		return Exibir.exibirSessoesTabela(listaSessoes);
	}

	public void exibirFilmes() {
		ArrayList<Filme> listaFilmes = Banco.getFilmes();
		System.out.println("Lista de filmes:");
		Exibir.exibirFilmes(listaFilmes);
	}

	public String[][] exibirFilmesTabela() {
		ArrayList<Filme> listaFilmes = Banco.getFilmes();
		System.out.println("Lista de filmes:");
		return Exibir.exibirFilmesTabela(listaFilmes);
	}

	public void exibirSalas() {
		TreeSet<Sala> listaSalas = Banco.getSalas();
		System.out.println("Lista de salas:");
		Exibir.exibirSalas(listaSalas);
	}

	public String[][] exibirSalasTabela() {
		TreeSet<Sala> listaSalas = Banco.getSalas();
		System.out.println("Lista de salas:");
		return Exibir.exibirSalasTabela(listaSalas);
	}

	/*
	 * public boolean vender(Sessao sessao){ int lugareDispo =
	 * sessao.getLugaresDisponiveis(); if(lugareDispo == 0){
	 * System.out.println("Sessao esta cheia"); return false; } else{
	 * sessao.setLugaresDisponiveis(lugareDispo--); return true; } }
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public boolean isEhAdministrador() {
		return ehAdministrador;
	}

	public void setEhAdministrador(boolean ehAdministrador) {
		this.ehAdministrador = ehAdministrador;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void deslogar() {
		Controlador.setLogado(false);
	}

	public boolean venderIngresso(Usuario usuario, ArrayList dadosSessaoASerVendida, Caixa caixa) {
		Sessao sessaoAAlterar = Banco
				.obterSessao((Integer) dadosSessaoASerVendida.get(0));
		int quantidadeDeIngressosASerVendida = (Integer) dadosSessaoASerVendida
				.get(1);
		int quantidadeFinal = 0;
		if (sessaoAAlterar != null) {
			quantidadeFinal = sessaoAAlterar.getLugaresDisponiveis()
					- quantidadeDeIngressosASerVendida;

			if (quantidadeFinal >= 0 && caixa != null) {
				sessaoAAlterar.setLugaresDisponiveis(quantidadeFinal);
				double dinheiro = quantidadeDeIngressosASerVendida
						* sessaoAAlterar.getPreco();
				caixa.setDinheiro(caixa.getDinheiro() + dinheiro);
				sessaoAAlterar.setVendeu(true);
				RegistroVenda.registrarVenda(" Vendeu ingresso ", sessaoAAlterar, sessaoAAlterar.getPreco(), usuario, caixa);
				return true;
			} 
		}
		return false;
	}

	@Override
	public int compareTo(Usuario o) {
		if (registro < o.registro) {
			return -1;
		} else if (registro == o.registro) {
			return 0;
		}
		return 1;
	}
}