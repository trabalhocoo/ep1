package objetos;

import java.io.Serializable;
import java.sql.Date;

public class Sessao implements Serializable {
	private Filme filme;
	private String horarioDeInicio;
	private String horarioDeFim;
	private Sala sala;
	private double preco;
	private boolean eh3d;
	private Date duracao;
	private int lugaresDisponiveis;
	
	Sessao(Filme filme, String inicio, String fim, Sala sala, double preco, boolean is3d, Date duracao, int disp)
	{
		this.filme = filme;
		this.horarioDeInicio = inicio;
		this.horarioDeFim = fim;
		this.sala = sala;
		this.preco = preco;
		this.eh3d = is3d;
		this.duracao = duracao;
		this.lugaresDisponiveis = disp;

	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public String getHorarioDeInicio() {
		return horarioDeInicio;
	}

	public void setHorarioDeInicio(String horarioDeInicio) {
		this.horarioDeInicio = horarioDeInicio;
	}

	public String getHorarioDeFim() {
		return horarioDeFim;
	}

	public void setHorarioDeFim(String horarioDeFim) {
			this.horarioDeFim = horarioDeFim;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco>0)
			this.preco = preco;
	}

	public boolean isEh3d() {
		return eh3d;
	}

	public void setEh3d(boolean eh3d) {
		this.eh3d = eh3d;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
		horarioDeFim = horarioDeInicio+duracao;
	}

	public int getLugaresDisponiveis() {
		return lugaresDisponiveis;
	}

	public void setLugaresDisponiveis(int lugaresDisponiveis) {
		if(lugaresDisponiveis>0)
		this.lugaresDisponiveis = lugaresDisponiveis;
	}
	
	
	
	
}
