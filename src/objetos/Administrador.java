package objetos;

import java.sql.Date;

public class Administrador extends Usuario {
	
	
	Administrador(String nomenome, int registroregistro, 
			boolean admadm, String loginlogin,
			String senhasenha)
	{
		nome=nomenome;
		registro=registroregistro;
		ehAdministrador=admadm;
		login=loginlogin;
		senha=senhasenha;
	}
		
	void addSessao(Filme filme, Date hora, Sala sala, double Preco, boolean is3d){
		
	}
	
	/* 
	 * IMPLEMENTAR O RESTO, pls
	 */
}
