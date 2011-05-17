package executar;
import java.text.ParseException;
import java.util.ArrayList;

import banco.Banco;

import visualizacao.Exibir;
import visualizacao.InterfaceCinema;
import controlador.*;

public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		//Ei, o banco deveria estar sendo carregado primeiro
		boolean logado = Controlador.isLogado();
		boolean tipoUser;
		boolean reiniciar = true;
		Controlador.setReiniciar(reiniciar);
		
		do {
			Banco.recuperarDados();
			do{
				System.out.println("Favor Logar, vagabundo!");
				ArrayList loginSenha = InterfaceCinema.obterDadosLogin();
				Controlador.logar((Integer) loginSenha.get(0), (String) loginSenha.get(1));
				tipoUser = Controlador.tipoUsuario();
				logado = Controlador.isLogado();
			}while(!logado);
		
			while(logado == true){
				Exibir.exibirMenu(tipoUser);
				//TODO tratar excessao
				int opcao = InterfaceCinema.recebeOpcao();
				Controlador.executaOpcao(opcao);
				logado = Controlador.isLogado();
			}
			
			reiniciar = Controlador.precisaReiniciar();
		} while(reiniciar == true);
	}

}
