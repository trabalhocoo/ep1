package interfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.Banco;

import objetos.Administrador;
import objetos.Sessao;
import objetos.Usuario;
import visualizacao.Exibir;

public class EditarSessaoFrame extends JFrame {

	private static Usuario usuarioLogado;
	private JTextField precoField;
	private JTextField horaField;
	private JTextField minutoField;
	private JTextField diaField;
	private JTextField mesField;
	private JTextField anoField;
	private JComboBox comboBoxFilme;
	private JLabel lblNumeroDaSala;
	private JComboBox comboSala;
	private JTextField sessaoField;
	private JTextField dispField;
	private JButton buttonLimpar;
	private JButton buttonAdd;

	public EditarSessaoFrame(final Usuario usrLogado) {
		usuarioLogado = usrLogado;
		final Administrador admin = (Administrador) usuarioLogado;
		this.setSize(550, 380);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white); // mudar a cor

		// voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(384, 286, 133, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnVoltar);

		JLabel lblEscolhaUmaSesso = new JLabel(
				"Digite o n\u00FAmero de uma sess\u00E3o que deseja alterar:");
		lblEscolhaUmaSesso.setBounds(34, 44, 316, 15);
		getContentPane().add(lblEscolhaUmaSesso);

		final JLabel lblAviso = new JLabel("");// vazio por enquanto
		lblAviso.setBounds(34, 18, 453, 14);
		getContentPane().add(lblAviso);

		sessaoField = new JTextField();
		sessaoField.setBounds(332, 41, 81, 20);
		getContentPane().add(sessaoField);

		String[][] dadosFilmes = Exibir.exibirFilmesTabela(Banco.getFilmes());
		final String[] optionsFilmes = new String[dadosFilmes.length + 1];

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
		comboBoxFilme.setBounds(113, 82, 81, 24);
		getContentPane().add(comboBoxFilme);

