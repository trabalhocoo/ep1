package interfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import objetos.Administrador;
import objetos.Filme;
import objetos.Sala;
import objetos.Usuario;
import visualizacao.Exibir;

public class CriarSessaoFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField textNomeDoFilme;
	private JTextField textSala;
	private JTextField textDisponibilidade;
	private JComboBox comboBox;
	
	public CriarSessaoFrame(final Usuario usuarioLogado) {
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
		
		//Filme filme, int year, int month, int date, int hourOfDay, int minute, Sala sala, double preco, int disp
		
		JLabel lblPorFavorPreencha = new JLabel("Por favor preencha as informacoes abaixo sobre a sessao que deseja criar:");
		lblPorFavorPreencha.setBounds(55, 39, 433, 14);
		getContentPane().add(lblPorFavorPreencha);
		
		//label nome do filme
		JLabel lblNomeDoFilme = new JLabel("Nome do filme:");
		lblNomeDoFilme.setBounds(55, 92, 102, 14);
		getContentPane().add(lblNomeDoFilme);
		
		//label sala 
		JLabel lblSala = new JLabel("Numero da Sala:");
		lblSala.setBounds(304, 92, 102, 14);
		getContentPane().add(lblSala);
		
		//label preco
		JLabel lblPreco = new JLabel("Preco:");
		lblPreco.setBounds(55, 170, 102, 14);
		getContentPane().add(lblPreco);
		
		//label dispo
		JLabel lblDispo = new JLabel("Disponibilidade de lugares:");
		lblDispo.setBounds(55, 134, 145, 14);
		getContentPane().add(lblDispo);
		
		//Arrumar os campos ano, mes, dia para podermos usar em um campo só e o mesmo para o campo hora e minutos
		
		//campo para preenchimento do nome do Filme //sem comboBox
		/*ArrayList <Filme> filmesCriados;
		for(Filme filme : arrayListDeFilme){
			filmesCriados 
		}
		String[] options = filmesCriados;   
		comboBox = new JComboBox(options);
		comboBox.setSelectedIndex(0); 
		comboBox.setBackground(Color.white);
		//comboBox.addActionListener();  
		comboBox.setBounds(202, 89, 94, 20);
		getContentPane().add(comboBox);
		*/
		//campo para preenchimento da duracao
		textSala = new JTextField();
		textSala.setBounds(200, 131, 96, 20);
		getContentPane().add(textSala);
		textSala.setColumns(10);
		
		//campo para preenchimento da sinopse
		textDisponibilidade = new JTextField();
		textDisponibilidade.setBounds(400, 89, 114, 20);
		getContentPane().add(textDisponibilidade);
		textDisponibilidade.setColumns(10);
		
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
