package interfaceGrafica;
import java.awt.Color;
import javax.swing.*;

import objetos.*;
import banco.Banco;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditarCaixaFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField textField;
	
	
	public EditarCaixaFrame (Usuario usrLogado){
		usuarioLogado = usrLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(375, 259, 131, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnVoltar);
		
		JLabel label = new JLabel("Digite o numero do caixa que deseja alterar: ");
		label.setBounds(35, 83, 483, 14);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(359, 80, 53, 20);
		getContentPane().add(textField);
		
		JButton button = new JButton("OK");
		button.setBounds(431, 79, 58, 23);
		getContentPane().add(button);
		
		JLabel label_1 = new JLabel("Altere os campos desejados:");
		label_1.setBounds(35, 116, 239, 14);
		getContentPane().add(label_1);
		
		JLabel lblNoSeiAinda = new JLabel("N\u00E3o sei ainda o q alterar...");
		lblNoSeiAinda.setBounds(65, 173, 249, 14);
		getContentPane().add(lblNoSeiAinda);
		
	}
	
	// Makes the frame visible.
	public void showIt(){
		this.setVisible(true);
	}
	
	// Makes the frame invisible.
	public void hideIt(){
		this.setVisible(false);
	}
	
	// Makes the frame visible and sets the title text.
	public void showIt(String title){
		this.setTitle(title);
		this.setVisible(true);
	}
	
	// Makes the frame visible and sets the title text
	// and the position of the window.
	public void showIt(String title,int x, int y){
		this.setTitle(title);
		this.setLocation(x,y);
		this.setVisible(true);
	}
}
