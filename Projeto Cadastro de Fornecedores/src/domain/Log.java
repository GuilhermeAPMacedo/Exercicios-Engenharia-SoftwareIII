package domain;
import java.sql.Date;
import java.util.ArrayList;

public class Log {
	private Date dataHora;
	private ArrayList lista = new ArrayList();
	
	public void registrarTransacao(Usuario usuario, Fornecedor fornecedor) {
		lista.add("Data: " + dataHora + "Alteração do: "+usuario.getLogin() + "Feita no ID:" + fornecedor.getId() + "\n");
	}
	public ArrayList verificarLog() {
		return lista;
	}
}
