package interfaceGrafica;

import javax.swing.*;

import banco.Banco;

import objetos.Administrador;
import objetos.Usuario;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverUsuarioFrame extends JFrame {
	private static Usuario usuarioLogado;
	private JTextField textField;

	public RemoverUsuarioFrame(final Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		final Administrador admin = (Administrador) usuarioLogado;
		this.setSize(550, 380);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); // mudar a cor

		JLabel lblDigiteONumero = new JLabel(
				"Digite o numero do registro de usuario que deseja remover:");
		lblDigiteONumero.setBounds(23, 85, 483, 14);
		getContentPane().add(lblDigiteONumero);

		textField = new JTextField();
		textField.setBounds(387, 82, 53, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		final JLabel lblNewLabel_2 = new JLabel("");// vazio por enquanto
		lblNewLabel_2.setBounds(23, 50, 298, 14);
		getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int registro = Integer.parseInt(textField.getText());
					if (registro < 1) {
						lblNewLabel_2.setOpaque(false);
						lblNewLabel_2.setForeground(Color.red);
						lblNewLabel_2.setText("Digite apenas valores maiores que 0.");
					} else {
						boolean removeu = admin.removerUsuario(registro);
						lblNewLabel_2.setOpaque(false);
						lblNewLabel_2.setForeground(Color.red);
						if (removeu) {
							lblNewLabel_2
									.setText("Usuario removido com sucesso.");
						} else
							lblNewLabel_2.setText("Usuario nao encontrado.");
					}
				} catch (NumberFormatException e) {
					lblNewLabel_2.setOpaque(false);
					lblNewLabel_2.setForeground(Color.red);
					lblNewLabel_2.setText("Digite apenas valores numéricos.");
				}
			}
		});
		btnNewButton.setBounds(448, 81, 58, 23);
		getContentPane().add(btnNewButton);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		btnVoltar.setBounds(387, 259, 89, 23);
		getContentPane().add(btnVoltar);

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
