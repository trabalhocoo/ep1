package interfaceGrafica;

import javax.swing.JFrame;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import objetos.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VenderIngressoFrame extends JFrame{
	private JTextField txtSessao;
	private JTextField txtAno;
	private JTextField txtMes;
	private JTextField txtDia;
	private JTextField txtFilme;
	private JTextField txtHorario;
	private JTextField txtSala;
	private JTextField txtQuantidade;
	private JTextField txtPoltronas;
	private Usuario usuarioLogado;
	private Caixa caixa;
	
	public VenderIngressoFrame(final Usuario usuarioLogado, final Caixa caixa) {
		this.usuarioLogado = usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		
		setTitle("--- Venda de ingressos ---");
		getContentPane().setLayout(null);
		
		txtSessao = new JTextField();
		txtSessao.setBounds(201, 41, 86, 17);
		getContentPane().add(txtSessao);
		txtSessao.setColumns(10);
		
		JLabel lblDigiteONmero = new JLabel("Digite o n\u00FAmero da sess\u00E3o:");
		lblDigiteONmero.setBounds(33, 43, 184, 14);
		getContentPane().add(lblDigiteONmero);
		
		txtAno = new JTextField();
		txtAno.setBounds(70, 88, 18, 20);
		getContentPane().add(txtAno);
		txtAno.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setBounds(98, 88, 18, 20);
		getContentPane().add(txtMes);
		txtMes.setColumns(10);
		
		txtDia = new JTextField();
		txtDia.setBounds(129, 88, 39, 20);
		getContentPane().add(txtDia);
		txtDia.setColumns(10);
		
		JLabel lblAno = new JLabel("Data");
		lblAno.setBounds(33, 91, 46, 14);
		getContentPane().add(lblAno);
		
		JLabel lblMs = new JLabel("/");
		lblMs.setBounds(89, 91, 30, 14);
		getContentPane().add(lblMs);
		
		JLabel lblDia = new JLabel("/");
		lblDia.setBounds(119, 91, 18, 14);
		getContentPane().add(lblDia);
		
		JLabel lblFilme = new JLabel("Filme");
		lblFilme.setBounds(33, 119, 46, 14);
		getContentPane().add(lblFilme);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio");
		lblHorrio.setBounds(33, 147, 46, 14);
		getContentPane().add(lblHorrio);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(227, 91, 46, 14);
		getContentPane().add(lblSala);
		
		txtFilme = new JTextField();
		txtFilme.setBounds(70, 116, 98, 20);
		getContentPane().add(txtFilme);
		txtFilme.setColumns(10);
		
		txtHorario = new JTextField();
		txtHorario.setBounds(70, 144, 98, 20);
		getContentPane().add(txtHorario);
		txtHorario.setColumns(10);
		
		txtSala = new JTextField();
		txtSala.setBounds(282, 88, 86, 20);
		getContentPane().add(txtSala);
		txtSala.setColumns(10);
		
		JLabel lblQuantosIngressosVo = new JLabel("Quantos ingressos v\u00E3o ser vendidos?");
		lblQuantosIngressosVo.setBounds(33, 172, 184, 14);
		getContentPane().add(lblQuantosIngressosVo);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(227, 169, 86, 20);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblQuantidadeDePoltronas = new JLabel("Quantidade de poltronas dispon\u00EDveis:");
		lblQuantidadeDePoltronas.setBounds(33, 197, 184, 14);
		getContentPane().add(lblQuantidadeDePoltronas);
		
		txtPoltronas = new JTextField();
		txtPoltronas.setBounds(227, 194, 86, 20);
		getContentPane().add(txtPoltronas);
		txtPoltronas.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(313, 39, 55, 23);
		getContentPane().add(btnOk);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(33, 294, 144, 23);
		getContentPane().add(btnVender);
		
		JButton btnNewButton = new JButton("Cancelar compra");
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
