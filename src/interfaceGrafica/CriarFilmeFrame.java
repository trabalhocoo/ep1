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
	private JTextArea textSinopse;
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
		btnVoltar.setBounds(369, 293, 123, 23);
		getContentPane().add(btnVoltar);
		
		//String nome, int faixa, int duracao, String diretor, String sinopse, String genero, String estreia, boolean is3d
		//label
		JLabel lblPorFavorPreencha = new JLabel("Por favor preencha as informacoes abaixo sobre o filme que deseja criar:");
		lblPorFavorPreencha.setBounds(40, 39, 433, 14);
		getContentPane().add(lblPorFavorPreencha);
		
		//label nome do filme
		JLabel lblNomeDoFilme = new JLabel("Nome do filme:");
		lblNomeDoFilme.setBounds(40, 92, 102, 14);
		getContentPane().add(lblNomeDoFilme);
		
		//label faixa
		JLabel lblFaixa = new JLabel("Faixa Etaria:");
		lblFaixa.setBounds(40, 186, 126, 14);
		getContentPane().add(lblFaixa);
		
		//label duracao
		JLabel lblDuracao = new JLabel("Duracao (em min):");
		lblDuracao.setBounds(40, 124, 126, 14);
		getContentPane().add(lblDuracao);
		
		//label diretor 
		JLabel lblDiretor = new JLabel("Diretor:");
		lblDiretor.setBounds(289, 124, 102, 14);
		getContentPane().add(lblDiretor);
		
		//label sinopse
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setBounds(40, 219, 102, 14);
		getContentPane().add(lblSinopse);
		
		//label genero
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(40, 154, 102, 14);
		getContentPane().add(lblGenero);
		
		//label estreia
		JLabel lblEstreia = new JLabel("Data da estreia :");
		lblEstreia.setBounds(289, 92, 102, 14);
		getContentPane().add(lblEstreia);
		
		//box para dizer se a sala eh 3D
		final JCheckBox chckbxSalad = new JCheckBox("3D");
		chckbxSalad.setBounds(289, 150, 97, 23);
		chckbxSalad.setBackground(Color.white);
		getContentPane().add(chckbxSalad);
		
		//campo para preenchimento do nome do Filme
		textNomeDoFilme = new JTextField();
		textNomeDoFilme.setBounds(165, 88, 114, 23);
		getContentPane().add(textNomeDoFilme);
		textNomeDoFilme.setColumns(10);
		
		String[] options = {"","Livre", "12", "14", "16", "18", "30"};   
		comboFaixa = new JComboBox(options);
		comboFaixa.setSelectedIndex(0); 
		comboFaixa.setBackground(Color.white);
		comboFaixa.setBounds(165, 183, 113, 20);
		getContentPane().add(comboFaixa);
		
		//campo para preenchimento da duracao
		textDuracao = new JTextField();
		textDuracao.setBounds(165, 121, 114, 20);
		getContentPane().add(textDuracao);
		textDuracao.setColumns(10);
		
		//campo para preenchimento do diretor
		textDiretor = new JTextField();
		textDiretor.setBounds(384, 121, 114, 20);
		getContentPane().add(textDiretor);
		textDiretor.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(165, 219, 333, 50);
		getContentPane().add(scrollPane);
		
		//campo para preenchimento da sinopse
		textSinopse = new JTextArea();
		scrollPane.setViewportView(textSinopse);
		textSinopse.setRows(3);
		textSinopse.setColumns(10);
		
		//campo para preenchimento do genero
		textGenero = new JTextField();
		textGenero.setBounds(165, 149, 114, 20);
		getContentPane().add(textGenero);
		textGenero.setColumns(10);
		
		//campo para preenchimento da estreia
		textEstreia = new JTextField("dd/mm/aaaa");
		textEstreia.setBounds(384, 89, 114, 20);
		textEstreia.setForeground(Color.gray);
		getContentPane().add(textEstreia);
		textEstreia.setColumns(10);
		
		final JLabel lblNewLabel_1 = new JLabel("");//vazio por enquanto
		lblNewLabel_1.setBounds(40, 64, 458, 14);
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
				textEstreia.setText("dd/mm/aaaa");
				textEstreia.setForeground(Color.gray);
			}
		});
		btnLimparCampos.setBounds(209, 293, 123, 23);
		getContentPane().add(btnLimparCampos);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(52, 293, 123, 23);
		//276, 293
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textNomeDoFilme.getText().equals("") || comboFaixa.getSelectedIndex()==0 || textDuracao.getText().equals("")||textDiretor.getText().equals("") || textSinopse.getText().equals("") || textGenero.getText().equals("") || textEstreia.getText().equals("dd/mm/aaaa") ){
					lblNewLabel_1.setOpaque(false);
					lblNewLabel_1.setForeground(Color.red);
					lblNewLabel_1.setText("Por favor, digite todos os campos.");
				}
				else {
					try{
						String nome = textNomeDoFilme.getText();
						int faixa;
						if (comboFaixa.getSelectedIndex() == 1)
							faixa = 0;
						else 
							faixa = Integer.parseInt((String) comboFaixa.getSelectedItem());
						//System.out.println ("Faixa: " + faixa);
						int duracao = Integer.parseInt(textDuracao.getText());
						String diretor = textDiretor.getText();
						String sinopse = textSinopse.getText();
						String genero = textGenero.getText();
						String estreia = textEstreia.getText();
						boolean eh3D = chckbxSalad.isSelected();
					    

						ArrayList dadosFilme = new ArrayList();
						dadosFilme.add(nome);
						dadosFilme.add(faixa);
						dadosFilme.add(duracao);
						dadosFilme.add(diretor);
						dadosFilme.add(sinopse);
						dadosFilme.add(genero);
						dadosFilme.add(estreia);
						dadosFilme.add(eh3D);
						// String nome, int faixa, Date duracao, String diretor, String sinopse,
						// String genero, String estreia, boolean is3d
						admin.adicionarFilme(usuarioLogado, dadosFilme);
						lblNewLabel_1.setOpaque(false);
						lblNewLabel_1.setForeground(Color.red);
						lblNewLabel_1.setText("Filme " + nome + " criado com sucesso."); 
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
				catch (NumberFormatException e) {
					System.out.println(e);
					lblNewLabel_1.setOpaque(false);
					lblNewLabel_1.setForeground(Color.red);
					lblNewLabel_1.setText("Por favor, digite valores v�lidos para os campos."); 	
				}
				catch (Exception e){
					System.out.print(e);
					
				}
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
