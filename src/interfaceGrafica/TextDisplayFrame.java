package interfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;


public class TextDisplayFrame extends JFrame{

	private JLabel valueLabel;

	public TextDisplayFrame(String exibir){
		
		valueLabel = new JLabel(exibir);
		this.setSize(500,500);
		this.add(valueLabel, BorderLayout.SOUTH);
	}
	
}
