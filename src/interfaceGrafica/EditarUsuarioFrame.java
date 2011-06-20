package interfaceGrafica;
import java.awt.Color;
import javax.swing.*;

import banco.Banco;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import objetos.Administrador;
import objetos.Usuario;

public class EditarUsuarioFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	
	public EditarUsuarioFrame(final Usuario usrLogado) {
		usuarioLogado = usrLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		JLabel lblDigiteONumero = new JLabel("Digite o numero do registro de usuario que deseja alterar:");
		lblDigiteONumero.setBounds(23, 85, 483, 14);
		getContentPane().add(lblDigiteONumero);
		
		textField = new JTextField();
		textField.setBounds(387, 82, 53, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		String[] options = {"", "Admin", "Usuario"};   
		comboBox = new JComboBox(options);
		comboBox.setSelectedIndex(0); 
		comboBox.setBackground(Color.white);
		//comboBox.addActionListener();  
		comboBox.setBounds(97, 189, 104, 20);
		getContentPane().add(comboBox);
		
		final JLabel lblNewLabel_2 = new JLabel("");//vazio por enquanto
		lblNewLabel_2.setBounds(23, 50, 298, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				comboBox.setSelectedIndex(0);
				textField_2.setText("");
				textField.setText("");
			}
		});
		btnLimparCampos.setBounds(209, 259, 123, 23);
		getContentPane().add(btnLimparCampos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(364, 259, 123, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnVoltar);
		
		JButton btnAdicionar = new JButton("Alterar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_1.getText().equals("") || textField_2.getText().equals("") ){
					lblNewLabel_2.setOpaque(false);
					lblNewLabel_2.setForeground(Color.red);
					lblNewLabel_2.setText("Por favor, preencher todos os campos.");
				}
				else {	
					boolean alterou = false;
					lblNewLabel_2.setText("");
					try{
						
						// 0: usuario, 1: nome, 2: ehadmin, 3: senha
						int registro = Integer.parseInt(textField.getText());
						Usuario usuarioAAlterar = Banco.obterUsuario(registro);
						lblNewLabel_2.setOpaque(false);
						lblNewLabel_2.setForeground(Color.red);
						ArrayList<Object> arrayListDeUsuario = new ArrayList<Object>();
						arrayListDeUsuario.add(usuarioAAlterar);
						int option = comboBox.getSelectedIndex();
						String nome = textField_1.getText();
						String senha = textField_2.getText();
						String permissao = (String)comboBox.getSelectedItem();
						boolean permissaoUsuario = false;
						if (permissao.equals("Admin")) permissaoUsuario = true;
						arrayListDeUsuario.add(nome);
						arrayListDeUsuario.add(permissaoUsuario);
						arrayListDeUsuario.add(senha);
						//System.out.println (nome + " " + permissao + " " + senha);
						alterou = admin.alterarUsuario(arrayListDeUsuario);
					
					} catch (Exception e){
						System.out.println(e);
					}
					if (alterou){
						lblNewLabel_2.setText("Usuario alterado com sucesso.");
						textField_1.setText("");
						comboBox.setSelectedIndex(0);
						textField_2.setText("");
						textField.setText("");
						
					}
					else
						lblNewLabel_2.setText("Usuario nao encontrado.");
						textField.setText("");
				}
			}
		});
		btnAdicionar.setBounds(52, 259, 123, 23);
		getContentPane().add(btnAdicionar);
		
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setOpaque(false);
				lblNewLabel_2.setForeground(Color.red);
				if (textField.getText().equals("")){
					lblNewLabel_2.setText("Digite o numero de registro do usuário.");
				}
				else{
					boolean alterou = false;
					lblNewLabel_2.setText("");
					try{
						int registro = Integer.parseInt(textField.getText());
						Usuario usuarioAAlterar = Banco.obterUsuario(registro);
					
						if (usuarioAAlterar == null){
							lblNewLabel_2.setText("Usuario nao encontrado.");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
						}
						else {
							textField_1.setText(usuarioAAlterar.getNome());
							textField_2.setText(usuarioAAlterar.getSenha());
							if (usuarioAAlterar.isEhAdministrador())
								comboBox.setSelectedIndex(1);
							else 
								comboBox.setSelectedIndex(2);
						}
					} catch (Exception e){
						System.out.println(e);
					}
				}
			}
		});
		btnNewButton.setBounds(448, 81, 58, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblAlltereOsCamoos = new JLabel("Altere os campos desejados:");
		lblAlltereOsCamoos.setBounds(23, 119, 239, 14);
		getContentPane().add(lblAlltereOsCamoos);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(23, 167, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel label = new JLabel("Permissao:");
		label.setBounds(23, 192, 89, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Senha:");
		label_1.setBounds(23, 217, 78, 14);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 164, 361, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 214, 361, 20);
		getContentPane().add(textField_2);
		
		
		
		
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
