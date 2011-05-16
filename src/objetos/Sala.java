package objetos;

import java.io.Serializable;

public class Sala implements Serializable {
	private int capacidade;
	private int numero;
	private boolean is3d;
	
	Sala(int capacidade, int numero, boolean is3d){
		this.capacidade = capacidade;
		this.numero = numero;
		this.is3d = is3d;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isIs3d() {
		return is3d;
	}

	public void setIs3d(boolean is3d) {
		this.is3d = is3d;
	}
	
}
