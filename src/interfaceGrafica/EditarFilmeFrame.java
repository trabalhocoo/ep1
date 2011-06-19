package interfaceGrafica;
import javax.swing.*;
import banco.Banco;
import objetos.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;

//arrumar
public class EditarFilmeFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField nomeDoFilme;
	private JTextField duracao;
	private JTextField genero;
	private JTextField sinopse;
	private JTextField dataDaEstreia;
	private JTextField diretor;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JCheckBox checkBox;
	
	public EditarFilmeFrame(final Usuario usrLogado){
		usuarioLogado = usrLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		JLabel lblDigiteONumero = new JLabel("Escolha o filme que deseja alterar:");
		lblDigiteONumero.setBounds(23, 50, 212, 14);
		getContentPane().add(lblDigiteONumero);
		
		String[] options = {"", "Admin", "Usuario"};
		
		final JLabel lblNewLabel_2 = new JLabel("");//vazio por enquanto
		lblNewLabel_2.setBounds(23, 30, 298, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeDoFilme.setText("");
				duracao.setText("");
				genero.setText("");
				sinopse.setText("");
				dataDaEstreia.setText("");
				diretor.setText("");
				comboBox.setSelectedIndex(0);
				checkBox.setSelected(false);
			}
		});
		btnLimparCampos.setBounds(208, 293, 123, 23);
		getContentPane().add(btnLimparCampos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(363, 293, 123, 23);
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
				boolean alterou = false;
				if(nomeDoFilme.getText().equals("")|| comboBox.getSelectedIndex()==0 || duracao.getText().equals("")||diretor.getText().equals("") || sinopse.getText().equals("") || genero.getText().equals("") || dataDaEstreia.getText().equals("")){
					lblNewLabel_2.setOpaque(false);
					lblNewLabel_2.setForeground(Color.red);
					lblNewLabel_2.setText("Por favor, digite todos os campos.");
				}
				else {
					lblNewLabel_2.setText("");
					String antigoNome = "";
					try{
						ArrayList<Object> arrayListDeFilme = new ArrayList<Object>();
						/*
						String nomeDoFilme = (String) dadosFilme.get(0);
						Filme filmeAAlterar = Banco.obterFilme(nomeDoFilme);

						String novoNome = (String) dadosFilme.get(1);
						int faixaEtaria = (Integer) dadosFilme.get(2);
						int duracao = (Integer) dadosFilme.get(3);
						String diretor = (String) dadosFilme.get(4);
						String sinopse = (String) dadosFilme.get(5);
						String genero = (String) dadosFilme.get(6);
						String estreia = (String) dadosFilme.get(7);
						boolean is3d = (Boolean) dadosFilme.get(8);
						*/
						antigoNome = (String)comboBox_1.getSelectedItem();
						arrayListDeFilme.add(antigoNome);
						arrayListDeFilme.add(nomeDoFilme.getText());
						int faixa;
						if (comboBox.getSelectedIndex() == 1)
							faixa = 0;
						else 
							faixa = Integer.parseInt((String) comboBox.getSelectedItem());
						arrayListDeFilme.add(faixa);
						int temp2 = Integer.parseInt(duracao.getText());
						arrayListDeFilme.add(temp2);
						arrayListDeFilme.add(diretor.getText());
						arrayListDeFilme.add(sinopse.getText());
						arrayListDeFilme.add(genero.getText());
						arrayListDeFilme.add(dataDaEstreia.getText());
						arrayListDeFilme.add(checkBox.isSelected());
						alterou = admin.alterarFilme(arrayListDeFilme);
					
					} catch (Exception e){
						System.out.println(e);
					}
					
					lblNewLabel_2.setOpaque(false);
					lblNewLabel_2.setForeground(Color.red);
					if (alterou){
						lblNewLabel_2.setText("O filme " + antigoNome + " foi alterado com sucesso.");
						nomeDoFilme.setText("");
						duracao.setText("");
						genero.setText("");
						sinopse.setText("");
						dataDaEstreia.setText("");
						diretor.setText("");
						comboBox.setSelectedIndex(0);
						checkBox.setSelected(false);
						comboBox_1.setSelectedIndex(0);
						EditarFilmeFrame edFr = new EditarFilmeFrame(usrLogado);
						edFr.showIt("Editar frame");
						dispose();
						
						
					}
					else {
						lblNewLabel_2.setText("Ocorreu um problema, tente novamente.");
						nomeDoFilme.setText("");
						duracao.setText("");
						genero.setText("");
						sinopse.setText("");
						dataDaEstreia.setText("");
						diretor.setText("");
						comboBox.setSelectedIndex(0);
						comboBox_1.setSelectedIndex(0);
						checkBox.setSelected(false);
						
					}
						
						
					
				}
			}
		});
		btnAdicionar.setBounds(51, 293, 123, 23);
		getContentPane().add(btnAdicionar);
		
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println (comboBox_1.getSelectedIndex());
				if (comboBox_1.getSelectedIndex()==0){
					lblNewLabel_2.setOpaque(false);
					lblNewLabel_2.setForeground(Color.red);
					lblNewLabel_2.setText("Por favor, selecione um filme.");
				}
				else {
					try{
						lblNewLabel_2.setText("");
						Filme filmeAAlterar = Banco.obterFilme((String) comboBox_1.getSelectedItem());
						nomeDoFilme.setText(filmeAAlterar.getNome());
						Integer temp = filmeAAlterar.getDuracao();
						duracao.setText(temp.toString());
						genero.setText(filmeAAlterar.getGenero());
						int temp2 = filmeAAlterar.getFaixaEtaria();
						//System.out.println ("Faixa: "+ temp2);
						//"","Livre", "12", "14", "16", "18", "30"
						if (temp2 == 0)
							comboBox.setSelectedIndex(1);
						else if (temp2 == 12)
							comboBox.setSelectedIndex(2);
						else if (temp2 == 14)
							comboBox.setSelectedIndex(3);
						else if (temp2 == 16)
							comboBox.setSelectedIndex(4);
						else if (temp2 == 30)
							comboBox.setSelectedIndex(5);
						else 
							comboBox.setSelectedIndex(0);
						sinopse.setText(filmeAAlterar.getSinopse());
						dataDaEstreia.setText(filmeAAlterar.getDataDeEstreia());
						diretor.setText(filmeAAlterar.getDiretor());
						checkBox.setSelected(filmeAAlterar.isIs3d());
						
					} catch (Exception e){
						System.out.println(e);
					}
				}
			}
		});
		btnNewButton.setBounds(448, 46, 58, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblAlltereOsCamoos = new JLabel("Altere os campos desejados:");
		lblAlltereOsCamoos.setBounds(23, 81, 239, 14);
		getContentPane().add(lblAlltereOsCamoos);
		
		JLabel label = new JLabel("Nome do filme:");
		label.setBounds(23, 111, 102, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Duracao (em min):");
		label_1.setBounds(23, 140, 126, 14);
		getContentPane().add(label_1);
		
		nomeDoFilme = new JTextField();
		nomeDoFilme.setColumns(10);
		nomeDoFilme.setBounds(135, 106, 114, 20);
		getContentPane().add(nomeDoFilme);
		
		duracao = new JTextField();
		duracao.setColumns(10);
		duracao.setBounds(135, 135, 114, 20);
		getContentPane().add(duracao);
		
		JLabel label_2 = new JLabel("Genero:");
		label_2.setBounds(23, 168, 102, 14);
		getContentPane().add(label_2);
		
		genero = new JTextField();
		genero.setColumns(10);
		genero.setBounds(135, 165, 114, 20);
		getContentPane().add(genero);
		
		JLabel label_3 = new JLabel("Faixa Etaria:");
		label_3.setBounds(23, 193, 126, 14);
		getContentPane().add(label_3);
		
		String[] options2 = {"","Livre", "12", "14", "16", "18", "30"};
		comboBox = new JComboBox(options2);
		comboBox.setSelectedIndex(0);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(136, 196, 113, 20);
		getContentPane().add(comboBox);
		
		JLabel label_4 = new JLabel("Sinopse:");
		label_4.setBounds(23, 232, 102, 14);
		getContentPane().add(label_4);
		
		sinopse = new JTextField();
		sinopse.setColumns(10);
		sinopse.setBounds(135, 232, 371, 50);
		getContentPane().add(sinopse);
		
		JLabel label_5 = new JLabel("Data da estreia :");
		label_5.setBounds(280, 111, 102, 14);
		getContentPane().add(label_5);
		
		dataDaEstreia = new JTextField();
		dataDaEstreia.setColumns(10);
		dataDaEstreia.setBounds(392, 108, 114, 20);
		getContentPane().add(dataDaEstreia);
		
		JLabel label_6 = new JLabel("Diretor:");
		label_6.setBounds(280, 140, 102, 14);
		getContentPane().add(label_6);
		
		diretor = new JTextField();
		diretor.setColumns(10);
		diretor.setBounds(392, 137, 114, 20);
		getContentPane().add(diretor);
		
		checkBox = new JCheckBox("3D");
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(280, 164, 97, 23);
		getContentPane().add(checkBox);
		
		//guardar o arraylist de nomes de filme
		ArrayList<Filme> listaFilmes = Banco.getFilmes();
		String[] options3 = new String [listaFilmes.size()+1];
		options3[0]="";
		for (int i = 0; i<listaFilmes.size(); i++){
			options3[i+1]=listaFilmes.get(i).getNome();
		}
		//String[] options3 = {"","Livre", "12", "14", "16", "18", "30"};
		comboBox_1 = new JComboBox(options3);
		comboBox_1.setBounds(226, 50, 201, 20);
		getContentPane().add(comboBox_1);
		
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
