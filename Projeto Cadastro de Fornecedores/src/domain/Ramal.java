package domain;

public class Ramal extends Telefone{
	
	private String codigo;
	private String descricao;
	
	public Ramal(String ddd, String numero, String ddi, TipoTelefone tipotelefone) {
		super(ddd, numero, ddi, tipotelefone);
		// TODO Auto-generated constructor stub
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
