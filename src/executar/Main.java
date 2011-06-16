package executar;
import java.text.ParseException;
import java.util.ArrayList;

import banco.Banco;

import visualizacao.Exibir;
import visualizacao.InterfaceCinema;
import controlador.*;


public class Main{

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) {
		boolean logado = Controlador.isLogado();
		boolean tipoUser;
		boolean reiniciar = true;
		Controlador.setReiniciar(reiniciar);
		
		do {
			Banco.recuperarDados();
			do{
				System.out.println("Favor digitar seu login (numero de registro):");
				ArrayList loginSenha = InterfaceCinema.obterDadosLogin();
				Controlador.logar((Integer) loginSenha.get(0), (String) loginSenha.get(1));
				tipoUser = Controlador.tipoUsuario();
				logado = Controlador.isLogado();
			}while(!logado);
		
			while(logado == true){
				Exibir.exibirMenu(tipoUser);
				int opcao = InterfaceCinema.recebeOpcao();
				Controlador.executaOpcao(opcao);
				logado = Controlador.isLogado();
			}
			
			reiniciar = Controlador.precisaReiniciar();
		} while(reiniciar == true);
	}

}
