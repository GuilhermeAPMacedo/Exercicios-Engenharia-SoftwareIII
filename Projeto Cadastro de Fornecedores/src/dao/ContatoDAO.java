package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import domain.*;

public class ContatoDAO extends DadosDAO{
	public ContatoDAO(Connection cx){
		super(cx, "tb_contato", "id_cont");
	}
	
	public ContatoDAO(){
		super("tb_contato", "id_cont");			
	}
	
	public void salvar(Dominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Contato cont = (Contato)entidade;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_contato(nome,email, departamento,telefone,dt_cadastro)");
		sql.append(" VALUES (?, ?, ?, ?, ?)");
		
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(3, cont.getNome());
			pst.setString(1, cont.getEmail());
			pst.setString(2, cont.getDepartamento().getDescricao());	
			pst.setString(1, cont.getTelefone().getNumero());
			Timestamp time = new Timestamp(cont.getDtCadastro().getTime());
			pst.setTimestamp(7, time);
			
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			cont.setId(idEnd);
			
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
