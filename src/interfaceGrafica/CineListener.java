package interfaceGrafica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlador.Controlador;

public class CineListener implements ActionListener{
	
	public UsuarioFrame userFrame;
	
	public CineListener(UsuarioFrame userfr){
		userFrame = userfr;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("LISTAR FILMES")){
			System.out.println("Clicou no listar filmes");
		}
		if(actionCommand.equals("LISTAR SALAS")){
			System.out.println("Clicou no listar salas");
		}
		if(actionCommand.equals("LISTAR SESSOES")){
			System.out.println("Clicou no listar sessoes");
		}
		if(actionCommand.equals("VENDER INGRESSO")){
			System.out.println("Clicou no vender ingresso");
		}
		if(actionCommand.equals("DESLOGAR")){
			System.out.println("Clicou no deslogar");
			Controlador.deslogar(userFrame.getUsuario());
			LoginSenhaFrame logSen = new LoginSenhaFrame();
			logSen.showIt("Identificacao");
			userFrame.hideIt();
		}
		if(actionCommand.equals("SAIR DO PROGRAMA")){
			System.out.println("Clicou no sair do programa");
			Controlador.sairDoPrograma();
		}
	}

}
