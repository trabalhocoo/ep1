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
	JLabel imageLabel = new JLabel();
	
	public LoginSenhaFrame()
	{
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		// add the image 
	
		JPanel panel1 = new JPanel();
	    ImageIcon pic = new ImageIcon("C:/Documents and Settings/Gisele/My Documents/Elaine/Github/ep1/src/interfaceGrafica/cinema.jpg");
	    panel1.add(new JLabel(pic));
	    panel1.setBounds(20, 76, 236, 233);
	    this.getContentPane().add(panel1);
	    
	    
		JLabel lblNewLabel = new JLabel("DIGITE SEU LOGIN E SENHA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(296, 91, 213, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(296, 135, 46, 21);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(296, 183, 46, 14);
		getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(352, 137, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(352, 182, 86, 20);
		getContentPane().add(passwordField);
		//senha = passwordField.getPassword().toString();
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(363, 227, 63, 20);
		getContentPane().add(btnOk);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label.setForeground(Color.BLACK);
		label.setBounds(10, 170, 222, 14);
		getContentPane().add(label);
		
		final JLabel lblNewLabel_1 = new JLabel("");//vazio por enquanto
		lblNewLabel_1.setBounds(296, 270, 200, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblSicocine = new JLabel("Sicocine");
		lblSicocine.setFont(new Font("QuigleyWiggly", Font.PLAIN, 43));
		lblSicocine.setBounds(198, 27, 228, 38);
		getContentPane().add(lblSicocine);
		
		
		
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//teria que logar e perguntar qual � o usuario que logou e depois decidir se aparece o usuarioframe ou adminframe
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
					lblNewLabel_1.setText("O login e/ou senha invalidos.");
				}
				else {
					if (tipoUser){
						AdminFrame admfr = new AdminFrame((Administrador)usuario);
						admfr.showIt("Menu Admin");
					} else {
						UsuarioFrame usfr = new UsuarioFrame(usuario);
						usfr.showIt("Menu Usuario");
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
