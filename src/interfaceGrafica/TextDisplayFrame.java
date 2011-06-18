package interfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.util.ArrayList;


public class TextDisplayFrame extends JFrame{

	private JTable table;
	private String[] userColumnNames = {"Nome", "No. Registro", "Tipo de usuario"};
	private String[] filmColumnNames = {"Titulo", "Duracao", "Genero"};
	private String[] sessaoColumnNames = {"Filme", "Hora Inicio", "Sala", "Preco"};
	private String[] salaColumnNames = {"Capacidade", "Numero", "3d"};
	private String[] caixaColumnNames = {"Numero", "Dinheiro"};
	private String[] column;
	public TextDisplayFrame(String[][] exibir, String tipo){
		column = createColumnNames(tipo);
		table = new JTable(exibir, column);
		JScrollPane scrollpane = new JScrollPane(table);
		this.getContentPane().add(scrollpane);
		this.setSize(500,500);
		//this.add(valueLabel, BorderLayout.SOUTH);
	}
	
	public String[] createColumnNames(String tipo){
		String[] columnName = new String[3];
		if(tipo.equalsIgnoreCase("usuario"))
			columnName = getUserColumnName();
		if(tipo.equalsIgnoreCase("filme"))
			columnName = getFilmColumnName();
		if(tipo.equalsIgnoreCase("sessao")){
			return getSessaoColumnName();
		}
		if(tipo.equalsIgnoreCase("sala"))
			return getSalaColumnName();
		if(tipo.equalsIgnoreCase("caixa"))
			return getCaixaColumnName();
		return columnName;
	}
	
	public String[] getUserColumnName(){
		return this.userColumnNames;
	}
	public String[] getFilmColumnName(){
		return this.filmColumnNames;
	}
	public String[] getSessaoColumnName(){
		return this.sessaoColumnNames;
	}
	public String[] getSalaColumnName(){
		return this.salaColumnNames;
	}
	public String[] getCaixaColumnName(){
		return this.caixaColumnNames;
	}
	
}
