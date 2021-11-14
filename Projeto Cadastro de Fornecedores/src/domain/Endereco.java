package domain;

public class Endereco extends Dominio{
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private Cidade cidade;
	private TipoLogradouro tipologradouro;
	private TipoEndereco tipoendereco;
	public Endereco(String cep, String logradouro, String numero, String bairro, String complemento, Cidade cidade,
			TipoLogradouro tipologradouro, TipoEndereco tipoendereco) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.tipologradouro = tipologradouro;
		this.tipoendereco = tipoendereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public TipoLogradouro getTipologradouro() {
		return tipologradouro;
	}
	public void setTipologradouro(TipoLogradouro tipologradouro) {
		this.tipologradouro = tipologradouro;
	}
	public TipoEndereco getTipoendereco() {
		return tipoendereco;
	}
	public void setTipoendereco(TipoEndereco tipoendereco) {
		this.tipoendereco = tipoendereco;
	}
	
}
