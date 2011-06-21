package interfaceGrafica;
import java.awt.Color;
import javax.swing.*;

import objetos.*;
import banco.Banco;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditarCaixaFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField numeroCaixa;
	private Caixa caixaAAlterar;
	private JTextField textNumeroDoCaixa;
	private JTextField textSaldo;
	
	public EditarCaixaFrame (Usuario usrLogado){
		usuarioLogado = usrLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		
		
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
		
		JLabel label = new JLabel("Digite o numero do caixa que deseja alterar: ");
		label.setBounds(35, 83, 483, 14);
		getContentPane().add(label);
		
		numeroCaixa = new JTextField();
		numeroCaixa.setColumns(10);
		numeroCaixa.setBounds(359, 80, 53, 20);
		getContentPane().add(numeroCaixa);
		
		final JLabel lblAviso = new JLabel("");// vazio por enquanto
		lblAviso.setBounds(23, 50, 433, 14);
		getContentPane().add(lblAviso);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroDigitado = Integer.parseInt(numeroCaixa.getText());
				caixaAAlterar = Banco.obterCaixa(numeroDigitado);
				if(caixaAAlterar!= null){
					Integer temp = caixaAAlterar.getNumeroDaCaixa();
					textNumeroDoCaixa.setText(temp.toString());
					Double temp2 = caixaAAlterar.getDinheiro(); 
					textSaldo.setText(temp2.toString());
				}
				else {
					lblAviso.setOpaque(false);
					lblAviso.setForeground(Color.red);
					lblAviso.setText("Caixa nao encontrado.");
					numeroCaixa.setText("");
					textNumeroDoCaixa.setText("");
					textSaldo.setText("");	
				}
			}
		});
		button.setBounds(431, 79, 58, 23);
		getContentPane().add(button);
		
		
		JLabel label_1 = new JLabel("Altere os campos desejados:");
		label_1.setBounds(35, 116, 239, 14);
		getContentPane().add(label_1);
		
		JLabel lblNmeroDoCaixa = new JLabel("Numero do caixa: ");
		lblNmeroDoCaixa.setBounds(35, 156, 118, 14);
		getContentPane().add(lblNmeroDoCaixa);
		
		JLabel lblSaldoDoCaixa = new JLabel("Saldo do caixa: ");
		lblSaldoDoCaixa.setBounds(35, 192, 118, 14);
		getContentPane().add(lblSaldoDoCaixa);
		
		JButton button_Alterar = new JButton("Alterar");
		button_Alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAviso.setOpaque(false);
				lblAviso.setForeground(Color.red);
				int temp1 = Integer.parseInt(numeroCaixa.getText());
				Caixa caixaAtual = Banco.obterCaixa(temp1);
				int temp2 = Integer.parseInt(textNumeroDoCaixa.getText());
				Caixa pretendenteDeCaixa = Banco.obterCaixa(temp2);
				if (numeroCaixa.getText().equals("") || textNumeroDoCaixa.getText().equals("") || textSaldo.getText().equals("")){
					lblAviso.setText("Por favor, digite todos os campos.");
				}
				else if (pretendenteDeCaixa != null && !(numeroCaixa.getText().equals(textNumeroDoCaixa.getText()))){
					lblAviso.setText("Este caixa já existe. Por favor, digite um outro numero de caixa.");
				}
				else {
					ArrayList<Object> dadosCaixa = new ArrayList<Object>();
					dadosCaixa.add(Integer.parseInt(textNumeroDoCaixa.getText()));
					dadosCaixa.add(Double.parseDouble(textSaldo.getText()));
					boolean alterou = admin.alterarCaixa(dadosCaixa);
					if (alterou){
						lblAviso.setText("Caixa alterado com sucesso.");
						numeroCaixa.setText("");
						textNumeroDoCaixa.setText("");
						textSaldo.setText("");						
						
					}
					else {
						lblAviso.setText("Ocorreu um problema. Tente novamente.");
					}
				}
				
				
			}
		});
		button_Alterar.setBounds(36, 259, 131, 23);
		getContentPane().add(button_Alterar);
		
		JButton button_Limpar = new JButton("Limpar Campos");
		button_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAviso.setText("");
				numeroCaixa.setText("");
				textNumeroDoCaixa.setText("");
				textSaldo.setText("");
			}
		});
		button_Limpar.setBounds(214, 259, 131, 23);
		getContentPane().add(button_Limpar);
		
		textNumeroDoCaixa = new JTextField();
		textNumeroDoCaixa.setBounds(147, 153, 86, 20);
		getContentPane().add(textNumeroDoCaixa);
		textNumeroDoCaixa.setColumns(10);
		
		textSaldo = new JTextField();
		textSaldo.setColumns(10);
		textSaldo.setBounds(147, 189, 86, 20);
		getContentPane().add(textSaldo);
		
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
