package interfaceGrafica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import objetos.*;

public class CriarFilmeFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField textNomeDoFilme;
	private JComboBox comboFaixa;
	private JTextField textDuracao;
	private JTextField textDiretor;
	private JTextField textSinopse;
	private JTextField textGenero;
	private JTextField textEstreia;
	
	
	public CriarFilmeFrame(final Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		//Botao voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		btnVoltar.setBounds(424, 293, 89, 23);
		getContentPane().add(btnVoltar);
		
		//String nome, int faixa, int duracao, String diretor, String sinopse, String genero, String estreia, boolean is3d
		//label
		JLabel lblPorFavorPreencha = new JLabel("Por favor preencha as informacoes abaixo sobre o filme que deseja criar:");
		lblPorFavorPreencha.setBounds(55, 39, 433, 14);
		getContentPane().add(lblPorFavorPreencha);
		
		//label nome do filme
		JLabel lblNomeDoFilme = new JLabel("Nome do filme:");
		lblNomeDoFilme.setBounds(55, 92, 102, 14);
		getContentPane().add(lblNomeDoFilme);
		
		//label faixa
		JLabel lblFaixa = new JLabel("Faixa Etaria:");
		lblFaixa.setBounds(52, 124, 126, 14);
		getContentPane().add(lblFaixa);
		
		//label duracao
		JLabel lblDuracao = new JLabel("Duracao (em minutos):");
		lblDuracao.setBounds(52, 124, 126, 14);
		getContentPane().add(lblDuracao);
		
		//label diretor 
		JLabel lblDiretor = new JLabel("Diretor:");
		lblDiretor.setBounds(307, 124, 102, 14);
		getContentPane().add(lblDiretor);
		
		//label sinopse
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setBounds(55, 192, 102, 14);
		getContentPane().add(lblSinopse);
		
		//label genero
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(55, 154, 102, 14);
		getContentPane().add(lblGenero);
		
		//label estreia
		JLabel lblEstreia = new JLabel("Data da estreia :");
		lblEstreia.setBounds(307, 92, 102, 14);
		getContentPane().add(lblEstreia);
		
		//box para dizer se a sala eh 3D
		final JCheckBox chckbxSalad = new JCheckBox("3D");
		chckbxSalad.setBounds(307, 150, 97, 23);
		chckbxSalad.setBackground(Color.white);
		getContentPane().add(chckbxSalad);
		
		//campo para preenchimento do nome do Filme
		textNomeDoFilme = new JTextField();
		textNomeDoFilme.setBounds(180, 192, 116, 85);
		getContentPane().add(textNomeDoFilme);
		textNomeDoFilme.setColumns(10);
		
		String[] options = {"","Livre", "12", "14", "16", "18", "30"};   
		comboFaixa = new JComboBox(options);
		comboFaixa.setSelectedIndex(0); 
		comboFaixa.setBackground(Color.white);
		comboFaixa.setBounds(163, 144, 104, 20);
		getContentPane().add(comboFaixa);
		
		//campo para preenchimento da duracao
		textDuracao = new JTextField();
		textDuracao.setBounds(179, 89, 114, 20);
		getContentPane().add(textDuracao);
		textDuracao.setColumns(10);
		
		//campo para preenchimento do diretor
		textDiretor = new JTextField();
		textDiretor.setBounds(399, 121, 114, 20);
		getContentPane().add(textDiretor);
		textDiretor.setColumns(10);
		
		//campo para preenchimento da sinopse
		textSinopse = new JTextField();
		textSinopse.setBounds(402, 89, 114, 20);
		getContentPane().add(textSinopse);
		textSinopse.setColumns(10);
		
		//campo para preenchimento do genero
		textGenero = new JTextField();
		textGenero.setBounds(178, 118, 114, 20);
		getContentPane().add(textGenero);
		textGenero.setColumns(10);
		
		//campo para preenchimento da estreia
		textEstreia = new JTextField();
		textEstreia.setBounds(178, 149, 114, 20);
		getContentPane().add(textEstreia);
		textEstreia.setColumns(10);
		
		final JLabel lblNewLabel_1 = new JLabel("");//vazio por enquanto
		lblNewLabel_1.setBounds(40, 172, 200, 14);
		getContentPane().add(lblNewLabel_1);
		
		//Botao para limpar campos
		JButton btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNomeDoFilme.setText("");
				comboFaixa.setSelectedIndex(0);
				boolean b = false;
				chckbxSalad.setSelected(b);
				textDuracao.setText("");
				textDiretor.setText("");
				textSinopse.setText("");
				textGenero.setText("");
				textEstreia.setText("");
			}
		});
		btnLimparCampos.setBounds(276, 293, 123, 23);
		getContentPane().add(btnLimparCampos);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(55, 293, 123, 23);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String nome = textNomeDoFilme.getText();
					int faixa = comboFaixa.getSelectedIndex();
					int duracao = Integer.parseInt(textDuracao.getText());
					String diretor = textDiretor.getText();
					String sinopse = textSinopse.getText();
					String genero = textGenero.getText();
					String estreia = textEstreia.getText();

					ArrayList dadosFilme = new ArrayList();
					dadosFilme.add(nome);
					
					if(nome.equals("")){
						lblNewLabel_1.setOpaque(false);
						lblNewLabel_1.setForeground(Color.red);
						lblNewLabel_1.setText("Por favor, digite todos os campos.");
					}
					else {
						// String nome, int faixa, Date duracao, String diretor, String sinopse,
						// String genero, String estreia, boolean is3d
						dadosFilme.add(duracao);
						admin.adicionarFilme(dadosFilme);
						lblNewLabel_1.setOpaque(false);
						lblNewLabel_1.setForeground(Color.red);
						lblNewLabel_1.setText("Filme criado com sucesso. Filme: " + nome); 
						textNomeDoFilme.setText("");
						chckbxSalad.setSelected(false);
					}
				}
				catch (Exception e){
					System.out.print(e);
				}
				
			}
		});
		getContentPane().add(btnAdicionar);
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
