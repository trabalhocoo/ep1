package objetos;

import java.io.Serializable;
import java.util.Date;

public class Filme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int faixaEtaria;
	private int duracao;
	private String diretor;
	private String sinopse;
	private String genero;
	private String dataDeEstreia;
	private boolean is3d;
	
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
	
	Filme(String nome, int faixa, int duracao, String diretor, String sinopse, String genero, String estreia, boolean is3d){
		this.nome = nome;
		faixaEtaria = faixa;
		this.duracao = duracao;
		this.diretor = diretor;
		this.sinopse = sinopse;
		this.genero = genero;
		dataDeEstreia = estreia;
		this.is3d = is3d;//Modifiquei o filme
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

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
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

	public boolean isIs3d() {
		return is3d;
	}

	public void setIs3d(boolean is3d) {
		this.is3d = is3d;
	}
	
	
}
