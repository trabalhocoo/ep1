package registro;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import objetos.Filme;
import objetos.Sala;
import objetos.Sessao;
import objetos.Usuario;
import objetos.Caixa;

/**
 * 
 * @author felipe
 *Tudo aqui lança IOException
 */
public class RegistroOutros extends Registrador {
	
	public static void registrarSessao(String texto, Sessao sessao, Usuario usuario){
		String informacoesDaSessao = "Sobre a Sessao: Filme: " + sessao.getFilme().getNome() + "Sala: " + sessao.getSala().getNumero();// teoicamente deveria ter tb o horario
		String conteudo = texto;
		String informacoesDeUsuarioEHora  = "Nome do usuario :" + usuario.getNome();
	      FileWriter fw; 
	      try{   
	         fw = new FileWriter("registroSessao.txt",true);    
	         fw.write(informacoesDeUsuarioEHora);
	         fw.write(informacoesDaSessao); 
	         fw.write(conteudo);
	         fw.close();              
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
	   }
	
	public static void registrarSala(String texto, Sala sala, Usuario usuario){
		String informacoesDaSala = "Sala: " + sala.getNumero() + "Capacidade: " + sala.getCapacidade();// teoicamente deveria ter tb o horario
		String conteudo = texto;
		String informacoesDeUsuarioEHora  = "Nome do usuario :" + usuario.getNome();
	      FileWriter fw; 
	      try{   
	         fw = new FileWriter("registroSala.txt",true);    
	         fw.write(informacoesDeUsuarioEHora);
	         fw.write(informacoesDaSala); 
	         fw.write(conteudo);
	         fw.close();              
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
	   }
	
/*	
	void registrarSessao(Sessao sessao, int tipo){
		
		try {
			FileOutputStream fluxo = new FileOutputStream("registroSessao.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(sessao);
			objarq.writeObject(tipo);
			objarq.close();
		}
		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}
		
	}
	
	void registrarSala(Sala sala, int tipo){
		try {
			FileOutputStream fluxo = new FileOutputStream("registroSala.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(sala);
			objarq.writeObject(tipo);
			objarq.close();
		}
		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}
		
		
	}
	
	void registrarFilme(Filme filme, int tipo){
		
		try {
			FileOutputStream fluxo = new FileOutputStream("registroFilme.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(filme);
			objarq.writeObject(tipo);
			objarq.close();
		}
		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}
		
	}
	
	void registrarCaixa(Caixa caixa, int tipo){//da on saiu esse caixa? O_O
		
		try {
			FileOutputStream fluxo = new FileOutputStream("registroCaixa.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(caixa);
			objarq.writeObject(tipo);
			objarq.writeObject("\n");
			objarq.close();
		}
		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}
	}
	
	void registrarUsuario(Usuario usuario, int tipo){
		
		try {
			FileOutputStream fluxo = new FileOutputStream("registroUsuario.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(usuario);
			objarq.writeObject(tipo);
			objarq.writeObject("\n");
			objarq.close();
		}
		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}
		
	}
	*/
}
