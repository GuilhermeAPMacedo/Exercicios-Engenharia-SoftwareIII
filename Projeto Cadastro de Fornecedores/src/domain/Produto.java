package domain;
import javax.swing.JOptionPane;

public class Produto extends Dominio{
	private int id;
	private String nome;
	private String descricao;
	
	public Produto(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void alterarProduto() {
		String entrada;
		do {
			entrada = JOptionPane.showInputDialog("Entre com a op��o que deseja alterar(id,nome,descricao) ou com sair");
			if (entrada.equals("id")){
				entrada = " ";
				entrada = JOptionPane.showInputDialog("Entre com o ID ");
				this.id = Integer.parseInt(entrada);
			}else if(entrada.equals("nome")) {
				this.nome = JOptionPane.showInputDialog("Entre com o nome ");
			}else if(entrada.equals("descricao")) {
				this.descricao = JOptionPane.showInputDialog("Entre com a descricao ");
			}else if (entrada.equals("sair")){
			}else {			
				JOptionPane.showMessageDialog(null, "Entrada invalida, tente digitar corretamente a op��o desejada.");
			}
		}while(!entrada.equals("sair"));
		JOptionPane.showMessageDialog(null,"As informa��es ficar�o: " + id + nome + descricao);
	}
}
