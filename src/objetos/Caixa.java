package objetos;

public class Caixa {
	private static int numeroDeCaixas =0;
	private int numeroDaCaixa;
	
	public Caixa (){
		numeroDaCaixa = numeroDeCaixas++;
	}
	
	public int getCaixa (){
		return numeroDaCaixa;
	}
	
}
