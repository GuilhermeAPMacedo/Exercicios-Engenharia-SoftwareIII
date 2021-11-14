package domain;
import java.util.Date;

import javax.swing.JOptionPane;

public class Fornecedor extends Dominio {
	private boolean isRascunho;

	private int id;

	private String email;

	private String cnpj;

	private String inscricaoEstadual;

	private String inscricaoMunicipal;

	private Date dtCadastro;

	private String rzSocial;

	private String nmFantasia;
	
	private Endereco endereco;
	
	private Telefone telefone;
	
	private Empresa empresa;
	
	private Produto produto;
	
	private TipoFornecimento tipoFornecimento;
	
	private String status;
	
	private CNAE cnae;
	
	private Contato contato;
	
	private String consulta;
		
	public Fornecedor(int id, String email, String cnpj, String inscricaoEstadual, String inscricaoMunicipal, String rzSocial,
			String nmFantasia, Endereco endereco, Telefone telefone, Empresa empresa, Produto produto,
			TipoFornecimento tipoFornecimento, CNAE cnae) {
		this.id = id;
		this.email = email;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.rzSocial = rzSocial;
		this.nmFantasia = nmFantasia;
		this.endereco = endereco;
		this.telefone = telefone;
		this.empresa = empresa;
		this.produto = produto;
		this.tipoFornecimento = tipoFornecimento;
		this.cnae = cnae;
		this.isRascunho = true;
		status = Status.rascunho;
	}

	public void salvar() {
		if(produto.getNome() == null) {
			JOptionPane.showMessageDialog(null, "Precisa adicionar pelo menos um produto ao fornecedor para salvar.");
		}else if(contato.getNome()==null){
			JOptionPane.showMessageDialog(null, "Precisa adicionar pelo menos um contato ao fornecedor para salvar.");
		}else {
			this.isRascunho = false;
			status = Status.ativo;
			JOptionPane.showMessageDialog(null, "Fornecedor Salvo!");
		}		
	}

	public void alterar() {
		String entrada;
		do {
			entrada = JOptionPane.showInputDialog("Entre com a op��o que deseja alterar(id,email,cnpj,inscricaoEstadual,inscricaoMunicipal,rzSocial,nmFantasia) ou com sair");
			if (entrada.equals("id")){
				entrada = " ";
				entrada = JOptionPane.showInputDialog("Entre com o ID ");
				this.id = Integer.parseInt(entrada);
			}else if(entrada.equals("email")) {
				this.email = JOptionPane.showInputDialog("Entre com o email ");
			}else if(entrada.equals("cnpj")) {
				this.cnpj = JOptionPane.showInputDialog("Entre com o CNPJ ");
			}else if(entrada.equals("inscricaoEstadual")){
				this.inscricaoEstadual = JOptionPane.showInputDialog("Entre com a inscri��o Estadual ");			
			}else if(entrada.equals("inscricaoMunicipal")){
				this.inscricaoMunicipal = JOptionPane.showInputDialog("Entre com a inscri��o Municipal ");
			}else if(entrada.equals("rzSocial")){
				this.rzSocial = JOptionPane.showInputDialog("Entre com a Raz�o Social ");
			}else if(entrada.equals("nmFantasia")){
				this.nmFantasia = JOptionPane.showInputDialog("Entre com o nome fantasia ");
			}else if (entrada.equals("sair")){
					JOptionPane.showMessageDialog(null, "Saindo!");
			}else {
				JOptionPane.showMessageDialog(null, "Entrada invalida, tente digitar corretamente a op��o desejada.");
			}
		}while(!entrada.equals("sair"));
	}

	public String consultar() {
		consulta = "Dados completos: \n";
		consulta +="ID: " + id;
		consulta +="\nEmail: " + email;
		consulta +="\nCNPJ: " + cnpj;
		consulta +="\nInscri��o Estadual: " + inscricaoEstadual;
		consulta +="\nInscri��o Municipal: " + inscricaoMunicipal;
		consulta +="\nData Cadastro: " + dtCadastro;
		consulta +="\nrzSocial: " + rzSocial;
		consulta +="\nnmFantasia: " + nmFantasia;
		consulta +="\nrzStatus: " + status;
		consulta +="\nCNAE: " + cnae.getNumero();
		return consulta;
	}

	public void excluir() {
		id = 0;
		email = null;
		cnpj = null;
		inscricaoEstadual = null;
		inscricaoMunicipal = null;
		dtCadastro = null;
		rzSocial = null;
		nmFantasia = null;
		status = null;
		endereco = null;
		telefone = null;
		empresa = null;
		produto = null;
		tipoFornecimento = null;
		status = null;
		cnae = null;
		contato = null;
		this.status=Status.inativo;
	}

	public void inativar() {
		this.status = Status.inativo;		
	}

	public void ativar() {
		this.status = Status.ativo;
	}

	public void addContato(Contato contato) {
		this.contato = contato;
	}

	public void validarCNPJ() {

	}

	public void validarListaFornecimento() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public String getRzSocial() {
		return rzSocial;
	}

	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}

	public String getNmFantasia() {
		return nmFantasia;
	}

	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public TipoFornecimento getTipoFornecimento() {
		return tipoFornecimento;
	}

	public void setTipoFornecimento(TipoFornecimento tipoFornecimento) {
		this.tipoFornecimento = tipoFornecimento;
	}

	public String getStatus() {
		return status;
	}

	public CNAE getCnae() {
		return cnae;
	}

	public void setCnae(CNAE cnae) {
		this.cnae = cnae;
	}
	public Contato getContato() {
		return contato;
	}
}
