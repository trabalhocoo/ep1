package objetos;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class RegistroVenda extends Registrador {//o q eh esse Registrador? O_O

	void registrarVenda(Filme filme, String hora, Sala sala, Date data, double preco){
		try {
			FileOutputStream fluxo = new FileOutputStream("registroVenda.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(filme);
			objarq.writeObject(hora);
			objarq.writeObject(sala);
			objarq.writeObject(data);
			objarq.writeObject(preco);
			objarq.writeObject("\n");
			objarq.close();
		}
		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}

	}
	
	void registrarVendaErrada(Filme filme, String hora, Sala sala, Date data, double preco){//pra q registrar a venda errada?
		
		
		
	}
	
}
