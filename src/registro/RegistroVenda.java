package registro;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import objetos.Caixa;
import objetos.Filme;
import objetos.Sala;
import objetos.Sessao;
import objetos.Usuario;

public class RegistroVenda{

	// void registrarVenda(Filme filme, String hora, Sala sala, Date data,
	// double preco){
	public static void registrarVenda(String texto,Sessao sessao, double preco, Usuario usuario, Caixa caixa) {
		String informacoesVenda = "Vendeu ingresso Sessao: " + sessao.getNumero() + " Filme: " + sessao.getFilme().getNome()+ " Sala: " + sessao.getSala().getNumero() + " Preco " + sessao.getPreco();
		String conteudo = texto;
		String informacoesDeUsuarioEHora = "Nome do usuario: "+ usuario.getNome();
		FileWriter fw;
		try {
			fw = new FileWriter("registroVendas.txt", true);
			fw.write(informacoesDeUsuarioEHora);
			fw.write(informacoesVenda);
			fw.write(conteudo + System.getProperty("line.separator"));
			fw.close();
		}
		// em caso de erro apreenta mensagem abaixo
		catch (IOException e) {
			System.out.println(e);
		}
	}

}
