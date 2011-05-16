package executar;
import java.util.ArrayList;

import banco.Banco;

import visualizacao.Exibir;
import visualizacao.InterfaceCinema;
import controlador.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Ei, o banco deveria estar sendo carregado primeiro
		Banco.recuperarDados();
		boolean logado = Controlador.isLogado();
		boolean tipoUser;
		do{
			System.out.println("Favor Logar, vagabundo!");
			ArrayList loginSenha = InterfaceCinema.obterDadosLogin();
			Controlador.logar((Integer) loginSenha.get(0), (String) loginSenha.get(1));
			tipoUser = Controlador.tipoUsuario();
			logado = Controlador.isLogado();
		}while(!logado);
		Exibir.exibirMenu(tipoUser);
	}

}
