package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import domain.*;

public class UsuarioDAO extends DadosDAO{
	public UsuarioDAO(Connection cx){
		super(cx, "tb_usuario", "id_user");
	}
	
	public UsuarioDAO(){
		super("tb_usuario", "id_user");			
	}
	
	public void salvar(Dominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Usuario user = (Usuario)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tb_usuario(login, senha,dt_cadastro)");
		sql.append(" VALUES (?, ?, ?)");
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getSenha());				
			Timestamp time = new Timestamp(user.getDtCadastro().getTime());
			pst.setTimestamp(7, time);
			
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			user.setId(idEnd);
			
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
