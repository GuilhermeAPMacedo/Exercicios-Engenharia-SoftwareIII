package domain;

public class Telefone extends Dominio {
	private String ddd;
	private String numero;
	private String ddi;
	private TipoTelefone tipotelefone;
	public Telefone(String ddd, String numero, String ddi, TipoTelefone tipotelefone) {
		this.ddd = ddd;
		this.numero = numero;
		this.ddi = ddi;
		this.tipotelefone = tipotelefone;
	}
	public String getDDD() {
		return ddd;
	}
	public void setDDD(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDdi() {
		return ddi;
	}
	public void setDdi(String ddi) {
		this.ddi = ddi;
	}
	public TipoTelefone getTipotelefone() {
		return tipotelefone;
	}
	public void setTipotelefone(TipoTelefone tipotelefone) {
		this.tipotelefone = tipotelefone;
	}		
	
}
