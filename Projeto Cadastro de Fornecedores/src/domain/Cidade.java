package domain;

public class Cidade {
	private String descricao;
	private UF uf;
	public Cidade(String descricao, UF uf) {
		this.descricao = descricao;
		this.uf = uf;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}	
}
