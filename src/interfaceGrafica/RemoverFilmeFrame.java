package interfaceGrafica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.*;

import banco.Banco;

import objetos.Administrador;
import objetos.Filme;
import objetos.Sessao;
import objetos.Usuario;

public class RemoverFilmeFrame extends JFrame{
	private static Usuario usuarioLogado;
	private JTextField textField;
	private JComboBox listaDeFilmes;
	
	public RemoverFilmeFrame(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		final Administrador admin = (Administrador)usuarioLogado;
		this.setSize(550,380);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white); //mudar a cor
		
		JLabel lblDigiteONumero = new JLabel("Escolha o filme que deseja remover:");
		lblDigiteONumero.setBounds(21, 82, 483, 14);
		getContentPane().add(lblDigiteONumero);
		
		

		//guardar o arraylist de nomes de filme
		ArrayList <Filme> listaFilmes = Banco.getFilmes();
		String[] options = new String [listaFilmes.size()+1];
		options[0]="";
		for (int i = 0; i<listaFilmes.size(); i++){
			options[i+1]=listaFilmes.get(i).getNome();
		}
		listaDeFilmes = new JComboBox(options);
		listaDeFilmes.setBounds(245, 79, 203, 20);
		getContentPane().add(listaDeFilmes);
		
		
		final JLabel lblNewLabel_2 = new JLabel("");//vazio por enquanto
		lblNewLabel_2.setBounds(23, 30, 298, 14);
		getContentPane().add(lblNewLabel_2);
		
		//voltar
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
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setOpaque(false);
				lblNewLabel_2.setForeground(Color.red);
				TreeSet<Sessao> sessoesDoBanco = Banco.getSessoes();
				boolean podeRemover = true;
				String nomeDoFilmeASerRemovido = (String)listaDeFilmes.getSelectedItem();
				for (Sessao sessao: sessoesDoBanco){
					if (sessao.getFilme().getNome().equals(nomeDoFilmeASerRemovido) && sessao.getLugaresDisponiveis()!=sessao.getSala().getCapacidade()){
						podeRemover = false;
						break;
					}
				}
				
				if(podeRemover == false){
					lblNewLabel_2.setText("Filme não pode ser removida pois está sendo usada em uma sessao já vendida.");
				}				
				else if (listaDeFilmes.getSelectedIndex()==0){
					lblNewLabel_2.setText("Por favor, escolha o filme que deseja remover.");
			} else {
				boolean removeu = admin.removerFilme(nomeDoFilmeASerRemovido);
				
				if (removeu){
					lblNewLabel_2.setText("O filme " + nomeDoFilmeASerRemovido + " foi removido com sucesso.");
				}
				else{
					lblNewLabel_2.setText("O filme " + nomeDoFilmeASerRemovido + " não foi encontrado.");
				}
			}
					
			}
		});
		button.setBounds(458, 78, 58, 23);
		getContentPane().add(button);
		
		
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
