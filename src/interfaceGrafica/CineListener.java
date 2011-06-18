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
			String[][] out = userFrame.getUsuario().exibirFilmesTabela();
			TextDisplayFrame txtdisplay = new TextDisplayFrame(out, "filme");
			txtdisplay.setVisible(true);
		}
		if(actionCommand.equals("LISTAR SALAS")){
			System.out.println("Clicou no listar salas");
			String[][] out = userFrame.getUsuario().exibirSalasTabela();
			TextDisplayFrame txtdisplay = new TextDisplayFrame(out, "sala");
			txtdisplay.setVisible(true);
			
		}
		if(actionCommand.equals("LISTAR SESSOES")){
			System.out.println("Clicou no listar sessoes");
			String[][] out = userFrame.getUsuario().exibirSessoesTabela();
			TextDisplayFrame txtdisplay = new TextDisplayFrame(out, "sessao");
			txtdisplay.setVisible(true);
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
