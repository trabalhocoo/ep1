package controlador;
import java.text.ParseException;

import objetos.Administrador;
import objetos.Usuario;
import banco.*;

public class Controlador{
	private static boolean isLogado;
	private static boolean tipoUsuario;
	private static Usuario usuarioLogado;
	private static boolean reiniciar;

	public static boolean logar(int registro, String senha){
		Usuario user = Banco.obterUsuario(registro);
		usuarioLogado = user;
		if(user != null){
			if(user.getSenha().equals(senha)){
				isLogado = true;
				tipoUsuario = user.isEhAdministrador();
				return true;
			}
		}
		
		return false;
	}

	public static void deslogar(){
		tipoUsuario = false;
		isLogado = false;
	}
	
	public static boolean isLogado() {
		return isLogado;
	}

	public static void setLogado(boolean isLogado) {
		Controlador.isLogado = isLogado;
	}

	public static boolean precisaReiniciar() {
		return reiniciar;
	}

	public static void setReiniciar(boolean reiniciar) {
		Controlador.reiniciar = reiniciar;
	}

	public static boolean tipoUsuario() {
		return tipoUsuario;
	}

	public static void setTipoUsuario(boolean tipoUsuario) {
		Controlador.tipoUsuario = tipoUsuario;
	}

	public static void sairDoPrograma(){
		Banco.gravarDados();
		System.exit(0);
	}
	
	public static void executaOpcao(int opcao) throws ParseException{
		if(tipoUsuario == true){
			Administrador admin = (Administrador)usuarioLogado;
			switch (opcao) {
			case 1:
				//Criar usuario
				admin.adicionarUsuario();
				break;
			case 2:
				//Editar usuario
				admin.alterarUsuario();
				break;
			case 3:
				//Remover usuario
				admin.removerUsuario();
				break;
			case 4:
				//Exibir usuarios
				admin.exibirUsuarios();
				break;
			case 5:
				//Criar filme
				admin.adicionarFilme();
				break;
			case 6:
				//Editar filme
				admin.alterarFilme();
				break;
			case 7:
				//Remover filme
				admin.removerFilme();
				break;
			case 8:
				//Exibir filme
				admin.exibirFilmes();
				break;
			case 9:
				//Criar Sala
				admin.adicionarSala();
				break;
			case 10:
				//Editar Sala
				admin.alterarSala();
				break;
			case 11:
				//Remover Sala
				admin.removerSala();
				break;
			case 12:
				//Exibir Salas
				admin.exibirSalas();
				break;
			case 13:
				//Criar sessao
				admin.adicionarSessao();
				break;
			case 14:
				//Editar sessao
				admin.alterarSessao();
				break;
			case 15:
				//Remover sessao
				admin.removerSessao();
				break;
			case 16:
				//Exibir Sessoes
				admin.exibirSessoes();
				break;
			case 17:
				//Criar Caixa
				admin.adicionarCaixa();
				break;
			case 18:
				//TODO Alterar Caixa
				admin.alterarCaixa();
				break;
			case 19:
				//Remover caixa
				admin.removerCaixa();
				break;
			case 20:
				//Exibir caixas
				admin.exibirCaixas();
				break;
			case 21:
				//Deslogar
				deslogar();
				break;
			case 22:
				//Sair do Programa
				sairDoPrograma();
				break;
			default:
				break;
			}
		}else{
			switch (opcao) {
			case 1:
				//Exibir filmes em usuario
				usuarioLogado.exibirFilmes();
				break;
			case 2:
				//Exibir sessoes em usuario
				usuarioLogado.exibirSessoes();
				break;
			case 3:
				//Exibir salas em usuario
				usuarioLogado.exibirSalas();
				break;
			case 4:
				//TODO Exibir filmes em usuario
				usuarioLogado.venderIngresso();
				break;
			case 5:
				//Deslogar
				deslogar();
				break;
			case 6:
				//Sair do Programa
				sairDoPrograma();
				break;
			default:
				break;
			}
		}
		
	}
}