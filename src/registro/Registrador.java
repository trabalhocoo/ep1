package registro;

import objetos.Usuario;

public abstract class Registrador {

	public final <E> void registrarAcesso(E object, String texto, Usuario usuario ){
		String palavra = obtemInformacoesDoUsuario(usuario);
		gravaDados(texto, usuario, palavra, object);
	}
	
	static String obtemInformacoesDoUsuario(Usuario usuario){
		String informacoesDeUsuarioEHora  = "Nome do usuario :" + usuario.getNome();
		return informacoesDeUsuarioEHora;
	}
	
	public abstract <E> void gravaDados(String texto, Usuario user, String palavra, E object);
	
	
}
