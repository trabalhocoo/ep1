package interfaceGrafica;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;

import objetos.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriarUsuarioFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private static Usuario usuarioLogado;
	
	
	public CriarUsuarioFrame(final Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		JLabel lblCriarUsurio = new JLabel("1- CRIAR USU\u00C1RIO");
		lblCriarUsurio.setBounds(23, 21, 134, 20);
		getContentPane().add(lblCriarUsurio);
		
		JLabel lblNome = new JLabel("Nome do usuário:");
		lblNome.setBounds(27, 88, 110, 14);
		getContentPane().add(lblNome);
		
		JLabel lblPermissoDeUsurio = new JLabel("Permiss\u00E3o de usu\u00E1rio:");
		lblPermissoDeUsurio.setBounds(33, 144, 134, 20);
		getContentPane().add(lblPermissoDeUsurio);
		
		JLabel label = new JLabel("");
		label.setBounds(70, 176, 46, 14);
		getContentPane().add(label);
		
		final JLabel lblNewLabel_1 = new JLabel("");//vazio por enquanto
		lblNewLabel_1.setBounds(40, 172, 200, 14);
		getContentPane().add(lblNewLabel_1);
		
		String[] options = {"", "Admin", "Usuario"};   
		JComboBox comboBox = new JComboBox(options);
		comboBox.setSelectedIndex(0); 
		comboBox.setBackground(Color.white);
		//comboBox.addActionListener();  
		comboBox.setBounds(163, 144, 104, 20);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(155, 85, 240, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Senha do usuário:");
		label_1.setBounds(33, 204, 110, 14);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 201, 104, 20);
		getContentPane().add(textField_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(70, 259, 89, 23);
		getContentPane().add(btnAdicionar);
		
		JButton btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.setBounds(209, 259, 123, 23);
		getContentPane().add(btnLimparCampos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(usuarioLogado);
				usfr.showIt("Menu Usuário");
				hideIt();
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
