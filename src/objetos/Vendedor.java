package objetos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;

import visualizacao.Exibir;
import visualizacao.InterfaceCinema;
import banco.Banco;
import controlador.Controlador;

public class Vendedor extends Usuario {

	public Vendedor(String nomenome, boolean admadm, String loginlogin,
			String passwd) {
		super(nomenome, admadm, loginlogin, passwd);
		numeroDeUsuarios++;//a criação de um administrador implica inevitavelmente ser um Vendedor sendo 
		//provomido, entao o numero de usuarios só deve aumentar ao ser criado um vendedor
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



}
