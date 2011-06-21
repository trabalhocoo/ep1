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
	private static int numeroDeCaixasCriados = 0;
	private int numeroDoCaixa;
	private double dinheiro;
	private boolean estaEmUso;

	
	public Caixa(){
		numeroDoCaixa = numeroDeCaixasCriados +1;
		dinheiro = 0;
		numeroDeCaixasCriados = numeroDeCaixasCriados+1;
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
		return numeroDoCaixa;
	}

	public void setNumeroDaCaixa(int numeroDaCaixa) {
		this.numeroDoCaixa = numeroDaCaixa;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public int getNumCaixa (){
		return numeroDoCaixa;
	}
	public static int getNumeroDeCaixasCriados(){
		return numeroDeCaixasCriados;
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
