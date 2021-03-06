package objetos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;

public class Sessao implements Serializable, Comparable<Sessao> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int numeroDeSessoes = 0;
	private int numero;
	private Filme filme;
	private Calendar horarioDeInicio;
	private Calendar horarioDeFim;
	private Sala sala;
	private double preco;
	private int lugaresDisponiveis;
	public static int tempoIntervalo = 15;
	private boolean vendeu = false;
	
	Sessao(Filme filme, int year, int month, int date, int hourOfDay, int minute, Sala sala, double preco, int disp)
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
		numeroDeSessoes++;
		numero = numeroDeSessoes;
	}
	
	public boolean getVendeu() {
		return vendeu;
	}

	public void setVendeu(boolean vendeu) {
		this.vendeu = vendeu;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
		if (lugaresDisponiveis >= 0)
			this.lugaresDisponiveis = lugaresDisponiveis;
	}

	public void setHorarioDeInicio(Calendar horaInicio) {
		//TODO deve atualizar automaticamente a hora de fim
		horarioDeInicio = horaInicio; 
	}

	public void setHorarioDeFim(Calendar horaFim) {
		horarioDeFim = horaFim;
	}

	public Calendar getHorarioDeInicio() {
		return horarioDeInicio;
	}

	@Override
	public int compareTo(Sessao o) {
		/*
		if(o.getHorarioDeInicio().after(getHorarioDeInicio())){
			return -1;
		}else if(o.getHorarioDeInicio().equals(getHorarioDeInicio())){
			return 0;
		}
		return 1;
		*/
		if(numero < o.numero){
			return -1;
		}else if(numero == o.numero){
			return 0;
		}else{
			return 1;
		}
	}

	public static int getNumeroDeSessoes() {
		return numeroDeSessoes;
	}

	public static void setNumeroDeSessoes(int numeroDeSessoes) {
		Sessao.numeroDeSessoes = numeroDeSessoes;
	}

}
