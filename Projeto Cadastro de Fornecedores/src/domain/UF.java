package domain;

public class UF {
	private String descricao;
	private String sigla;
	private Pais pais;
	public UF(String descricao, String sigla, Pais pais) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.pais = pais;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}	
}