		final ActionListener actionLimpar = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sessaoField.setText("");
				comboBoxFilme.setSelectedIndex(0);
				comboSala.setSelectedIndex(0);
				dispField.setText("");
				precoField.setText("");
				horaField.setText("");
				minutoField.setText("");
				diaField.setText("");
				mesField.setText("");
				anoField.setText("");

			}
		};

		String[][] dadosSalas = Exibir.exibirSalasTabela(Banco.getSalas());
		final String[] optionsSala = new String[dadosSalas.length + 1];

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
		comboSala.setBounds(370, 82, 67, 24);
		getContentPane().add(comboSala);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sessao sessaoSelecionada;
				if (sessaoField.getText().equals("")) {
					lblAviso.setText("Por favor, preencha o campo numero da Sessão.");
				} else if (!sessaoField.getText().matches("^[0-9]")) {
					lblAviso.setText("Por favor, digite uma entrada válida");
					actionLimpar.actionPerformed(arg0);
				} else {
					lblAviso.setText("");
					sessaoSelecionada = Banco.obterSessao(Integer
							.parseInt(sessaoField.getText()));
					if (sessaoSelecionada == null) {
						lblAviso.setText("A sessão de numero "
								+ sessaoField.getText() + " não existe");
					} else {
						for (int i = 0; i < optionsFilmes.length; i++) {
							if (sessaoSelecionada.getFilme().getNome()
									.equals(optionsFilmes[i])) {
								comboBoxFilme.setSelectedIndex(i);
							}
						}

						for (int i = 1; i < optionsSala.length; i++) {
							if (sessaoSelecionada.getSala().getNumero() == Integer
									.parseInt(optionsSala[i])) {
								comboSala.setSelectedIndex(i);
							}
						}

						int aux = sessaoSelecionada.getSala().getCapacidade();
						Integer capacidade = new Integer(aux);
						dispField.setText(capacidade.toString());

						precoField.setText(new Double(sessaoSelecionada
								.getPreco()).toString());

						int hora = sessaoSelecionada.getHorarioDeInicio().get(
								Calendar.HOUR);
						horaField.setText(new Integer(hora).toString());

						int minuto = sessaoSelecionada.getHorarioDeInicio()
								.get(Calendar.MINUTE);
						minutoField.setText(new Integer(minuto).toString());

						int dia = sessaoSelecionada.getHorarioDeInicio().get(
								Calendar.DAY_OF_MONTH);
						diaField.setText(new Integer(dia).toString());

						int mes = sessaoSelecionada.getHorarioDeInicio().get(
								Calendar.MONTH);
						mesField.setText(new Integer(mes).toString());

						int ano = sessaoSelecionada.getHorarioDeInicio().get(
								Calendar.YEAR);
						anoField.setText(new Integer(ano).toString());
					}
				}
			}
		});
		btnOk.setBounds(436, 39, 64, 25);
		getContentPane().add(btnOk);

		JLabel lblNovoFilme = new JLabel("Novo filme:");
		lblNovoFilme.setBounds(34, 81, 81, 23);
		getContentPane().add(lblNovoFilme);

		lblNumeroDaSala = new JLabel("Numero da Sala:");
		lblNumeroDaSala.setBounds(246, 81, 133, 23);
		getContentPane().add(lblNumeroDaSala);

		JLabel lblDisponibilidade = new JLabel("Disponibilidade de lugares:");
		lblDisponibilidade.setBounds(34, 115, 168, 23);
		getContentPane().add(lblDisponibilidade);

		dispField = new JTextField("");
		dispField.setBounds(204, 115, 70, 19);
		getContentPane().add(dispField);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(34, 152, 53, 15);
		getContentPane().add(lblPreo);

		precoField = new JTextField();
		precoField.setBounds(113, 149, 64, 19);
		getContentPane().add(precoField);
		precoField.setColumns(10);

		JLabel label = new JLabel("Hora (24 horas)");
		label.setBounds(34, 186, 119, 15);
		getContentPane().add(label);

		horaField = new JTextField();
		horaField.setColumns(10);
		horaField.setBounds(34, 212, 31, 19);
		getContentPane().add(horaField);

		JLabel label_1 = new JLabel(":");
		label_1.setBounds(73, 215, 14, 15);
		getContentPane().add(label_1);

		minutoField = new JTextField();
		minutoField.setColumns(10);
		minutoField.setBounds(83, 212, 39, 19);
		getContentPane().add(minutoField);

		JLabel label_2 = new JLabel("Data");
		label_2.setBounds(236, 196, 70, 15);
		getContentPane().add(label_2);

		diaField = new JTextField();
		diaField.setColumns(10);
		diaField.setBounds(236, 212, 22, 19);
		getContentPane().add(diaField);

		JLabel label_3 = new JLabel("/");
		label_3.setBounds(260, 214, 14, 15);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("/");
		label_4.setBounds(291, 214, 14, 15);
		getContentPane().add(label_4);

		mesField = new JTextField();
		mesField.setColumns(10);
		mesField.setBounds(270, 212, 22, 19);
		getContentPane().add(mesField);

		anoField = new JTextField();
		anoField.setColumns(10);
		anoField.setBounds(299, 212, 51, 19);
		getContentPane().add(anoField);

		buttonLimpar = new JButton("Limpar Campos");
		buttonLimpar.addActionListener(actionLimpar);
		buttonLimpar.setBounds(216, 285, 134, 25);
		getContentPane().add(buttonLimpar);

		buttonAdd = new JButton("Salvar Altera��es");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sessao sessaoSelecionada;
				if (sessaoField.getText().equals("")) {
					lblAviso.setForeground(Color.red);
					lblAviso.setText("Por favor, preencha o campo numero da Sess�o.");
				} else if (!sessaoField.getText().matches("^[0-9]")) {
					lblAviso.setForeground(Color.red);
					lblAviso.setText("Por favor, digite uma entrada v�lida");
					actionLimpar.actionPerformed(arg0);
				} else {
					lblAviso.setText("");
					sessaoSelecionada = Banco.obterSessao(Integer
							.parseInt(sessaoField.getText()));
					if (sessaoSelecionada == null) {
						lblAviso.setForeground(Color.red);
						lblAviso.setText("A sess�o de numero "
								+ sessaoField.getText() + " n�o existe");
					} else {
						String campoFilme = (String) comboBoxFilme
								.getSelectedItem();
						String campoSala = (String) comboSala.getSelectedItem();
						String campoPreco = precoField.getText();
						String campoHora = horaField.getText();
						String campoMinuto = minutoField.getText();
						String campoDia = diaField.getText();
						String campoMes = mesField.getText();
						String campoAno = anoField.getText();
						String campoDisp = dispField.getText();

						if ("".equals(campoFilme) || "".equals(campoSala)
								|| "".equals(campoPreco)
								|| "".equals(campoHora)
								|| "".equals(campoMinuto)
								|| "".equals(campoDia) || "".equals(campoMes)
								|| "".equals(campoAno)) {
							lblAviso.setForeground(Color.red);
							lblAviso.setText("Por favor, preencha todos os campos.");
						} else {
							try {
								int ano = Integer.parseInt(campoAno);
								int mes = Integer.parseInt(campoMes);
								int dia = Integer.parseInt(campoDia);
								int hora = Integer.parseInt(campoHora);
								int minuto = Integer.parseInt(campoMinuto);
								int numSala = Integer.parseInt(campoSala);
								double preco = Double.parseDouble(campoPreco);
								int disp = Integer.parseInt(campoDisp);

								if (ano < 0 || mes < 0 || dia < 1 || hora < 0
										|| minuto < 0 || numSala < 1
										|| preco < 0 || disp < 0) {
									lblAviso.setForeground(Color.red);
									lblAviso.setText("Digite valores maiores que 0 e para dia maiores que 1");
								} else {

									Calendar dataOriginal = Calendar
											.getInstance();
									dataOriginal.set(ano, mes, dia, hora,
											minuto);

									String nome = campoFilme;

									ArrayList<Object> dadosDeSessao = new ArrayList<Object>();
									dadosDeSessao.add(dataOriginal);
									dadosDeSessao.add(nome);
									dadosDeSessao.add(ano);
									dadosDeSessao.add(mes);
									dadosDeSessao.add(dia);
									dadosDeSessao.add(hora);
									dadosDeSessao.add(minuto);
									dadosDeSessao.add(numSala);
									dadosDeSessao.add(preco);
									dadosDeSessao.add(disp);
									dadosDeSessao.add(sessaoSelecionada
											.getNumero());

									boolean funcionou = admin.alterarSessao(
											admin, dadosDeSessao);
									if (funcionou) {
										lblAviso.setForeground(Color.red);
										lblAviso.setText("Sessao alterada com sucesso!");
										actionLimpar.actionPerformed(arg0);
									} else {
										lblAviso.setForeground(Color.red);
										lblAviso.setText("Houve algum problema na altera��o");
									}
								}
							} catch (NumberFormatException e) {
								lblAviso.setForeground(Color.red);
								lblAviso.setText("Digite apenas caracteres num�ricos em campos num�ricos");
							}
						}

					}
				}
			}
		});
		buttonAdd.setBounds(34, 285, 143, 25);
		getContentPane().add(buttonAdd);
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
