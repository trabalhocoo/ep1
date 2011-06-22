package registro;

import java.io.FileWriter;
import java.io.IOException;

import objetos.Usuario;

public class RegistroLogin extends Registrador{


	@Override
	public <E> void gravaDados(String conteudo, Usuario user, String informacoesDeUsuarioEHora, E object) {
		FileWriter fw; 
	      try{   
	         fw = new FileWriter("registroAcesso.txt",true);    
	         fw.write(informacoesDeUsuarioEHora);
	         fw.write(conteudo + System.getProperty("line.separator"));
	         fw.close();      
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
		
	}

	
	
	
}
