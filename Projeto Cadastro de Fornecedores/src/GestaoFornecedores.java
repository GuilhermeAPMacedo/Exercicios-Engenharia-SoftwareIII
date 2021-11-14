import domain.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GestaoFornecedores {

	public static void main(String[] args) {
		
		Pais Brasil = new Pais("Pais");
		UF SaoPaulo = new UF("Estado","SP",Brasil);
		Cidade MogidasCruzes = new Cidade("Cidade",SaoPaulo);
		TipoEndereco Casa = new TipoEndereco("Casa","Tipo de endereço");
		TipoLogradouro Rua = new TipoLogradouro("Rua","Tipo de logradouro");
		Endereco endereco = new Endereco("08710-040","Rua Doutor Corrêa","145","Centro","Casa 3",MogidasCruzes,Rua,Casa);
		
		Departamento comercial = new Departamento("Departamento comercial");
		Pessoa Fernando = new Pessoa("Fernando Rodrigues");
		Usuario rodrigues = new Usuario("fernando_rodrigues","1234",Fernando);
		Pessoa Roger = new Pessoa("Roger Augusto");
		TipoTelefone celular = new TipoTelefone("Celular");
		Telefone telefone_roger = new Telefone("11","9498785642","55",celular);
		Contato contatof1 = new Contato("rogeraugusto@hotmail.com","Roger Augusto",comercial,telefone_roger);
				
		Produto p1 = new Produto(10,"Peças remanufaturadas","Jorge");
		
		Empresa empresa = new Empresa();
		
		TipoFornecimento tipoFornecimento = new TipoFornecimento();
		CNAE cnae = new CNAE("47895628");
		
		Fornecedor fornecedor1 = new Fornecedor(1,"fornecedor@gmail.com","39728458000190","589748654","14629847259","Fornecimento de Mercadorias","Fornecedor 1.0",endereco,telefone_roger,empresa,p1,tipoFornecimento,cnae);
		System.out.printf("\nData de cadastro: %s ", fornecedor1.getDtCadastro());
		fornecedor1.addContato(contatof1);
		fornecedor1.salvar();
		System.out.printf("\nDados: %s ", fornecedor1.consultar());
		
	}

}
