package controlador;
import objetos.Administrador;
import objetos.Usuario;
import banco.*;

public class Controlador{
	private static boolean isLogado;
	private static boolean tipoUsuario;
	private static Usuario usuarioLogado;

	public static boolean logar(int registro, String senha){
		Usuario user = Banco.obterUsuario(registro);
		usuarioLogado = user;
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
	
	public static void executaOpcao(int opcao){
		if(tipoUsuario == true){
			Administrador admin = (Administrador)usuarioLogado;
			switch (opcao) {
			case 1:
				//Criar usuario
				admin.adicionarUsuario();
				break;
			case 2:
				//Editar usuario
				admin.alterarUsuario();
				break;
			case 3:
				//Remover usuario
				admin.removerUsuario();
				break;
			case 4:
				//Exibir usuarios
				admin.exibirUsuarios();
			default:
				break;
			}
		}else{
			switch (opcao) {
			case 1:
				
				break;

			default:
				break;
			}
		}
		
	}
}