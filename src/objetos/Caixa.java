package objetos;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

import banco.Banco;



public class Caixa implements Serializable, Comparable<Caixa>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int numeroDeCaixas = 0;
	private int numeroDaCaixa;
	private double dinheiro;
	private boolean estaEmUso;

	
	public Caixa(){
		numeroDaCaixa = numeroDeCaixas+1;
		dinheiro = 0;
		numeroDeCaixas = numeroDeCaixas+1;
		estaEmUso = false;
	} 
		
	
	public double getDinheiro() {
		return dinheiro;
	}

	public boolean getEstaEmUso(){
		return estaEmUso;
	}
	public void setEstaEmUso(boolean ESTA){
		estaEmUso = ESTA;
	}
	
	public int getNumeroDaCaixa() {
		return numeroDaCaixa;
	}

	public void setNumeroDaCaixa(int numeroDaCaixa) {
		this.numeroDaCaixa = numeroDaCaixa;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public int getNumCaixa (){
		return numeroDaCaixa;
	}
	public static int getNumeroDeCaixasCriadas(){
		return numeroDeCaixas;
	}

	@Override
	public int compareTo(Caixa arg0) {
		if(arg0.getNumCaixa() > getNumCaixa()){
			return -1;
		}else if(arg0.getNumeroDaCaixa() == getNumCaixa() ){
			return 0;
		}
		return 1;
	}
	
}
