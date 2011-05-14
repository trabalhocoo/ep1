package objetos;
import java.sql.Date;

public class Banco {
	
	collection filmes;//o q sao essas collections? 
	collection salas;
	collection caixas;
	collection usuarios;
	collection sessões;
	
	
	void recuperarDados(){
		
	}
	 addSessão(Sessao sessao){
		 
	 }
	 
	void modificarSessão(Sessao sessao, Filme filme, Date hora, Sala sala, double Preco,
	boolean eh3d){
		
	}
	
	void removerSessão(Sessao sessao){
		
	}
	
	void addSala(Sala sala){
		
	}
	
	void modificarSala(Sala sala, int capacidade, int numero, boolean eh3d){
		
	}
	void removerSala(Sala sala){
		
	}
	
	void addCaixa(Caixa caixa){
		
	}
	
	void removerCaixa(Caixa caixa){
		
	}
	
	
	void adicionarFilme(Filme filme){
		
	}
	
	void modificarFilme(Filme filme, String nome, int faixaEtaria, int horas, int minutos, String diretor, String gênero, Date dataEstreia){
		
	}
	
	void removerFilme(Filme filme){
		
	}
	
	void addUsuario(Usuario usuario){
		
	}
	
	void removerUsuario(Usuario usuario){
		
	}
	
	void modificarUsuario(Usuario usuario, String nome, boolean ehAdmin, String login, String senha){
		
	}

}
