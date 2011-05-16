package objetos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Sessao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Filme filme;
	private Calendar horarioDeInicio;
	private Calendar horarioDeFim;
	private Sala sala;
	private double preco;
	private int lugaresDisponiveis;
	public static int tempoIntervalo = 15;
	
	Sessao(Filme filme, int year, int month, int date, int hourOfDay, int minute, Sala sala, double preco, Date duracao, int disp)
	{
		this.filme = filme;
		this.sala = sala;
		this.preco = preco;
		this.lugaresDisponiveis = disp;
		
		horarioDeInicio = Calendar.getInstance();
		horarioDeFim =Calendar.getInstance();
		horarioDeInicio.set(year, month, date, hourOfDay, minute);
		horarioDeFim.set(year, month, date, hourOfDay, minute);
		horarioDeFim.add(Calendar.MINUTE,tempoIntervalo);
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
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
		if (preco > 0)
			this.preco = preco;
	}


	public int getLugaresDisponiveis() {
		return lugaresDisponiveis;
	}

	public void setLugaresDisponiveis(int lugaresDisponiveis) {
		if (lugaresDisponiveis > 0)
			this.lugaresDisponiveis = lugaresDisponiveis;
	}

	public void setHorarioDeInicio(Calendar horaInicio) {
		horarioDeInicio = horaInicio; 
	}

	public void setHorarioDeFim(Calendar horaFim) {
		horarioDeFim = horaFim;
	}

	public Calendar getHorarioDeInicio() {
		return horarioDeInicio;
	}

}
