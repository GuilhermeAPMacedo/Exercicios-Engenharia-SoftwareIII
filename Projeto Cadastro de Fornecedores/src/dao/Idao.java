package dao;

import java.sql.SQLException;
import java.util.List;
import domain.*;

public interface Idao {
	public void salvar(Dominio entidade) throws SQLException;
	public void alterar(Dominio entidade)throws SQLException;
	public void excluir(Dominio entidade)throws SQLException;
	public List<Dominio> consultar(Dominio entidade)throws SQLException;
	
}
