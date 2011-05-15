package objetos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.TreeSet;

import visualizacao.Exibir;

import banco.Banco;

public class Administrador extends Usuario implements Serializable {
	
	
	Administrador (String nomenome, int registroregistro, boolean admadm, String loginlogin, String senhasenha){
		super(nomenome, registroregistro, true, loginlogin, senhasenha);
	}
		
	void addSessao(Filme filme, Date hora, Sala sala, double preco, boolean is3d){
		long fim_horario = (long) (hora.getTime() + filme.getDuracao()) ;//falta nao sei como fazer isso teria que somar o horario do inicio +tempo de filme 
		long duracao_final = fim - hora.getTime();
		Date duracao = new Date (duracao_final);
		
		Sessao _sessao = new Sessao (filme, hora, fim, sala, preco,duracao, sala.getCapacidade());
	}
		
	void modificarSessão(Sessao sessao, Filme filme, Date hora, Sala sala, double Preco, boolean 3d){
		//esperar 
	}
	
	boolean removerSessão(Sessao sessao){
		// se der tem que colocar no registro
		boolean removeu = false;
		removeu = Banco.removerSessao(Sessao sessao);
		return removeu;
	}
	
	void addSala(int capacidade, int numero, boolean is3d){
		Sala _sala = new Sala (capacidade,numero,is3d);
	}
	
	void modificarSala(Sala sala, int capacidade, int numero, boolean 3d){
		ArrayList resposta = new 
	}
	
	void exibirUsuarios(){//listar os usuarios existentes
        TreeSet <Usuario> listaUsuarios = Banco.getUsuarios();
        Exibir.exibirUsuarios(listaUsuarios);
}
	
	boolean addCaixa(int numero){
		Caixa caixaNova = new Caixa();
		//falta metodo adicionar caixa
		Banco.addCaixa(caixaNova);
	}
	
	boolean removerCaixa(){
		//remover caixa
		Caixa caixa = InterfaceCinema.removerCaixa();
		return Banco.removerCaixa(caixa);
	}
	
	void addFilme(){
		ArrayList resposta = InterfaceCinema.adicionarAtributosDoFilme();
		Filme filmeNovo = new Filme (resposta.get(0), resposta.get(1), resposta.get(2), resposta.get(3), resposta.get(4), resposta.get(5), resposta.get(6));
		Banco.adicionarFilme (filmeNovo);
	}
	//String nome, int faixa, Date duracao, String diretor, String sinopse, String genero, String estreia, boolean is3d)
	void modificarFilme(){
		ArrayList resposta = InterfaceCinema.alterarAtributosDoFilme();
		//falta método obter filme
		Filme filmeAAlterar= Banco.obterFilme(resposta.get(0));
		Banco.modificarFilme (filmeAAlterar, resposta.get(1), resposta.get(2), resposta.get(3), resposta.get(4), resposta.get(5);
	}
	
	boolean removerFilme(Filme filme){
		return Banco.removerFilme (filme);
	}
	
	void addUsuario(){
		//falta metodo
		ArrayList resposta = InterfaceCinema.addUsuario();
		Usuario novoUsuario = new Usuario (resposta.get(0),resposta.get(1), resposta.get(2), resposta.get(3));
		Banco.addUsuario (novoUsuario);
	}
	
	String nomenome, boolean admadm, String loginlogin, String passwd
	
	//teoricamente eu vou tirar os parametros de todos os métodos
	boolean removerUsuario(){
		// falta metodo
		Usuario usuario = InterfaceCinema.removerUsuario();
		return Banco.removerUsuario(usuario);
	}

	void modificarUsuario(){
		ArrayList<E> resposta = InterfaceCinema.alterarAtributosDoUsuario();
		Usuario usuarioAAlterar = Banco.obterUsuario(resposta.get(1));
		Banco.modificarUsuario (usuarioAAlterar, resposta.get(0), resposta.get(2),resposta.get(3), resposta.get(4));
	}

}
