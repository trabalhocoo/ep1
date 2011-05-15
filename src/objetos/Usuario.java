package objetos;

public class Usuario {
	private String nome;
	private int registro;
	private boolean ehAdministrador;
	private String login;
	private String senha;
	
	//Faltava colocar o construtor do usuário.
	//Agora não falta mais ;)
	Usuario(String nomenome, int registroregistro, 
			boolean admadm, String loginlogin,
			String senhasenha)
	{
		nome=nomenome;
		registro=registroregistro;
		ehAdministrador=admadm;
		login=loginlogin;
		senha=senhasenha;
	}
	
	boolean vender(Sessao sessao){
		
		return false;
	}
	
	void deslogar(){
		
	}
}