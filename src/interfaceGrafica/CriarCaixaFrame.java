package interfaceGrafica;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import objetos.*;

public class CriarCaixaFrame extends JFrame{
	private static Usuario usuarioLogado;
	
	public CriarCaixaFrame(final Usuario usr) {
		usuarioLogado = usr;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		//label de aviso
		final JLabel lblNewLabel_2 = new JLabel("");//vazio por enquanto
		lblNewLabel_2.setBounds(23, 50, 298, 14);
		getContentPane().add(lblNewLabel_2);
		
		
		//Botao voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		btnVoltar.setBounds(355, 264, 123, 23);
		getContentPane().add(btnVoltar);
		
		
		//label numero da sala
		JLabel lblNumeroDaSala = new JLabel("Numero do caixa:");
		lblNumeroDaSala.setBounds(41, 121, 102, 14);
		getContentPane().add(lblNumeroDaSala);
		
		
		//label do numero do caixa
		Integer numeroDeCaixasCriados = Caixa.getNumeroDeCaixasCriadas(); 
		JLabel numeroDoCaixa = new JLabel(numeroDeCaixasCriados.toString());
		numeroDoCaixa.setBounds(167, 121, 46, 14);
		getContentPane().add(numeroDoCaixa);
		
		JButton criarSalaBtn = new JButton("Criar caixa");
		criarSalaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean criou = admin.adicionarCaixa();
				lblNewLabel_2.setOpaque(false);
				lblNewLabel_2.setForeground(Color.red);
				if (criou){
					Integer numeroDeCaixasCriados = Caixa.getNumeroDeCaixasCriadas() -1;
					lblNewLabel_2.setText("Caixa " + numeroDeCaixasCriados.toString() + " criado com sucesso.");
				}
				else{
					lblNewLabel_2.setText("Ocorreu um problema. Tente novamente");
				}
					
			}
		});
		criarSalaBtn.setBounds(240, 117, 102, 23);
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
