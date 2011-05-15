package objetos;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;

/**
 * 
 * @author felipe
 *Tudo aqui lança IOException
 */
public class RegistroOutros extends Registrador {
	
	void registrarSessao(Sessao sessao, int tipo){
		
		try {
			FileOutputStream fluxo = new FileOutputStream("registroSessao.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(sessao);
			objarq.writeObject(tipo);
			objarq.writeObject("\n");
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
			objarq.writeObject("\n");
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
			objarq.writeObject("\n");
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
}
