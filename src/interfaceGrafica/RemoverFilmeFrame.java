package interfaceGrafica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import objetos.Administrador;
import objetos.Usuario;

public class RemoverFilmeFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField textField;
	
	public RemoverFilmeFrame() {
		this.usuarioLogado = usuarioLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		JLabel lblDigiteONumero = new JLabel("Escolha o filme que deseja remover:");
		lblDigiteONumero.setBounds(22, 38, 483, 14);
		getContentPane().add(lblDigiteONumero);
		
		
		
		
		//voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		btnVoltar.setBounds(387, 259, 89, 23);
		getContentPane().add(btnVoltar);
		
		
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
