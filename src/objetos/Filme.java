package objetos;

import java.io.Serializable;

public class Filme implements Serializable {
	private String nome;
	private int faixaEtaria;
	private double duracao;
	private String diretor;
	private String sinopse;
	private String genero;
	private String dataDeEstreia;
	
	/**
	 * 
	 * @param nome
	 * @param faixa
	 * @param duracao
	 * @param diretor
	 * @param sinopse
	 * @param genero
	 * @param estreia
	 * 
	 * Quem vai tratar se os parâmetros estão errados? Será o contrutor? Acho que não
	 */
	
	Filme(String nome, int faixa, double duracao, String diretor, String sinopse, String genero, String estreia){
		this.nome = nome;
		faixaEtaria = faixa;
		this.duracao = duracao;
		this.diretor = diretor;
		this.sinopse = sinopse;
		this.genero = genero;
		dataDeEstreia = estreia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataDeEstreia() {
		return dataDeEstreia;
	}

	public void setDataDeEstreia(String dataDeEstreia) {
		this.dataDeEstreia = dataDeEstreia;
	}
	
	
}
