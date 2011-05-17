package objetos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;
import visualizacao.Exibir;
import visualizacao.InterfaceCinema;
import banco.*;
import controlador.*;


public class Usuario implements Serializable, Comparable<Usuario> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int registro;
	private boolean ehAdministrador;
	private String login;
	private String senha;
	private static int numeroDeUsuarios =2;
	
	public static int getNumeroDeUsuarios() {
		return numeroDeUsuarios;
	}

	public static void setNumeroDeUsuarios(int numeroDeUsuarios) {
		Usuario.numeroDeUsuarios = numeroDeUsuarios;
	}

	public Usuario(String nomenome, boolean admadm, String loginlogin, String passwd){
		numeroDeUsuarios++;
		this.nome=nomenome;
		this.registro= getNumeroDeUsuarios();
		this.ehAdministrador=admadm;
		this.login=loginlogin;
		this.senha=passwd;
	}
	
	public void exibirSessoes(){
		TreeSet<Sessao> listaSessoes = Banco.getSessoes();
		System.out.println ("Lista de sessoes:");
		Exibir.exibirSessoes(listaSessoes);
	}
	
	public void exibirFilmes(){
		ArrayList<Filme> listaFilmes = Banco.getFilmes();
		System.out.println ("Lista de filmes:");
		Exibir.exibirFilmes(listaFilmes);
	}
	
	public void exibirSalas(){
		TreeSet<Sala> listaSalas = Banco.getSalas();
		System.out.println ("Lista de salas:");
		Exibir.exibirSalas(listaSalas);
	}
	
	public boolean vender(Sessao sessao){
		int lugareDispo = sessao.getLugaresDisponiveis();
		if(lugareDispo == 0){
			System.out.println("Sessao esta cheia");
			return false;
		}
		else{
			sessao.setLugaresDisponiveis(lugareDispo--);
			return true;
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public boolean isEhAdministrador() {
		return ehAdministrador;
	}

	public void setEhAdministrador(boolean ehAdministrador) {
		this.ehAdministrador = ehAdministrador;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void deslogar(){
		Controlador.setLogado(false);
	}

	public void venderIngresso() {
		ArrayList dadosSessaoASerVendida = InterfaceCinema.adicionarSessao();
		
		Calendar horaInicio = Calendar.getInstance();
		//Filme filme, int year, int month, int date, int hourOfDay, int minute, Sala sala, double preco, int disp
			
	}

	@Override
	public int compareTo(Usuario o) {
		if(registro < o.registro){
			return -1;
		}else if(registro == o.registro){
			return 0;
		}
		return 1;
	}
}