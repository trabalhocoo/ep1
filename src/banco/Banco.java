package banco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
	private static TreeSet<Sala> salas;
	private static TreeSet<Caixa> caixas;
	private static TreeSet<Usuario> usuarios;
	private static TreeSet<Sessao> sessoes;

	// colocar os atributos. NÃ£o sei quais collections serÃ£o

	/**
	 * fazer essa coisa depois. Ele deve obter coisas do banco de dados
	 */
	public static void gravarDados() {
		try {
			FileOutputStream fluxoCaixas = new FileOutputStream("Caixas.txt");
			ObjectOutputStream objarqCaixas = new ObjectOutputStream(
					fluxoCaixas);
			objarqCaixas.writeObject(caixas);
			objarqCaixas.close();

			FileOutputStream fluxoSalas = new FileOutputStream("Salas.txt");
			ObjectOutputStream objarqSalas = new ObjectOutputStream(fluxoSalas);
			objarqSalas.writeObject(salas);
			objarqSalas.close();

			FileOutputStream fluxoSessoes = new FileOutputStream("Sessoes.txt");
			ObjectOutputStream objarqSessoes = new ObjectOutputStream(
					fluxoSessoes);
			objarqSessoes.writeObject(sessoes);
			objarqSessoes.close();

			FileOutputStream fluxoUsuarios = new FileOutputStream(
					"Usuarios.txt");
			ObjectOutputStream objarqUsuarios = new ObjectOutputStream(
					fluxoUsuarios);
			objarqUsuarios.writeObject(usuarios);
			objarqUsuarios.close();

			FileOutputStream fluxoFilmes = new FileOutputStream("Filmes.txt");
			ObjectOutputStream objarqFilmes = new ObjectOutputStream(
					fluxoFilmes);
			objarqFilmes.writeObject(filmes);
			objarqFilmes.close();
		}

		catch (IOException ioExc) {
			System.out.println(ioExc.getMessage());
			ioExc.printStackTrace();
		}
	}

	public static void recuperarDados() {
		try {
			FileInputStream fluxoCaixas = new FileInputStream("Caixas.txt");
			ObjectInputStream objarqCaixas = new ObjectInputStream(fluxoCaixas);
			caixas = (TreeSet<Caixa>) objarqCaixas.readObject();
			objarqCaixas.close();

			FileInputStream fluxoFilmes = new FileInputStream("Filmes.txt");
			ObjectInputStream objarqFilmes = new ObjectInputStream(fluxoFilmes);
			filmes = (ArrayList<Filme>) objarqFilmes.readObject();
			objarqFilmes.close();

			FileInputStream fluxoUsuario = new FileInputStream("Usuarios.txt");
			ObjectInputStream objarqUsuario = new ObjectInputStream(
					fluxoUsuario);
			usuarios = (TreeSet<Usuario>) objarqUsuario.readObject();
			objarqUsuario.close();

			FileInputStream fluxoSalas = new FileInputStream("Salas.txt");
			ObjectInputStream objarqSalas = new ObjectInputStream(fluxoSalas);
			salas = (TreeSet<Sala>) objarqSalas.readObject();
			objarqSalas.close();

			FileInputStream fluxoSessoes = new FileInputStream("Sessoes.txt");
			ObjectInputStream objarqSessoes = new ObjectInputStream(
					fluxoSessoes);
			sessoes = (TreeSet<Sessao>) objarqSessoes.readObject();
			objarqSessoes.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado, criando os primeiros");
			try {
				gravarPrimeiraExec();
			} catch (IOException e1) {
				System.out.println("Impossivel criar arquivos para primeira execução");
				e1.printStackTrace();
			}
		} catch (IOException ioExc) {
			System.out.println(ioExc.getMessage() + " ferrou");
			ioExc.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Nao ha registro de filmes");
		}
	}



	void addSessao(Sessao sessao) {
		sessoes.add(sessao);
	}

	public static boolean modificarSessao(Sessao sessao, Filme filme,
			Calendar horaInicio, Sala sala, double preco) {
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
			sessaoEncontrada.setSala(sala);
			sessaoEncontrada.setPreco(preco);
			return true;
		}
		return false;
	}

	public static boolean removerSessao(Sessao sessao) {
		Iterator<Sessao> it = sessoes.iterator();
		while (it.hasNext()) {
			if (it.next().equals(sessao)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public static void addSala(Sala sala) {
		salas.add(sala);
	}

	public static boolean modificarSala(Sala sala, int capacidade, int numero,
			boolean is3d) {
		Iterator<Sala> it = salas.iterator();
		Sala salaEncontrada = null;
		// essa construção é usada para não dar CurrentModificationException
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

	public static void adicionarFilme(Filme filme) {
		filmes.add(filme);
	}

	public static Usuario obterUsuario(int registro) {
		for (Usuario usuario : usuarios) {
			if (usuario.getRegistro() == registro) {
				return usuario;
			}
		}
		return null;
	}

	boolean modificarFilme(Filme filme, String nome, int faixaEtaria,
			Date horaInicio, Date duracao, String Diretor, String genero,
			Date dataEstreia) {
		Iterator<Filme> it = filmes.iterator();
		Filme filmeEncontrado = null;
		// essa construção é usada para não dar CurrentModificationException
		while (it.hasNext()) {
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

	public static boolean removerFilme(Filme filme) {
		Iterator<Filme> it = filmes.iterator();
		while (it.hasNext()) {
			if (it.next().equals(filme)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public static void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public static boolean removerUsuario(Usuario usuario) {
		Iterator<Usuario> it = usuarios.iterator();
		while (it.hasNext()) {
			if (it.next().equals(usuario)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public static boolean modificarUsuario(Usuario usuario, String nome,
			boolean ehAdmin, String login, String senha) {
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
		return filmes;
	}

	public static Filme obterFilme(String nomeDoFilme) {
		for (Filme filme : filmes) {
			if (filme.getNome().equals(nomeDoFilme)) {
				return filme;
			}
		}
		return null;
	}

	public static Sala obterSala(int numeroDaSala) {
		for (Sala sala : salas) {
			if (sala.getNumero() == numeroDaSala) {
				return sala;
			}
		}
		return null;
	}

	public static Sessao obterSessao(Calendar hora, int numeroDaSala) {
		for (Sessao sessao : sessoes) {
			if (sessao.getHorarioDeInicio().equals(hora)
					&& sessao.getSala().getNumero() == numeroDaSala) {
				return sessao;
			}
		}
		return null;
	}

	public static boolean addCaixa(Caixa caixaNova) {
		boolean resultado = caixas.add(caixaNova);
		return resultado;
	}

	public static boolean removerCaixa(int caixa) {
		Iterator<Caixa> it = caixas.iterator();
		while (it.hasNext()) {
			if (it.next().getNumCaixa() == caixa) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	// String nome, int faixa, Date duracao, String diretor, String sinopse,
	// String genero, String estreia, boolean is3d
	public static boolean modificarFilme(Filme filmeAAlterar, String nome,
			int faixa, Date duracao, String diretor, String sinopse,
			String genero, String estreia, boolean is3d) {
		Iterator<Filme> it = filmes.iterator();
		Filme filmeEncontrado = null;
		// essa contrucao eh usada para nao dar currentModificationException
		while (it.hasNext()) {
			filmeEncontrado = it.next();
			if (filmeAAlterar.equals(filmeEncontrado))
				break;
		}
		if (filmeAAlterar.equals(filmeEncontrado)) {
			filmeEncontrado.setDataDeEstreia(estreia);
			filmeEncontrado.setDiretor(diretor);
			filmeEncontrado.setDuracao(duracao);
			filmeEncontrado.setFaixaEtaria(faixa);
			filmeEncontrado.setGenero(genero);
			filmeEncontrado.setIs3d(is3d);
			filmeEncontrado.setNome(nome);
			filmeEncontrado.setSinopse(sinopse);
			return true;
		}
		return false;
	}
	
	private static void gravarPrimeiraExec() throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fluxoCaixas = new FileOutputStream("Caixas.txt");
		ObjectOutputStream objarqCaixas = new ObjectOutputStream(fluxoCaixas);
		objarqCaixas.close();

		FileOutputStream fluxoSalas = new FileOutputStream("Salas.txt");
		ObjectOutputStream objarqSalas = new ObjectOutputStream(fluxoSalas);
		objarqSalas.close();

		FileOutputStream fluxoSessoes = new FileOutputStream("Sessoes.txt");
		ObjectOutputStream objarqSessoes = new ObjectOutputStream(fluxoSessoes);
		objarqSessoes.close();

		FileOutputStream fluxoFilmes = new FileOutputStream("Filmes.txt");
		ObjectOutputStream objarqFilmes = new ObjectOutputStream(
				fluxoFilmes);
		objarqFilmes.close();
		
		FileOutputStream fluxoUsuarios = new FileOutputStream("Usuarios.txt");
		ObjectOutputStream objarqUsuarios = new ObjectOutputStream(
				fluxoUsuarios);
		
		filmes = new ArrayList<Filme>();
		salas = new TreeSet<Sala>();
		caixas = new TreeSet<Caixa>();
		usuarios = new TreeSet<Usuario>();
		sessoes = new TreeSet<Sessao>();
		
		
		Administrador admin = new Administrador("Admin", true, "Admin", "123456");
		addUsuario(admin);
		objarqUsuarios.writeObject(usuarios);
		objarqUsuarios.close();
		
		gravarDados();
	}

	public static TreeSet<Sala> getSalas() {
		return salas;
	}

}