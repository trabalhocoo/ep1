package interfaceGrafica;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;

import objetos.Administrador;
import objetos.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CriarUsuarioFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private static Usuario usuarioLogado;
	private JComboBox comboBox;
	
	
	public CriarUsuarioFrame(final Usuario usrLogado) {
		usuarioLogado = usrLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		JLabel lblCriarUsurio = new JLabel("1- CRIAR USUARIO");
		lblCriarUsurio.setBounds(23, 21, 134, 20);
		getContentPane().add(lblCriarUsurio);
		
		JLabel lblNome = new JLabel("Nome do usuario:");
		lblNome.setBounds(23, 88, 110, 14);
		getContentPane().add(lblNome);
		
		JLabel lblPermissoDeUsurio = new JLabel("Permissao de usuario:");
		lblPermissoDeUsurio.setBounds(23, 144, 134, 20);
		getContentPane().add(lblPermissoDeUsurio);
		
		JLabel label = new JLabel("");
		label.setBounds(70, 176, 46, 14);
		getContentPane().add(label);
		
		final JLabel lblNewLabel_1 = new JLabel("");//vazio por enquanto
		lblNewLabel_1.setBounds(40, 172, 200, 14);
		getContentPane().add(lblNewLabel_1);
		
		String[] options = {"", "Admin", "Usuario"};   
		comboBox = new JComboBox(options);
		comboBox.setSelectedIndex(0); 
		comboBox.setBackground(Color.white);
		//comboBox.addActionListener();  
		comboBox.setBounds(163, 144, 104, 20);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(163, 85, 240, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Senha do usuario:");
		label_1.setBounds(23, 204, 110, 14);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 201, 104, 20);
		getContentPane().add(textField_1);
		
		final JLabel lblAviso = new JLabel("");//vazio por enquanto
		lblAviso.setBounds(23, 50, 298, 14);
		getContentPane().add(lblAviso);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int option = comboBox.getSelectedIndex();
					String nome = textField.getText();
					String senha = textField_1.getText();
					String permissao = (String)comboBox.getSelectedItem();

					ArrayList dadosUsuario = new ArrayList();
					dadosUsuario.add(nome);
					if(option == 1){
						dadosUsuario.add(true);
						//System.out.println (permissao);
					}
					else if (option == 2){
						dadosUsuario.add(false);
						//System.out.println (permissao);
					}
					
					if(option ==0 || nome.equals("")|| senha.equals("")){
						lblAviso.setOpaque(false);
						lblAviso.setForeground(Color.red);
						lblAviso.setText("Por favor, digite todos os campos.");
					}
					else {
						dadosUsuario.add(2);
						dadosUsuario.add(senha);
						admin.adicionarUsuario(dadosUsuario);
						lblAviso.setOpaque(false);
						lblAviso.setForeground(Color.red);
						lblAviso.setText("Usuario criado com sucesso. Login: " + usuarioLogado.getNumeroDeUsuarios() + " Senha: " + senha); 
						textField_1.setText("");
						comboBox.setSelectedIndex(0);
						textField.setText("");
					}
				}
				catch (Exception e){
					System.out.print(e);
				}
				
			}
		});
		btnAdicionar.setBounds(46, 259, 123, 23);
		getContentPane().add(btnAdicionar);
		
		JButton btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				comboBox.setSelectedIndex(0);
				textField.setText("");
			}
		});
		btnLimparCampos.setBounds(209, 259, 123, 23);
		getContentPane().add(btnLimparCampos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		btnVoltar.setBounds(369, 259, 123, 23);
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
