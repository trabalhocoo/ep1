package interfaceGrafica;

import javax.swing.JFrame;
import java.text.DateFormatSymbols;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import banco.Banco;

import objetos.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;

import javax.swing.JComboBox;

public class VenderIngressoFrame extends JFrame {
	private JLabel txtDia;
	private JLabel txtMes;
	private JLabel txtAno;
	private JLabel txtFilme;
	private JLabel txtHorario;
	private JLabel txtSala;
	private JTextField txtQuantidade;
	private JLabel txtPoltronas;
	private Usuario usuarioLogado;
	private Caixa caixa;
	private JTextField textNumeroDaSessao;
	private final JLabel lblNewLabel_2;

	public VenderIngressoFrame(final Usuario usuarioLogado, final Caixa caixa) {
		this.usuarioLogado = usuarioLogado;
		this.setSize(550, 380);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);

		setTitle("--- Venda de ingressos ---");
		getContentPane().setLayout(null);

		JLabel lblDigiteONmero = new JLabel(
				"Digite o numero da sess\u00E3o que deseja vender:");
		lblDigiteONmero.setBounds(33, 43, 277, 14);
		getContentPane().add(lblDigiteONmero);

		txtDia = new JLabel();
		txtDia.setForeground(Color.BLUE);
		txtDia.setBounds(70, 88, 18, 20);
		getContentPane().add(txtDia);

		txtMes = new JLabel();
		txtMes.setForeground(Color.BLUE);
		txtMes.setBounds(98, 88, 59, 20);
		getContentPane().add(txtMes);

		txtAno = new JLabel();
		txtAno.setForeground(Color.BLUE);
		txtAno.setBounds(167, 88, 39, 20);
		getContentPane().add(txtAno);

		JLabel lblAno = new JLabel("Data:");
		lblAno.setBounds(33, 91, 46, 14);
		getContentPane().add(lblAno);

		JLabel lblMs = new JLabel("/");
		lblMs.setBounds(89, 91, 30, 14);
		getContentPane().add(lblMs);

		JLabel lblDia = new JLabel("/");
		lblDia.setBounds(159, 91, 18, 14);
		getContentPane().add(lblDia);

		JLabel lblFilme = new JLabel("Filme:");
		lblFilme.setBounds(33, 119, 46, 14);
		getContentPane().add(lblFilme);

		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setBounds(33, 147, 46, 14);
		getContentPane().add(lblHorrio);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(227, 91, 46, 14);
		getContentPane().add(lblSala);

		txtFilme = new JLabel();
		txtFilme.setForeground(Color.BLUE);
		txtFilme.setBounds(93, 116, 198, 20);
		getContentPane().add(txtFilme);

		txtHorario = new JLabel();
		txtHorario.setForeground(Color.BLUE);
		txtHorario.setBounds(93, 144, 198, 20);
		getContentPane().add(txtHorario);

		txtSala = new JLabel();
		txtSala.setForeground(Color.BLUE);
		txtSala.setBounds(282, 88, 86, 20);
		getContentPane().add(txtSala);

