package controlador;
import objetos.Usuario;
import banco.*;

public class Controlador{
	private static boolean isLogado;
	private static boolean tipoUsuario;

	public static boolean logar(int registro, String senha){
		Usuario user = Banco.obterUsuario(registro);
		if(user != null){
			if(user.getSenha().equals(senha)){
				isLogado = true;
				tipoUsuario = user.isEhAdministrador();
				return true;
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

	public static boolean tipoUsuario() {
		return tipoUsuario;
	}

	public static void setTipoUsuario(boolean tipoUsuario) {
		Controlador.tipoUsuario = tipoUsuario;
	}
	
}