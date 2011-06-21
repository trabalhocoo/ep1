package interfaceGrafica;

import java.awt.Color;
import javax.swing.*;
import banco.Banco;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import objetos.*;

public class EditarSalaFrame extends JFrame {
	private static Usuario usuarioLogado;
	private JTextField numSala;
	private JTextField capacidade;

	public EditarSalaFrame(Usuario usrLogado) {
		usuarioLogado = usrLogado;
		final Administrador admin = (Administrador) usuarioLogado;
		this.setSize(550, 380);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white); // mudar a cor

		JLabel lblDigiteONumero = new JLabel(
				"Digite o numero da sala que deseja alterar: ");
		lblDigiteONumero.setBounds(23, 85, 483, 14);
		getContentPane().add(lblDigiteONumero);

		numSala = new JTextField();
		numSala.setBounds(295, 82, 53, 20);
		getContentPane().add(numSala);
		numSala.setColumns(10);

		// box para dizer se a sala eh 3D
		final JCheckBox chckbxSalad = new JCheckBox("Sala 3D");
		chckbxSalad.setBounds(23, 198, 97, 23);
		chckbxSalad.setBackground(Color.white);
		getContentPane().add(chckbxSalad);

		final JLabel lblNewLabel_2 = new JLabel("");// vazio por enquanto
		lblNewLabel_2.setBounds(23, 50, 298, 14);
		getContentPane().add(lblNewLabel_2);

		JButton btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numSala.setText("");
				chckbxSalad.setSelected(false);
			}
		});
		btnLimparCampos.setBounds(209, 259, 123, 23);
		getContentPane().add(btnLimparCampos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(375, 259, 131, 23);
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
				lblNewLabel_2.setText("");
				try {
					// 0: usuario, 1: nome, 2: ehadmin, 3: senha
					int registro = Integer.parseInt(numSala.getText());
					Sala salaAAlterar = Banco.obterSala(registro);
					lblNewLabel_2.setOpaque(false);
					lblNewLabel_2.setForeground(Color.red);
					ArrayList<Object> arrayListDeSala = new ArrayList<Object>();
					arrayListDeSala.add(salaAAlterar);
					String capacidadeSala = capacidade.getText();
					if (Integer.parseInt(capacidadeSala) <= 0) {
						lblNewLabel_2
								.setText("A capacidade deve ser maior que 0.");
					} else {
						boolean option = chckbxSalad.isSelected();
						arrayListDeSala.add(Integer.parseInt(capacidadeSala));
						arrayListDeSala.add(registro);
						arrayListDeSala.add(option);
						// System.out.println (capacidadeSala + " " + registro +
						// " " + option);
						alterou = admin.alterarSala(arrayListDeSala);
						if (alterou) {
							lblNewLabel_2.setText("Sala alterada com sucesso.");
						} else
							lblNewLabel_2.setText("Sala nao encontrada.");
						capacidade.setText("");
					}
				} catch (NumberFormatException e) {
					lblNewLabel_2
							.setText("Digite apenas caracteres numéricos.");
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		});
		btnAdicionar.setBounds(50, 259, 123, 23);
		getContentPane().add(btnAdicionar);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean alterou = false;
				lblNewLabel_2.setText("");
				try {
					int registro = Integer.parseInt(numSala.getText());
					Sala salaAAlterar = Banco.obterSala(registro);
					lblNewLabel_2.setOpaque(false);
					lblNewLabel_2.setForeground(Color.red);
					if (salaAAlterar == null) {
						lblNewLabel_2.setText("Sala nao encontrada.");
						numSala.setText("");
						capacidade.setText("");
						chckbxSalad.setSelected(false);
					} else {
						Integer temp = salaAAlterar.getCapacidade();
						String cap = temp.toString();
						capacidade.setText(cap);
						if (salaAAlterar.is3d())
							chckbxSalad.setSelected(true);
						else
							chckbxSalad.setSelected(false);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(375, 81, 58, 23);
		getContentPane().add(btnNewButton);

		JLabel lblAlltereOsCamoos = new JLabel("Altere os campos desejados:");
		lblAlltereOsCamoos.setBounds(23, 119, 239, 14);
		getContentPane().add(lblAlltereOsCamoos);

		JLabel lblNome = new JLabel("Capacidade:");
		lblNome.setBounds(23, 167, 87, 14);
		getContentPane().add(lblNome);

		capacidade = new JTextField();
		capacidade.setBounds(120, 164, 104, 20);
		getContentPane().add(capacidade);
		capacidade.setColumns(10);

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
