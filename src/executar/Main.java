package executar;
import objetos.Usuario;
import controlador.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean logado = Controlador.isLogado();
		boolean tipoUser;
		do{
			System.out.println("Favor Logar, vagabundo!");
			tipoUser = InterfaceCinema.logar();
			logado = Controlador.isLogado();
		}while(!logado);
		InterfaceCinema.menu(tipoUser);
	}

}
