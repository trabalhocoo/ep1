package interfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.Banco;

import objetos.Administrador;
import objetos.Caixa;
import objetos.Usuario;

public class RemoverCaixaFrame extends JFrame {

	private static Usuario usuarioLogado;
	private JTextField codCaixa;

	public RemoverCaixaFrame(final Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		final Administrador admin = (Administrador) usuarioLogado;
		this.setSize(550, 380);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); // mudar a cor

		JLabel lblDigiteONumero = new JLabel(
				"Digite o numero do caixa que deseja remover:");
		lblDigiteONumero.setBounds(33, 85, 483, 14);
		getContentPane().add(lblDigiteONumero);

		codCaixa = new JTextField();
		codCaixa.setBounds(325, 82, 53, 20);
		getContentPane().add(codCaixa);
		codCaixa.setColumns(10);

		final JLabel lblNewLabel_2 = new JLabel("");// vazio por enquanto
		lblNewLabel_2.setBounds(33, 60, 453, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setOpaque(false);
				lblNewLabel_2.setForeground(Color.red);
				if(codCaixa.getText().equals("")){
					lblNewLabel_2.setText("Por favor informar a caixa que deseja remover.");
				}
				else {
					int numeroDoCaixa = Integer.parseInt(codCaixa.getText());
					Caixa caixa = Banco.obterCaixa(numeroDoCaixa);
					if(caixa == null){
						lblNewLabel_2.setText("Caixa nao encontrado");
					}
					else {
						boolean removeu = admin.removerCaixa(numeroDoCaixa);//tem algo esquisito aki...(acho q esse metodo é gambiarra) Agora esta OK!!
						if (removeu){
							lblNewLabel_2.setText("Caixa removido com sucesso.");
							}
						else
							lblNewLabel_2.setText("Não foi possível remover o caixa. Veja se ele ainda está em uso ou se ainda tem dinheiro.");
					}
				}
			}
		});
		btnNewButton.setBounds(407, 81, 58, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminFrame usfr = new AdminFrame(admin);
				usfr.showIt("Menu Admin");
				dispose();
			}
		});
		btnVoltar.setBounds(368, 259, 108, 23);
		getContentPane().add(btnVoltar);

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
