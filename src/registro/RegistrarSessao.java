package registro;

import java.io.FileWriter;
import java.io.IOException;

import objetos.Sessao;
import objetos.Usuario;

public class RegistrarSessao extends Registrador{


	public <E> void gravaDados(String conteudo, Usuario user, String palavra,
			E sessao) {
		String informacoesDaSessao = "Criou a sessão:  Nº da Sessao : "+((Sessao) sessao).getNumero() + " Filme: "  + ((Sessao) sessao).getFilme().getNome() + " Sala: " + ((Sessao) sessao).getSala().getNumero();// teoicamente deveria ter tb o horario
		FileWriter fw; 
	      try{   
	         fw = new FileWriter("registroSessao.txt",true);    
	         fw.write(palavra);
	         fw.write(informacoesDaSessao); 
	         fw.write(conteudo + System.getProperty("line.separator"));
	         fw.close();              
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
		
	}

	
	
}
