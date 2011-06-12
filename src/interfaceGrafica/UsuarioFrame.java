package interfaceGrafica;
import javax.swing.*;

import objetos.Usuario;

import java.awt.*;

import controlador.Controlador;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioFrame extends JFrame{
	private static Usuario usuarioLogado;
	
	
	public UsuarioFrame (){
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("LISTAR FILMES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuarioLogado.exibirFilmes();
			}
		});
		btnNewButton.setBounds(54, 70, 142, 32);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("LISTAR SALAS");
		button.setBounds(54, 143, 142, 32);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("LISTAR SESSÕES");
		button_1.setBounds(54, 217, 142, 32);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("VENDER INGRESSO");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_2.setBounds(297, 70, 142, 32);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DESLOGAR");
		button_3.setBounds(297, 143, 142, 32);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("SAIR DO PROGRAMA");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_4.setBounds(297, 217, 142, 32);
		getContentPane().add(button_4);
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
