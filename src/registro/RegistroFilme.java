package registro;

import java.io.FileWriter;
import java.io.IOException;

import objetos.Filme;
import objetos.Usuario;

public class RegistroFilme extends Registrador{

	@Override
	public <E> void gravaDados(String texto, Usuario user, String palavra,
			E filme) {
		String informacoesDoFilme = "Criou o Filme: " + ((Filme) filme).getNome() + " Genero: " + ((Filme) filme).getGenero();// teoicamente deveria ter tb o horario
		FileWriter fw; 
	      try{   
	         fw = new FileWriter("registroFilme.txt",true);    
	         fw.write(palavra);
	         fw.write(informacoesDoFilme); 
	         fw.write(texto + System.getProperty("line.separator"));
	         fw.close();              
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
		// TODO Auto-generated method stub
		
	}

	
	
	
}
