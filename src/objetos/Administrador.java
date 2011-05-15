package objetos;

import java.io.Serializable;
import java.sql.Date;

public class Administrador extends Usuario implements Serializable {
	
	
	Administrador (String nomenome, int registroregistro, boolean admadm, String loginlogin, String senhasenha){
		nome=nomenome;
		registro=registroregistro;
		ehAdministrador=admadm;
		login=loginlogin;
		senha=senhasenha;
	}
		
	void addSessao(Filme filme, Date hora, Sala sala, double Preco, boolean is3d){
		
	}
	
	void modificarSessão(Sessao sessao, Filme filme, Date hora, Sala sala, double Preco, boolean 3d){
		
	}
	
	boolean removerSessão(Sessao sessao){
		
		return();
	}
	
	void addSala(int capacidade, int numero, boolean 3d){
		
	}
	
	void modificarSala(Sala sala, int capacidade, int numero, boolean 3d){
		
	}
	
	boolean removerSala(Sala sala){
		
	}
	
	boolean addCaixa( int numero){
		
	}
	
	boolean removerCaixa(Caixa caixa){
		
	}
	
	void addFilme(String nome, int faixaEtaria, int horas, int minutos, String Diretor, String gênero, Calendar dataEstreia){
		
	}
	
	void modificarFilme(Filme filme, String nome, int faixaEtaria, int horas, int minutos, String diretor, String gênero, Data dataEstreia){
		
	}
	
	boolean removerFilme(Filme filme){
		
	}
	
	void addUsuario(String nome, boolean ehAdmin, String login, String senha){
		
	}
		
	boolean removerUsuario(Usuario usuario){
		
	}
	
	void modificarUsuario(Usuario usuario, String nome, boolean ehAdmin, String login, String senha){
		
	}
	
	/* 
	 * IMPLEMENTAR O RESTO, pls
	 */
}
