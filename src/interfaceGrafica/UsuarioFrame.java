package interfaceGrafica;
import javax.swing.*;

import objetos.Usuario;
import java.awt.*;
import java.awt.Font;


public class UsuarioFrame extends JFrame{
	private static Usuario usuarioLogado;
	
	public UsuarioFrame (final Usuario usuario){
		usuarioLogado = usuario;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JButton listarFilmesBtn = new JButton("LISTAR FILMES");
		listarFilmesBtn.setBounds(54, 70, 142, 32);
		getContentPane().add(listarFilmesBtn);
		listarFilmesBtn.addActionListener(new CineListener(this));
		
		JButton listarSalasBtn = new JButton("LISTAR SALAS");
		listarSalasBtn.setBounds(54, 143, 142, 32);
		getContentPane().add(listarSalasBtn);
		listarSalasBtn.addActionListener(new CineListener(this));
		
		JButton listarSessoesBtn = new JButton("LISTAR SESSOES");
		listarSessoesBtn.setBounds(54, 217, 142, 32);
		getContentPane().add(listarSessoesBtn);
		listarSessoesBtn.addActionListener(new CineListener(this));
		
		JButton venderBtn = new JButton("VENDER INGRESSO");
		venderBtn.setBounds(297, 70, 142, 32);
		getContentPane().add(venderBtn);
		venderBtn.addActionListener(new CineListener(this));
		
		JButton deslogarBtn = new JButton("DESLOGAR");
		deslogarBtn.setBounds(297, 143, 142, 32);
		getContentPane().add(deslogarBtn);
		deslogarBtn.addActionListener(new CineListener(this));
		
		JButton sairBtn = new JButton("SAIR DO PROGRAMA");
		sairBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sairBtn.setBounds(297, 217, 142, 32);
		getContentPane().add(sairBtn);
		sairBtn.addActionListener(new CineListener(this));
		
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
	
	public Usuario getUsuario(){
		return usuarioLogado;
	}
}
