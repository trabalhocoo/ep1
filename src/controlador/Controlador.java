package controlador;
import objetos.Usuario;
import banco.*;

public class Controlador{
	private static boolean isLogado;

	public static boolean logar(int registro, String senha){
		Usuario user = Banco.obterUsuario(registro);
		if(user != null){
			if(user.getSenha().equals(senha)){
				isLogado = true;
				return user.isEhAdministrador();
			}
		}
		return false;
	}
	
	public static boolean isLogado() {
		return isLogado;
	}

	public static void setLogado(boolean isLogado) {
		Controlador.isLogado = isLogado;
	}
	
}