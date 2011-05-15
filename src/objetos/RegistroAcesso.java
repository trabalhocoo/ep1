package objetos;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;

public class RegistroAcesso extends Registrador {//serah q o q eu fiz tah certo? >_<

	void registrarAcesso(Usuario usuario, String hora){
		try {
			FileOutputStream fluxo = new FileOutputStream("usuarioEntrada.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(usuario);
			objarq.writeObject(hora);
			objarq.writeObject("\n");//como eu pulo uma linha?
			objarq.close();
		}
		
		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}

			//e se a pessoa naum conseguir escrever no arquivo? ele fecha e acabou? se eu colocar em um laco num fica estranho?


		}

		void registrarSaida(Usuario usuario, String hora){
			
			try {
				FileOutputStream fluxo = new FileOutputStream("usuarioSaida.txt");
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


		}

		void registrarLoginFalho(String usuario, String hora){//qq eh login falho?Eh qdo errou?pra q guardar?
			
			try {
				FileOutputStream fluxo = new FileOutputStream("usuarioFalho.txt");
				ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
				objarq.writeObject(usuario);
				objarq.writeObject(hora);
				objarq.writeObject("\n");//como eu pulo uma linha?
				objarq.close();
			}
			catch(IOException ioExc) {
				System.out.println(ioExc.getMessage());
				ioExc.printStackTrace();
			}
		}
	}
