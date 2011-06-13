package interfaceGrafica;
import javax.swing.*;
import objetos.*;
import java.awt.*;
import banco.Banco;
import controlador.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginSenhaFrame extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	
	public LoginSenhaFrame()
	{
		this.setSize(250,250);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblNewLabel = new JLabel("DIGITE SEU LOGIN E SENHA:");
		lblNewLabel.setBounds(40, 39, 213, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(40, 79, 46, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(40, 110, 46, 14);
		getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(85, 76, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 107, 86, 20);
		getContentPane().add(passwordField);
		//senha = passwordField.getPassword().toString();
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(95, 141, 63, 20);
		getContentPane().add(btnOk);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label.setForeground(Color.BLACK);
		label.setBounds(10, 170, 222, 14);
		getContentPane().add(label);
		
		final JLabel lblNewLabel_1 = new JLabel("");//vazio por enquanto
		lblNewLabel_1.setBounds(40, 172, 200, 14);
		getContentPane().add(lblNewLabel_1);
		
		
		
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//teria que logar e perguntar qual é o usuario que logou e depois decidir se aparece o usuarioframe ou adminframe
				boolean logou = false;
				boolean logado = Controlador.isLogado();
				boolean tipoUser;
				boolean reiniciar = true;
				Controlador.setReiniciar(reiniciar);
				Banco.recuperarDados();
				int login = Integer.parseInt(textField.getText());
				String senha = passwordField.getText();
				Usuario usuario;
				//System.out.println (tipoUser);
				try{
					logou = Controlador.logar(login, senha);
				}
				catch (Exception e){
					System.out.print(e);
				}
				tipoUser = Controlador.tipoUsuario();
				logado = Controlador.isLogado();
				usuario = Controlador.obterUsuario(login, senha);
				if(!logou){
					lblNewLabel_1.setOpaque(false);
					lblNewLabel_1.setForeground(Color.red);
					textField.setText("");
					passwordField.setText("");
					lblNewLabel_1.setText("O login e/ou senha inválidos");
				}
				else {
					if (tipoUser){
						AdminFrame admfr = new AdminFrame(usuario);
						admfr.showIt("Menu Admin");
					} else {
						UsuarioFrame usfr = new UsuarioFrame(usuario);
						usfr.showIt("Menu Usuário");
					}
					hideIt();
				}
			}
		});
		
	}
	

	// Makes the frame visible.
	public void showIt(){
		this.setVisible(true);
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
	
	// Makes the frame invisible.
	public void hideIt(){
	this.setVisible(false);
	}
}
