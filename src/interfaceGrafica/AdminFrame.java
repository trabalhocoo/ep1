package interfaceGrafica;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {
	private JTextField textField;
	public AdminFrame() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblDigiteAOpo = new JLabel("Digite a op\u00E7\u00E3o desejada:");
		lblDigiteAOpo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigiteAOpo.setBounds(38, 24, 206, 19);
		getContentPane().add(lblDigiteAOpo);
		
		JLabel label = new JLabel("1 - Criar usuário");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(38, 71, 114, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2 - Editar usuário");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(38, 96, 114, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3 - Deletar usuário");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(38, 121, 114, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4 - Listar usuário");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(38, 144, 114, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("5 - Criar filme");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(38, 169, 114, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("6 - Editar filme");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(38, 194, 114, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("8 - Listar filme");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(201, 71, 114, 14);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("15 - Remover sessão");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(354, 71, 158, 14);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("7 - Remover filme");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(38, 219, 114, 14);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("9 - Criar sala");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(201, 96, 114, 14);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("10 - Editar sala");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBounds(201, 121, 114, 14);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("11 - Remover sala");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_11.setBounds(201, 146, 114, 14);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("12 - Listar salas");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_12.setBounds(201, 169, 114, 14);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("13 - Criar sessão");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_13.setBounds(201, 194, 114, 14);
		getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("14 - Editar sessão");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_14.setBounds(201, 219, 114, 14);
		getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("16 - Listar sessão");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_15.setBounds(354, 96, 114, 14);
		getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("17 - Criar caixa");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_16.setBounds(354, 121, 114, 14);
		getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("18 - Editar caixas");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_17.setBounds(354, 146, 114, 14);
		getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("19 - Remover caixa");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_18.setBounds(354, 169, 114, 14);
		getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("20 - Listar caixas");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_19.setBounds(354, 194, 114, 14);
		getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("21 - Deslogar");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_20.setBounds(354, 219, 114, 14);
		getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("22 - Sair");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_21.setBounds(354, 244, 114, 14);
		getContentPane().add(label_21);
		
		textField = new JTextField();
		textField.setBounds(178, 23, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int login = Integer.parseInt(textField.getText());
				
			}
		});
		btnNewButton.setBounds(274, 24, 52, 20);
		getContentPane().add(btnNewButton);
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
