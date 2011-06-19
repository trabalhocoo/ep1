package interfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

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
	public VenderIngressoFrame() {
		getContentPane().setBackground(new Color(100, 149, 237));
		setBackground(Color.ORANGE);
		setResizable(false);
		setTitle("--- Venda de ingressos ---");
		getContentPane().setLayout(null);
		
		txtSessao = new JTextField();
		txtSessao.setBounds(175, 40, 86, 20);
		getContentPane().add(txtSessao);
		txtSessao.setColumns(10);
		
		JLabel lblDigiteONmero = new JLabel("Digite o n\u00FAmero da sess\u00E3o");
		lblDigiteONmero.setBounds(33, 43, 184, 14);
		getContentPane().add(lblDigiteONmero);
		
		txtAno = new JTextField();
		txtAno.setBounds(70, 88, 86, 20);
		getContentPane().add(txtAno);
		txtAno.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setBounds(70, 112, 86, 20);
		getContentPane().add(txtMes);
		txtMes.setColumns(10);
		
		txtDia = new JTextField();
		txtDia.setBounds(70, 136, 86, 20);
		getContentPane().add(txtDia);
		txtDia.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(33, 91, 46, 14);
		getContentPane().add(lblAno);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(33, 115, 46, 14);
		getContentPane().add(lblMs);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(33, 139, 46, 14);
		getContentPane().add(lblDia);
		
		JLabel lblFilme = new JLabel("Filme");
		lblFilme.setBounds(175, 91, 46, 14);
		getContentPane().add(lblFilme);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio");
		lblHorrio.setBounds(175, 115, 46, 14);
		getContentPane().add(lblHorrio);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(175, 139, 46, 14);
		getContentPane().add(lblSala);
		
		txtFilme = new JTextField();
		txtFilme.setBounds(227, 88, 86, 20);
		getContentPane().add(txtFilme);
		txtFilme.setColumns(10);
		
		txtHorario = new JTextField();
		txtHorario.setBounds(227, 112, 86, 20);
		getContentPane().add(txtHorario);
		txtHorario.setColumns(10);
		
		txtSala = new JTextField();
		txtSala.setBounds(227, 136, 86, 20);
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
		btnOk.setBounds(270, 39, 46, 23);
		getContentPane().add(btnOk);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(33, 222, 184, 23);
		getContentPane().add(btnVender);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(224, 222, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Venda de ingressos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblNewLabel.setBounds(33, 11, 175, 21);
		getContentPane().add(lblNewLabel);
	}
}
