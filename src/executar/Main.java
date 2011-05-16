package executar;
import java.net.InterfaceAddress;
import java.util.ArrayList;

import objetos.Usuario;
import controlador.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean logado = Controlador.isLogado();
		boolean tipoUser;
		do{
			System.out.println("Favor Logar, vagabundo!");
			ArrayList loginSenha = InterfaceCinema.obterDadosLogin();
			Controlador.logar(loginSenha.get(0), loginSenha.get(1));
			tipoUser = Controlador.tipoUsuario();
			logado = Controlador.isLogado();
		}while(!logado);
		InterfaceCinema.menu(tipoUser);
	}

}
