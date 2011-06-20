package interfaceGrafica;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.Banco;

import objetos.Administrador;
import objetos.Sessao;
import objetos.Usuario;

public class RemoverSessaoFrame extends JFrame {
	private static Usuario usuarioLogado;
	private JTextField codSessao;
	
	public RemoverSessaoFrame() {
		this.usuarioLogado = usuarioLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		final JLabel lblErro = new JLabel("");// vazio por enquanto
		lblErro.setBounds(33, 60, 298, 14);
		getContentPane().add(lblErro);
		
		JLabel lblDigiteONumero = new JLabel("Escolha o numero sessao que deseja remover:");
		lblDigiteONumero.setBounds(22, 38, 253, 14);
		getContentPane().add(lblDigiteONumero);
		
		//campo para preencher o numero da sessao
		codSessao = new JTextField();
		codSessao.setBounds(274, 35, 86, 20);
		getContentPane().add(codSessao);
		codSessao.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int registro = Integer.parseInt(codSessao.getText());
				lblErro.setOpaque(false);
				lblErro.setForeground(Color.red);
				if(codSessao.getText().equals("")){
					lblErro.setText("Por favor informar a sessao que deseja remover.");
				}
				else {
					int numeroDaSessao = Integer.parseInt(codSessao.getText());
					boolean removeu = admin.removerSessao(admin);
					if (removeu){
						lblErro.setText("Sessao Removida com sucesso");
					}
					else
						lblErro.setText("Sessao não encontrada");
				}
			}
		});
		btnOK.setBounds(416, 34, 89, 23);
		getContentPane().add(btnOK);
		
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
