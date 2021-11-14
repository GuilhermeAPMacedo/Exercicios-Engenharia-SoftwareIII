package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import domain.*;

public class EnderecoDAO extends DadosDAO{
	public EnderecoDAO(Connection cx){
		super(cx, "tb_endereco", "id_end");
	}
	
	public EnderecoDAO(){
		super("tb_endereco", "id_end");			
	}
	
	public void salvar(Dominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tb_endereco(cidade, estado,pais,bairro,tipoEndereco,tipoLogradouro ");
		sql.append("logradouro, numero, cep, complemento, dt_cadastro) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");	
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, end.getCidade().getDescricao());
			pst.setString(2, end.getCidade().getUf().getSigla());
			pst.setString(3, end.getCidade().getUf().getPais().getDescricao());
			pst.setString(4, end.getBairro());
			pst.setString(5, end.getTipoendereco().getNome());
			pst.setString(6, end.getTipologradouro().getNome());
			pst.setString(7, end.getLogradouro());
			pst.setString(8, end.getNumero());
			pst.setString(9, end.getCep());	
			pst.setString(10, end.getComplemento());				
			Timestamp time = new Timestamp(end.getDtCadastro().getTime());
			pst.setTimestamp(7, time);
			
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
			
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}

	
	@Override
	public void alterar(Dominio entidade) {
	}
	@Override
	public List<Dominio> consultar(Dominio entidade) {
		return null;
	}
}
