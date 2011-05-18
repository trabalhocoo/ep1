package objetos;

import java.io.Serializable;



public class Caixa implements Serializable, Comparable<Caixa>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int numeroDeCaixas = 0;
	private int numeroDaCaixa;
	private double dinheiro;
	
	public double getDinheiro() {
		return dinheiro;
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

	public Caixa (){
		numeroDaCaixa = numeroDeCaixas++;
	}
	
	public int getNumCaixa (){
		return numeroDaCaixa;
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