		JLabel lblQuantosIngressosVo = new JLabel(
				"Quantos ingressos v\u00E3o ser vendidos?");
		lblQuantosIngressosVo.setBounds(33, 172, 240, 14);
		getContentPane().add(lblQuantosIngressosVo);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(282, 169, 86, 20);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);

		JLabel lblQuantidadeDePoltronas = new JLabel(
				"Quantidade de poltronas dispon\u00EDveis:");
		lblQuantidadeDePoltronas.setBounds(33, 197, 240, 14);
		getContentPane().add(lblQuantidadeDePoltronas);

		txtPoltronas = new JLabel();
		txtPoltronas.setForeground(Color.BLUE);
		txtPoltronas.setBounds(253, 197, 86, 20);
		getContentPane().add(txtPoltronas);

		lblNewLabel_2 = new JLabel("");// vazio por enquanto
		lblNewLabel_2.setBounds(33, 18, 464, 14);
		getContentPane().add(lblNewLabel_2);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setOpaque(false);
				lblNewLabel_2.setForeground(Color.red);

				if (textNumeroDaSessao.getText().equals("")) {
					lblNewLabel_2.setText("Digite um numero de sessao.");
					txtSala.setText("");
					txtAno.setText("");
					txtDia.setText("");
					txtFilme.setText("");
					txtMes.setText("");
					txtHorario.setText("");
					txtQuantidade.setText("");
					txtPoltronas.setText("");
					textNumeroDaSessao.setText("");
				} else {
					lblNewLabel_2.setText("");
					try {
						int numeroDaSessao = Integer
								.parseInt(textNumeroDaSessao.getText());
						if (numeroDaSessao < 1) {
							lblNewLabel_2
									.setText("Digite um numero de sessao maior que 0.");
							txtSala.setText("");
							txtAno.setText("");
							txtDia.setText("");
							txtFilme.setText("");
							txtMes.setText("");
							txtHorario.setText("");
							txtQuantidade.setText("");
							txtPoltronas.setText("");
							textNumeroDaSessao.setText("");
						} else {
							Sessao sessao = Banco.obterSessao(numeroDaSessao);
							if (sessao != null) {
								Integer temp = sessao.getSala().getNumero();
								txtSala.setText(temp.toString());
								txtFilme.setText(sessao.getFilme().getNome());
								Date data = (Date) sessao.getHorarioDeInicio()
										.getTime();
								// System.out.println (data);
								@SuppressWarnings("deprecation")
								Integer temp2 = data.getHours();
								@SuppressWarnings("deprecation")
								Integer temp3 = data.getMinutes();
								txtHorario.setText(temp2.toString() + ":"
										+ temp3.toString());
								@SuppressWarnings("deprecation")
								Integer temp4 = data.getDate();
								@SuppressWarnings("deprecation")
								Integer temp5 = data.getMonth();
								@SuppressWarnings("deprecation")
								Integer temp6 = data.getYear() + 1900;
								txtDia.setText(temp4.toString());
								String mes = getMonth(temp5);
								// System.out.println(temp4);
								txtMes.setText(mes);
								txtAno.setText(temp6.toString());
								Integer quantidadeDeLugaresDisponiveis = sessao
										.getLugaresDisponiveis();
								txtPoltronas
										.setText(quantidadeDeLugaresDisponiveis
												.toString());
							} else {
								lblNewLabel_2
										.setText("Numero de sessao não encontrado.");
							}
						}
					} catch (NumberFormatException e) {
						lblNewLabel_2
								.setText("Digite apenas valores numéricos.");
						txtSala.setText("");
						txtAno.setText("");
						txtDia.setText("");
						txtFilme.setText("");
						txtMes.setText("");
						txtHorario.setText("");
						txtQuantidade.setText("");
						txtPoltronas.setText("");
						textNumeroDaSessao.setText("");
					}
				}

			}
		});
		btnOk.setBounds(463, 39, 55, 23);
		getContentPane().add(btnOk);

		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setOpaque(false);
				lblNewLabel_2.setForeground(Color.red);
				try {
					if (textNumeroDaSessao.getText().equals("")
							|| txtQuantidade.getText().equals("")) {
						lblNewLabel_2.setText("Digite todos os campos.");
					} else if (Integer.parseInt(txtQuantidade.getText()) < 1
							|| Integer.parseInt(textNumeroDaSessao.getText()) < 1) {
						lblNewLabel_2
								.setText("Digite apenas valores maiores que 0.");
					} else if (Integer.parseInt(txtQuantidade.getText()) > Integer
							.parseInt(txtPoltronas.getText())) {
						lblNewLabel_2
								.setText("Quantidade de ingressos não disponível. Digite um numero menor ou igual a "
										+ txtPoltronas.getText() + ".");
					} else {
						ArrayList dadosSessaoASerVendida = new ArrayList();
						dadosSessaoASerVendida.add(Integer
								.parseInt(textNumeroDaSessao.getText()));
						dadosSessaoASerVendida.add(Integer
								.parseInt(txtQuantidade.getText()));
						boolean vendeu = usuarioLogado.venderIngresso(
								dadosSessaoASerVendida, caixa);
						if (vendeu == true) {
							lblNewLabel_2
									.setText("Ingressos vendidos com sucesso.");
							txtSala.setText("");
							txtAno.setText("");
							txtDia.setText("");
							txtFilme.setText("");
							txtMes.setText("");
							txtHorario.setText("");
							txtQuantidade.setText("");
							txtPoltronas.setText("");
							textNumeroDaSessao.setText("");
						} else {
							lblNewLabel_2
									.setText("Ocorreu um problema. Tente novamente.");
						}
					}
				} catch (NumberFormatException e) {
					lblNewLabel_2.setText("Digite apenas valores numéricos.");
				}
			}
		});
		btnVender.setBounds(33, 294, 144, 23);
		getContentPane().add(btnVender);

		JButton btnNewButton = new JButton("Limpas campos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setText("");
				txtSala.setText("");
				txtAno.setText("");
				txtDia.setText("");
				txtFilme.setText("");
				txtMes.setText("");
				txtHorario.setText("");
				txtQuantidade.setText("");
				txtPoltronas.setText("");
				textNumeroDaSessao.setText("");

			}
		});
		btnNewButton.setBounds(207, 294, 144, 23);
		getContentPane().add(btnNewButton);

		// Botao voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioFrame usfr = new UsuarioFrame(usuarioLogado, caixa);
				usfr.showIt("Menu Usuario");
				dispose();
			}
		});
		btnVoltar.setBounds(374, 294, 144, 23);
		getContentPane().add(btnVoltar);

		textNumeroDaSessao = new JTextField();
		textNumeroDaSessao.setBounds(334, 40, 86, 20);
		getContentPane().add(textNumeroDaSessao);
		textNumeroDaSessao.setColumns(10);

	}

	// Makes the frame visible.
	public void showIt() {
		this.setVisible(true);
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

	// Makes the frame invisible.
	public void hideIt() {
		this.setVisible(false);
	}

	public String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month - 1];
	}
}
