package interfaceGrafica;
import javax.swing.*;

import banco.Banco;

import objetos.Administrador;
import objetos.Sessao;
import objetos.Usuario;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.TreeSet;

public class RemoverSalaFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField codSala;
	
	public RemoverSalaFrame (final Usuario usuarioLogado){
		this.usuarioLogado = usuarioLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		JLabel lblDigiteONumero = new JLabel("Digite o numero da sala que deseja remover:");
		lblDigiteONumero.setBounds(23, 85, 483, 14);
		getContentPane().add(lblDigiteONumero);
		
		codSala = new JTextField();
		codSala.setBounds(294, 82, 53, 20);
		getContentPane().add(codSala);
		codSala.setColumns(10);
		
		final JLabel lblNewLabel_2 = new JLabel("");//vazio por enquanto
		lblNewLabel_2.setBounds(23, 50, 453, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setOpaque(false);
				lblNewLabel_2.setForeground(Color.red);
				int registro = Integer.parseInt(codSala.getText());
				boolean podeRemover = true;
				TreeSet<Sessao> sessoesDoBanco = Banco.getSessoes();
				for (Sessao sessao: sessoesDoBanco){
					if (sessao.getSala().getNumero() == registro && sessao.getHorarioDeInicio().getTime().after(new Date())){
						podeRemover = false;
						break;
					}
				}
				if(podeRemover == false){
					lblNewLabel_2.setText("Sala não pode ser removida pois está sendo usada em uma sessao.");
				}
				else {
					boolean removeu = admin.removerSala(registro);
					if (removeu){
						lblNewLabel_2.setText("Sala removida com sucesso.");
					}
					else
						lblNewLabel_2.setText("Sala nao encontrada.");
				}
			}
		});
		btnNewButton.setBounds(357, 81, 58, 23);
		getContentPane().add(btnNewButton);
		
		
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

