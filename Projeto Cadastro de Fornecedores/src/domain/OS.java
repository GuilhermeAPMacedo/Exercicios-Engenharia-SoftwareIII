package domain;

public class OS {
	private long dtInicio;
	private Servico servico;
	private Empresa empresa;
	
	public OS(long dtInicio, Servico servico,Empresa empresa) {
		this.dtInicio = dtInicio;
		this.servico = servico;
		this.empresa = empresa;
	}

	public long getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(long dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}	
	
}
