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

import banco.Banco;

import objetos.Administrador;
import objetos.Filme;
import objetos.Sala;
import objetos.Usuario;
import visualizacao.Exibir;

public class CriarSessaoFrame extends JFrame {
	private static Usuario usuarioLogado;
	private JTextField textNomeDoFilme;
	private JComboBox comboBox;
	private JComboBox comboSala;
	private JLabel disponibilidade;
	private JTextField precoField;

	public CriarSessaoFrame(final Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		final Administrador admin = (Administrador) usuarioLogado;
		this.setSize(550, 380);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); // mudar a cor

		// Botao voltar
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

		// Filme filme, int year, int month, int date, int hourOfDay, int
		// minute, Sala sala, double preco, int disp

		JLabel lblPorFavorPreencha = new JLabel(
				"Por favor preencha as informacoes abaixo sobre a sessao que deseja criar:");
		lblPorFavorPreencha.setBounds(55, 39, 433, 14);
		getContentPane().add(lblPorFavorPreencha);

		// label nome do filme
		JLabel lblNomeDoFilme = new JLabel("Nome do filme:");
		lblNomeDoFilme.setBounds(55, 92, 102, 14);
		getContentPane().add(lblNomeDoFilme);

		// label sala
		JLabel lblSala = new JLabel("Numero da Sala:");
		lblSala.setBounds(304, 92, 102, 14);
		getContentPane().add(lblSala);

		// label preco
		JLabel lblPreco = new JLabel("Preco:");
		lblPreco.setBounds(55, 170, 51, 14);
		getContentPane().add(lblPreco);

		// label dispo
		JLabel lblDispo = new JLabel("Disponibilidade de lugares:");
		lblDispo.setBounds(55, 134, 145, 14);
		getContentPane().add(lblDispo);

		// Arrumar os campos ano, mes, dia para podermos usar em um campo s� e o
		// mesmo para o campo hora e minutos

		// campo para preenchimento do nome do Filme //sem comboBox

		String[][] dadosFilmes = Exibir.exibirFilmesTabela(Banco.getFilmes());
		String[] optionsFilmes = new String[dadosFilmes.length + 1];

		optionsFilmes[0] = "";
		if (Banco.getFilmes() != null) {
			for (int i = 0; i < dadosFilmes.length; i++) {
				optionsFilmes[i + 1] = dadosFilmes[i][0];
			}
			comboBox = new JComboBox(optionsFilmes);
			comboBox.setSelectedIndex(0);
		} else {
			comboBox = new JComboBox();
		}

		comboBox.setBackground(Color.white);
		// comboBox.addActionListener();
		comboBox.setBounds(202, 89, 94, 20);
		getContentPane().add(comboBox);

		disponibilidade = new JLabel("");
		disponibilidade.setBounds(212, 134, 70, 15);
		getContentPane().add(disponibilidade);

		String[][] dadosSalas = Exibir.exibirSalasTabela(Banco.getSalas());
		String[] optionsSala = new String[dadosSalas.length + 1];

		optionsSala[0] = "";
		if (Banco.getSalas() != null) {
			for (int i = 0; i < dadosSalas.length; i++) {
				optionsSala[i + 1] = dadosSalas[i][1];
			}
			comboSala = new JComboBox(optionsSala);
			comboSala.setSelectedIndex(0);
		} else {
			comboSala = new JComboBox();
		}
		comboSala.setBackground(Color.white);
		comboSala.setBounds(426, 87, 89, 24);
		getContentPane().add(comboSala);
		
		precoField = new JTextField();
		precoField.setBounds(104, 168, 53, 19);
		getContentPane().add(precoField);
		precoField.setColumns(10);

		comboSala.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String dadosNoCampoSala = (String) comboSala.getSelectedItem();
				if (dadosNoCampoSala != "") {
					int nroDaSala = Integer.parseInt(dadosNoCampoSala);
					Sala salaSelecionada = Banco.obterSala(nroDaSala);
					if (salaSelecionada != null) {
						Integer capacidade = salaSelecionada.getCapacidade();
						disponibilidade.setText(capacidade.toString());
					} else {
						disponibilidade.setText("");
					}
				}else{
					disponibilidade.setText("");
				}

			}

		});
	}

	// Makes the frame visible.
	public void showIt() {
		this.setVisible(true);
	}

	// Makes the frame invisible.
	public void hideIt() {
		this.setVisible(false);
	}

	// Makes the frame visible and sets the title text.
	public void showIt(String title) {
		this.setTitle(title);
		this.setVisible(true);
	}

	// Makes the frame visible and sets the title text
	// and the position of the window.
	public void showIt(String title, int x, int y) {
		this.setTitle(title);
		this.setLocation(x, y);
		this.setVisible(true);
	}
}
