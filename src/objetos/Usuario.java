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
	private static int numeroDeUsuarios;
	
	public Usuario(String nomenome, boolean admadm, String loginlogin, String passwd){
		
		this.nome=nomenome;
		numeroDeUsuarios++;
		this.registro= numeroDeUsuarios;
		this.ehAdministrador=admadm;
		this.login=loginlogin;
		this.senha=passwd;
	}
	
	public void exibirSessoes(){
		TreeSet<Sessao> listaSessoes = Banco.getSessoes();
		Exibir.exibirSessoes(listaSessoes);
	}
	
	public void exibirFilmes(){
		ArrayList<Filme> listaFilmes = Banco.getFilmes();
		Exibir.exibirFilmes(listaFilmes);
	}
	
	public void exibirSalas(){
		TreeSet<Sala> listaSalas = Banco.getSalas();
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
		ArrayList dadosSessaoASerVendida = InterfaceCinema.obterDadosSessao();
		
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