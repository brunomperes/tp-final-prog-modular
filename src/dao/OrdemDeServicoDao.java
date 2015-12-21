package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import entities.OrdemDeServico;

public class OrdemDeServicoDao  extends BaseDaoImpl<OrdemDeServico, Integer> implements BasicOperationsDao{
	
	public OrdemDeServicoDao(ConnectionSource connectionSource)
      throws SQLException {
        super(connectionSource, OrdemDeServico.class);
    }
	
	public List<OrdemDeServico> findUserAndOpenOrdemDeServico(int userId){
		List<OrdemDeServico> lista = new ArrayList<OrdemDeServico>();
		try {
			lista = queryBuilder().where().eq("funcionario_id", userId).or().isNull("funcionario_id").query();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
