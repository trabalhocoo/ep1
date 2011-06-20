package interfaceGrafica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import objetos.*;

public class CriarSalaFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField textnumeroDaSala;
	private JTextField textcapacidade;
	
	
	public CriarSalaFrame(final Usuario usr) {
		usuarioLogado = usr;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		// int capacidade, int numero, boolean is3d
		//label
		JLabel lblPorFavorPreencha = new JLabel("Por favor preencha as informacoes abaixo sobre a sala que deseja criar:");
		lblPorFavorPreencha.setBounds(55, 81, 421, 14);
		getContentPane().add(lblPorFavorPreencha);
		
		//Botao voltar
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
		
		
		//label numero da sala
		JLabel lblNumeroDaSala = new JLabel("Numero da sala:");
		lblNumeroDaSala.setBounds(55, 121, 102, 14);
		getContentPane().add(lblNumeroDaSala);
		
		//label capacidade
		JLabel lblcapacidade = new JLabel("Capacidade");
		lblcapacidade.setBounds(55, 152, 102, 14);
		getContentPane().add(lblcapacidade);
		
		final JLabel avisoLabel = new JLabel("");//vazio por enquanto
		avisoLabel.setBounds(55, 60, 458, 14);
		getContentPane().add(avisoLabel);
		
		//campo para preenchimento do numero da sala
		textnumeroDaSala = new JTextField();
		textnumeroDaSala.setBounds(178, 118, 86, 20);
		getContentPane().add(textnumeroDaSala);
		textnumeroDaSala.setColumns(10);
		
		//campo para preenchimento da capacidade da sala
		textcapacidade = new JTextField();
		textcapacidade.setBounds(178, 149, 86, 20);
		getContentPane().add(textcapacidade);
		textcapacidade.setColumns(10);
		
		//box para dizer se a sala eh 3D
		final JCheckBox chckbxSalad = new JCheckBox("Sala 3D");
		chckbxSalad.setBounds(49, 183, 97, 23);
		chckbxSalad.setBackground(Color.white);
		getContentPane().add(chckbxSalad);
		
		//Botao para limpar campos
		JButton btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textcapacidade.setText("");
				boolean b = false;
				chckbxSalad.setSelected(b);
				textnumeroDaSala.setText("");
			}
		});
		btnLimparCampos.setBounds(216, 259, 123, 23);
		getContentPane().add(btnLimparCampos);
		
		JButton criarSalaBtn = new JButton("Criar sala");
		criarSalaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				avisoLabel.setOpaque(false);
				avisoLabel.setForeground(Color.red);
				if (textcapacidade.getText().equals("") || textnumeroDaSala.getText().equals("") ){
					avisoLabel.setText("Por favor, preencha todos os campos.");
				}
				else {
					int capacidade = Integer.parseInt(textcapacidade.getText());
					int numeroSala = Integer.parseInt(textnumeroDaSala.getText());
					boolean tres_d = chckbxSalad.isSelected();
					ArrayList<Object> sala = new ArrayList<Object>();
					sala.add(capacidade);
					sala.add(numeroSala);
					sala.add(tres_d);
					admin.adicionarSala(sala);
					avisoLabel.setText("Sala criada com sucesso.");
				}
			}
		});
		criarSalaBtn.setBounds(55, 259, 123, 23);
		getContentPane().add(criarSalaBtn);
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
