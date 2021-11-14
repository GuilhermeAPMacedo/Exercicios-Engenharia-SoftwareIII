package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import domain.*;

public class FornecedorDAO extends DadosDAO {
	public FornecedorDAO() {
		super("tb_fornecedor", "id_forn");		
	}
	public void salvar(Dominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		Fornecedor forn = (Fornecedor) entidade;
		Endereco end = forn.getEndereco();
		
		try {
			connection.setAutoCommit(false);			
			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.connection = connection;
			endDAO.ctrlTransaction = false;
			endDAO.salvar(entidade);;			
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_fornecedor(Email,Cnpj,ID,InscricaoEstadual,InscricaoMunicipal,RzSocial,NmFantasia,DDD,Numero,Tipo,Produto,Fornecimento,Status,CNAE,Contato, ");
			sql.append("dtCadastro) VALUES ()");		
					
			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, forn.getEmail());
			pst.setString(2, forn.getCnpj());
			pst.setInt(3, forn.getId());
			pst.setString(4, forn.getInscricaoEstadual());	
			pst.setString(5, forn.getInscricaoMunicipal());
			pst.setString(6, forn.getRzSocial());
			pst.setString(7, forn.getNmFantasia());
			pst.setString(8, forn.getTelefone().getDDD());
			pst.setString(9, forn.getTelefone().getNumero());	
			pst.setString(10, forn.getEmpresa().getTipoEmpresa().matriz);
			pst.setString(11, forn.getProduto().getNome());
			pst.setString(12, forn.getTipoFornecimento().servico);
			pst.setString(13, forn.getStatus());
			pst.setString(14, forn.getCnae().getNumero());
			pst.setString(15, forn.getContato().getNome());
			Timestamp time = new Timestamp(forn.getDtCadastro().getTime());
			pst.setTimestamp(5, time);
			pst.executeUpdate();			
			connection.commit();		
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		

	}
	@Override
	public void alterar(Dominio entidade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Dominio> consultar(Dominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
