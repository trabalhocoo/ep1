package visualizacao;

import java.util.Scanner;

import banco.Banco;

import controlador.Controlador;

public class InterfaceCinema {

	static Scanner sc = new Scanner(System.in);
	
	public static boolean logar (){//tratar as execoes
		System.out.println("Digite o seu login");
		 int login = sc.nextInt();
		 System.out.println("Digite a sua senha");
		 String senha = sc.next();
		 boolean ehAdimin = Controlador.logar(login, senha);
		 
		 return (ehAdimin);
	}
	
	public static boolean ehAdimin{
		
	}
	
	public static Usuario remover(){
		System.out.println ("Digite o numero do registro de usuario que voce que remover: ");
		int registro = sc.nextInt();
		Banco.obterUsuario(registro);
		//falta terminar de implementar
		
	}
	
	public static void menu{
		System.out.println ("Digite 1 para registrar um filme");
		System.out.println ("Digite 2 para deletar um filme");
		System.out.println ("Digite 3 para deletar um filme");
	}
	
	
}
