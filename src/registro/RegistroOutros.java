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
	         fw.write(conteudo + System.getProperty("line.separator"));
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
	         fw.write(conteudo + System.getProperty("line.separator"));
	         fw.close();              
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
	   }
	
	public static void registrarFilme(String texto, Filme filme, Usuario usuario){
		String informacoesDoFilme = "Filme: " + filme.getNome() + "Genero: " + filme.getGenero();// teoicamente deveria ter tb o horario
		String conteudo = texto;
		String informacoesDeUsuarioEHora  = "Nome do usuario :" + usuario.getNome();
	      FileWriter fw; 
	      try{   
	         fw = new FileWriter("registroFilme.txt",true);    
	         fw.write(informacoesDeUsuarioEHora);
	         fw.write(informacoesDoFilme); 
	         fw.write(conteudo + System.getProperty("line.separator"));
	         fw.close();              
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
	   }
	
	public static void registrarUsuario(String texto, Usuario usuario, Usuario usuarioNovo){
		String informacoesDoNovoUsuario = "Novo usuario: " + usuarioNovo.getNome() + "Registro: " + usuarioNovo.getRegistro();// teoicamente deveria ter tb o horario
		String conteudo = texto;
		String informacoesDeUsuarioEHora  = "Nome do usuario :" + usuario.getNome();
	      FileWriter fw; 
	      try{   
	         fw = new FileWriter("registroUsuario.txt",true);    
	         fw.write(informacoesDeUsuarioEHora);
	         fw.write(informacoesDoNovoUsuario); 
	         fw.write(conteudo + System.getProperty("line.separator"));
	         fw.close();              
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
	   }
	
	public static void registrarCaixa(String texto, Usuario usuario, Caixa caixa){
		String informacoesDoCaixa = "Caixa: " + caixa.getNumeroDaCaixa();// teeoicamente deveria ter tb o horario
		String conteudo = texto;
		String informacoesDeUsuarioEHora  = "Nome do usuario :" + usuario.getNome();
	      FileWriter fw; 
	      try{   
	         fw = new FileWriter("registroCaixa.txt",true);    
	         fw.write(informacoesDeUsuarioEHora);
	         fw.write(informacoesDoCaixa); 
	         fw.write(conteudo + System.getProperty("line.separator"));
	         fw.close();              
	      }   
	      // em caso de erro apreenta mensagem abaixo   
	      catch(IOException e){   
	           System.out.println (e);
	      }   
	   }
}
