package banco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;

import objetos.Administrador;
import objetos.Caixa;
import objetos.Filme;
import objetos.Sala;
import objetos.Sessao;
import objetos.Usuario;

//Eu tive uma ideia pro banco: a gente poderia
//colocar já de cara um vetore 
public class Banco {

	private static ArrayList<Filme> filmes;
	private TreeSet<Sala> salas;
	private TreeSet<Caixa> caixas;
	private static TreeSet<Usuario> usuarios;
	private static TreeSet<Sessao> sessoes;

	// colocar os atributos. NÃ£o sei quais collections serÃ£o

	/**
	 * fazer essa coisa depois. Ele deve obter coisas do banco de dados
	 */
	public void gravarDados (){
		try {
			FileOutputStream fluxoSalas = new FileOutputStream("Sala.txt");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxoSalas);
			objarq.writeObject(salas);
			objarq.close();

			FileOutputStream fluxoSessoes = new FileOutputStream("Sessoes.txt");
			ObjectOutputStream objarqSessoes = new ObjectOutputStream(fluxoSessoes);
			objarq.writeObject(sessoes);
			objarq.close();

			FileOutputStream fluxoUsuarios = new FileOutputStream("Usuarios.txt");
			ObjectOutputStream objarqUsuarios = new ObjectOutputStream(fluxoUsuarios);
			objarqUsuarios.writeObject(usuarios);
			objarqUsuarios.close();

			FileOutputStream fluxoFilmes = new FileOutputStream("Filmes.txt");
			ObjectOutputStream objarqFilmes = new ObjectOutputStream(fluxoFilmes);
			objarqFilmes.writeObject(filmes);
			objarqFilmes.close();			
		}

		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}
	}

	void recuperarDados (){
		try {
			FileInputStream fluxo = new FileInputStream("Filmes.txt");
			ObjectInputStream objarq = new ObjectInputStream(fluxo);
			filmes = (ArrayList<Filme>) objarq.readObject();
			objarq.close();
			
			FileInputStream fluxoUsuario = new FileInputStream("Usuarios.txt");
			ObjectInputStream objarqUsuario = new ObjectInputStream(fluxoUsuario);
			usuarios = (TreeSet<Usuario>) objarqUsuario.readObject();
			objarqUsuario.close();
			
			FileInputStream fluxoSalas = new FileInputStream("Salas.txt");
			ObjectInputStream objarqSalas = new ObjectInputStream(fluxoSalas);
			salas = (TreeSet<Sala>) objarqSalas.readObject();
			objarqSalas.close();
			
			FileInputStream fluxoSessoes = new FileInputStream("Sessoes.txt");
			ObjectInputStream objarqSessoes = new ObjectInputStream(fluxoSessoes);
			sessoes = (TreeSet<Sessao>) objarqSessoes.readObject();
			objarqSessoes.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado");
		}
		catch(IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Nao ha registro de filmes");
		}
	}

	void addSessao(Sessao sessao) {
		sessoes.add(sessao);
	}

	boolean modificarSessao(Sessao sessao, Filme filme, Date horaInicio,
			long horaFim, Sala sala, double preco) {
		Iterator<Sessao> it = sessoes.iterator();
		Sessao sessaoEncontrada = null;
		// essa contrucao eh usada para nao dar currentModificationException
		while (it.hasNext()) {
			sessaoEncontrada = it.next();
			if (sessao.equals(sessaoEncontrada))
				break;
		}
		if (sessao.equals(sessaoEncontrada)) {
			sessaoEncontrada.setFilme(filme);
			sessaoEncontrada.setHorarioDeInicio(horaInicio);
			sessaoEncontrada.setHorarioDeFim(horaFim);
			sessaoEncontrada.setSala(sala);
			sessaoEncontrada.setPreco(preco);
			return true;
		}
		return false;
	}

	boolean removerSessao(Sessao sessao) {
		Iterator<Sessao> it = sessoes.iterator();
		while (it.hasNext()) {
			if (it.next().equals(sessao)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	void addSala(Sala sala) {
		salas.add(sala);
	}

	boolean modificarSala(Sala sala, int capacidade, int numero, boolean is3d) {
		Iterator<Sala> it = salas.iterator();
		Sala salaEncontrada = null;
		while (it.hasNext()) {
			salaEncontrada = it.next();
			if (sala.equals(salaEncontrada))
				break;
		}
		if (sala.equals(salaEncontrada)) {
			salaEncontrada.setCapacidade(capacidade);
			salaEncontrada.setIs3d(is3d);
			salaEncontrada.setNumero(numero);
			return true;
		}
		return false;
	}

	boolean removerSala(Sala sala) {
		Iterator<Sala> it = salas.iterator();
		while (it.hasNext()) {
			if (it.next().equals(sala)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	void adicionarFilme(Filme filme) {
		filmes.add(filme);
	}

	public static Usuario obterUsuario(int registro){
		for(Usuario usuario: usuarios){
			if(usuario.getRegistro() == registro){
				return usuario;
			}
		}
		return null;		
	}

	boolean modificarFilme(Filme filme, String nome, int faixaEtaria, Date horaInicio, Date duracao, String Diretor, String genero, Date dataEstreia) {
		Iterator<Filme> it = filmes.iterator();
		Filme filmeEncontrado = null;
		while (it.hasNext()){
			filmeEncontrado = it.next();
			if (filme.equals(filmeEncontrado))
				break;
		}
		if (filme.equals(filmeEncontrado)) {
			filmeEncontrado.setNome(nome);
			filmeEncontrado.setFaixaEtaria(faixaEtaria);
			filmeEncontrado.setDuracao(duracao);
			return true;
		}
		return false;
	}

	boolean removerFilme(Filme filme) {
		Iterator<Filme> it = filmes.iterator();
		while (it.hasNext()) {
			if (it.next().equals(filme)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	/**
	 * DEVE GERAR EXCESS�O caso naum consiga remover
	 * 
	 * @param usuario
	 * @return
	 */
	boolean removerUsuario(Usuario usuario) {
		Iterator<Usuario> it = usuarios.iterator();
		while (it.hasNext()) {
			if (it.next().equals(usuario)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	boolean modificarUsuario(Usuario usuario, String nome, boolean ehAdmin,
			String login, String senha) {
		Iterator<Usuario> it = usuarios.iterator();
		Usuario usuarioEncontrado = null;
		// essa contrucao eh usada para nao dar currentModificationException
		while (it.hasNext()) {
			usuarioEncontrado = it.next();
			if (usuario.equals(usuarioEncontrado))
				break;
		}
		if (usuario.equals(usuarioEncontrado)) {
			usuarioEncontrado.setNome(nome);
			usuarioEncontrado.setEhAdministrador(ehAdmin);
			usuarioEncontrado.setLogin(login);
			usuarioEncontrado.setSenha(senha);
			return true;
		}
		return false;
	}

	public static TreeSet<Sessao> getSessoes() {
		return sessoes;
	}
	
	public static TreeSet<Usuario> getUsuarios() {
		return usuarios;
	}

	public static ArrayList<Filme> getFilmes() {
		// TODO Auto-generated method stub
		return filmes;
	}
	
	
}