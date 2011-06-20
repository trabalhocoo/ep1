package interfaceGrafica;

import javax.swing.JFrame;

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
import java.util.Date;
import java.util.TreeSet;

import javax.swing.JComboBox;

public class VenderIngressoFrame extends JFrame{
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAno;
	private JTextField txtFilme;
	private JTextField txtHorario;
	private JTextField txtSala;
	private JTextField txtQuantidade;
	private JTextField txtPoltronas;
	private Usuario usuarioLogado;
	private Caixa caixa;
	private JTextField textNumeroDaSessao;
	private final JLabel lblNewLabel_2;
	
	public VenderIngressoFrame(final Usuario usuarioLogado, final Caixa caixa) {
		this.usuarioLogado = usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		
		setTitle("--- Venda de ingressos ---");
		getContentPane().setLayout(null);
		
		JLabel lblDigiteONmero = new JLabel("Digite o numero da sess\u00E3o que deseja vender:");
		lblDigiteONmero.setBounds(33, 43, 277, 14);
		getContentPane().add(lblDigiteONmero);
		
		txtDia = new JTextField();
		txtDia.setBounds(70, 88, 18, 20);
		getContentPane().add(txtDia);
		txtDia.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setBounds(98, 88, 18, 20);
		getContentPane().add(txtMes);
		txtMes.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setBounds(129, 88, 39, 20);
		getContentPane().add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblAno = new JLabel("Data");
		lblAno.setBounds(33, 91, 46, 14);
		getContentPane().add(lblAno);
		
		JLabel lblMs = new JLabel("/");
		lblMs.setBounds(89, 91, 30, 14);
		getContentPane().add(lblMs);
		
		JLabel lblDia = new JLabel("/");
		lblDia.setBounds(119, 91, 18, 14);
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
		
		txtFilme = new JTextField();
		txtFilme.setBounds(93, 116, 198, 20);
		getContentPane().add(txtFilme);
		txtFilme.setColumns(10);
		
		txtHorario = new JTextField();
		txtHorario.setBounds(93, 144, 198, 20);
		getContentPane().add(txtHorario);
		txtHorario.setColumns(10);
		
		txtSala = new JTextField();
		txtSala.setBounds(282, 88, 86, 20);
		getContentPane().add(txtSala);
		txtSala.setColumns(10);
		
		JLabel lblQuantosIngressosVo = new JLabel("Quantos ingressos v\u00E3o ser vendidos?");
		lblQuantosIngressosVo.setBounds(33, 172, 240, 14);
		getContentPane().add(lblQuantosIngressosVo);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(282, 169, 86, 20);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblQuantidadeDePoltronas = new JLabel("Quantidade de poltronas dispon\u00EDveis:");
		lblQuantidadeDePoltronas.setBounds(33, 197, 240, 14);
		getContentPane().add(lblQuantidadeDePoltronas);
		
		txtPoltronas = new JTextField();
		txtPoltronas.setBounds(282, 200, 86, 20);
		getContentPane().add(txtPoltronas);
		txtPoltronas.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");//vazio por enquanto
		lblNewLabel_2.setBounds(33, 18, 298, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sessao sessao = Banco.obterSessao(Integer.parseInt(textNumeroDaSessao.getText()));
				if (sessao!= null){
					Integer temp =  sessao.getSala().getNumero();
					txtSala.setText(temp.toString());
					txtFilme.setText(sessao.getFilme().getNome());
					Date data = (Date) sessao.getHorarioDeInicio().getTime();
					@SuppressWarnings("deprecation")
					Integer temp2 = data.getHours();
					@SuppressWarnings("deprecation")
					Integer temp3 = data.getMinutes();
					txtHorario.setText(temp2.toString() + ":" + temp3.toString());
					Integer temp4 = data.getDay();
					Integer temp5 = data.getMonth();
					Integer temp6 = data.getYear();
					txtDia.setText(temp4.toString());
					txtMes.setText(temp5.toString());
					txtAno.setText(temp6.toString());
				}
				else{
					lblNewLabel_2.setOpaque(false);
					lblNewLabel_2.setForeground(Color.red);
					lblNewLabel_2.setText("Numero de sessao não encontrado.");
				}
					
			}
		});
		btnOk.setBounds(463, 39, 55, 23);
		getContentPane().add(btnOk);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(33, 294, 144, 23);
		getContentPane().add(btnVender);
		
		JButton btnNewButton = new JButton("Cancelar compra");
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
		
		//Botao voltar
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
	public void showIt(){
		this.setVisible(true);
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
	
	// Makes the frame invisible.
	public void hideIt(){
		this.setVisible(false);
	}
}
