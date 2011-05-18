package registro;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import objetos.Usuario;


public class RegistroAcesso extends Registrador {
	
	public static void registrarAcesso(String texto, Usuario usuario){
		String conteudo = texto;
		String informacoesDeUsuarioEHora  = "Nome do usuario :" + usuario.getNome();
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

	
/*
		void registrarLoginFalho(String usuario, String hora){
			try {
				FileOutputStream fluxo = new FileOutputStream("usuarioFalho.txt");
				ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
				objarq.writeObject(usuario);
				objarq.writeObject(hora);
				objarq.writeObject("\n");
				objarq.close();
			}
			catch(IOException ioExc) {
				System.out.println(ioExc.getMessage());
				ioExc.printStackTrace();
			}
			*/
	}