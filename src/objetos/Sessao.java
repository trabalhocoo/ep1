package objetos;

import java.io.Serializable;
import java.util.Date;

public class Sessao implements Serializable {
	private Filme filme;
	private Date horarioDeInicio;
	private long horarioDeFim;
	private Sala sala;
	private double preco;
	private Date duracao;
	private int lugaresDisponiveis;
	
	Sessao(Filme filme, Date inicio, long fim, Sala sala, double preco, Date duracao, int disp)
	{
		this.filme = filme;
		this.horarioDeInicio = inicio;
		this.horarioDeFim = fim;
		this.sala = sala;
		this.preco = preco;
		this.duracao = duracao;
		this.lugaresDisponiveis = disp;

	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Date getHorarioDeInicio() {
		return horarioDeInicio;
	}

	public void setHorarioDeInicio(Date horarioDeInicio) {
		this.horarioDeInicio = horarioDeInicio;
	}

	public long getHorarioDeFim() {
		return horarioDeFim;
	}

	public void setHorarioDeFim(long horarioDeFim) {
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

	public Date getDuracao() {
		return duracao;
	}

	public long setDuracao(Date duracao) {
		this.duracao = duracao;
		long horarioDeFim = duracao.getTime() + horarioDeInicio.getTime();
		this.horarioDeFim = horarioDeFim;
		return this.horarioDeFim;
	}

	public int getLugaresDisponiveis() {
		return lugaresDisponiveis;
	}

	public void setLugaresDisponiveis(int lugaresDisponiveis) {
		if(lugaresDisponiveis>0)
		this.lugaresDisponiveis = lugaresDisponiveis;
	}
	
	
	
	
}
