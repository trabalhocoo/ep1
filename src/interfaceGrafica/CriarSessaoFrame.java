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
import objetos.Sessao;
import objetos.Usuario;
import visualizacao.Exibir;

public class CriarSessaoFrame extends JFrame {
	private static Usuario usuarioLogado;
	private JTextField textNomeDoFilme;
	private JComboBox comboBoxFilme;
	private JComboBox comboSala;
	private JLabel disponibilidade;
	private JTextField precoField;
	private JTextField horaField;
	private JTextField minutoField;
	private JTextField diaField;
	private JTextField mesField;
	private JTextField anoField;

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
		btnVoltar.setBounds(356, 293, 119, 23);
		getContentPane().add(btnVoltar);

		// Filme filme, int year, int month, int date, int hourOfDay, int
		// minute, Sala sala, double preco, int disp

		final JLabel lblAviso = new JLabel("");// vazio por enquanto
		lblAviso.setBounds(55, 67, 298, 14);
		getContentPane().add(lblAviso);

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
		lblSala.setBounds(286, 92, 102, 14);
		getContentPane().add(lblSala);

		// label preco
		JLabel lblPreco = new JLabel("Preco:");
		lblPreco.setBounds(55, 159, 51, 14);
		getContentPane().add(lblPreco);

		// label dispo
		JLabel lblDispo = new JLabel("Disponibilidade de lugares:");
		lblDispo.setBounds(55, 125, 193, 14);
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
			comboBoxFilme = new JComboBox(optionsFilmes);
			comboBoxFilme.setSelectedIndex(0);
		} else {
			comboBoxFilme = new JComboBox();
		}

		comboBoxFilme.setBackground(Color.white);
		// comboBox.addActionListener();
		comboBoxFilme.setBounds(149, 89, 94, 20);
		getContentPane().add(comboBoxFilme);

		disponibilidade = new JLabel("");
		disponibilidade.setBounds(212, 125, 70, 15);
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
		comboSala.setBounds(395, 89, 89, 20); // 145, 89, 94, 20
		getContentPane().add(comboSala);

		precoField = new JTextField();
		precoField.setBounds(104, 156, 53, 19);
		getContentPane().add(precoField);
		precoField.setColumns(10);

		JLabel lblHora = new JLabel("Hora (24 horas)");
		lblHora.setBounds(55, 186, 119, 15);
		getContentPane().add(lblHora);

		horaField = new JTextField();
		horaField.setBounds(55, 212, 31, 19);
		getContentPane().add(horaField);
		horaField.setColumns(10);

		JLabel doisPontos = new JLabel(":");
		doisPontos.setBounds(89, 214, 14, 15);
		getContentPane().add(doisPontos);

		minutoField = new JTextField();
		minutoField.setBounds(98, 212, 39, 19);
		getContentPane().add(minutoField);
		minutoField.setColumns(10);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(276, 196, 70, 15);
		getContentPane().add(lblData);

		diaField = new JTextField();
		diaField.setBounds(276, 212, 22, 19);
		getContentPane().add(diaField);
		diaField.setColumns(10);

		JLabel label = new JLabel("/");
		label.setBounds(299, 214, 14, 15);
		getContentPane().add(label);

		mesField = new JTextField();
		mesField.setBounds(304, 212, 22, 19);
		getContentPane().add(mesField);
		mesField.setColumns(10);

		JLabel label_1 = new JLabel("/");
		label_1.setBounds(332, 214, 14, 15);
		getContentPane().add(label_1);

		anoField = new JTextField();
		anoField.setColumns(10);
		anoField.setBounds(342, 212, 51, 19);
		getContentPane().add(anoField);
		
		final ActionListener limparCampos = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxFilme.setSelectedIndex(0);
				comboSala.setSelectedIndex(0);
				precoField.setText("");
				horaField.setText("");
				minutoField.setText("");
				mesField.setText("");
				diaField.setText("");
				anoField.setText("");

			}
		};

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(limparCampos);
		btnLimparCampos.setBounds(198, 292, 134, 25);
		getContentPane().add(btnLimparCampos);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String campoNomeFilme = (String) comboBoxFilme
						.getSelectedItem();
				String campoAno = anoField.getText();
				String campoMes = mesField.getText();
				String campoDia = diaField.getText();
				String campoHora = horaField.getText();
				String campoMinuto = minutoField.getText();
				String campoNumero = (String) comboSala.getSelectedItem();
				String campoPreco = precoField.getText();

				if (campoNomeFilme == null || campoAno == null
						|| campoMes == null || campoDia == null
						|| campoMinuto == null || campoNumero.equals("")
						|| campoPreco == null) {
					lblAviso.setOpaque(false);
					lblAviso.setForeground(Color.red);
					lblAviso.setText("Por favor, digite todos os campos.");
				} else {
					lblAviso.setOpaque(true);
					String nomeFilme = campoNomeFilme;
					int year = Integer.parseInt(campoAno);
					int month = Integer.parseInt(campoMes);
					int date = Integer.parseInt(campoDia);
					int hourOfDay = Integer.parseInt(campoHora);
					int minute = Integer.parseInt(campoMinuto);
					int nroSala = Integer.parseInt(campoNumero);
					Sala sala = Banco.obterSala(nroSala);
					if(campoPreco.split(",").length > 1){
						campoPreco = campoPreco.replaceFirst(",", ".");
					}
					double preco = Double.parseDouble(campoPreco);
					int disp = sala.getCapacidade();
					
					ArrayList dadosSessao = new ArrayList();
					dadosSessao.add(nomeFilme);
					dadosSessao.add(year);
					dadosSessao.add(month);
					dadosSessao.add(date);
					dadosSessao.add(hourOfDay);
					dadosSessao.add(minute);
					dadosSessao.add(nroSala);
					dadosSessao.add(preco);
					
					admin.adicionarSessao(admin, dadosSessao);
					lblAviso.setOpaque(false);
					lblAviso.setForeground(Color.red);
					lblAviso.setText("Sessao criada com sucesso. Numero " + Sessao.getNumeroDeSessoes());
					limparCampos.actionPerformed(arg0);
				}

			}
		});
		btnAdicionar.setBounds(55, 292, 117, 25);
		getContentPane().add(btnAdicionar);

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
				} else {
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
