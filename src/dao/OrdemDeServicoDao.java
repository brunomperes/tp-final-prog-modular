package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import entities.OrdemDeServico;

public class OrdemDeServicoDao  extends BaseDaoImpl<OrdemDeServico, Integer> implements BasicOperationsDao{
	
	public OrdemDeServicoDao(ConnectionSource connectionSource)
      throws SQLException {
        super(connectionSource, OrdemDeServico.class);
    }

	public List<OrdemDeServico> findFuncionarioOrdemDeServico(Integer funcionarioId){
		List<OrdemDeServico> lista = new ArrayList<OrdemDeServico>();
		try {
			QueryBuilder<OrdemDeServico, Integer> qb = queryBuilder();
			lista = qb.where().eq("funcionario_id", funcionarioId).or().isNull("funcionario_id").query();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<OrdemDeServico> findClienteOrdemDeServico(Integer clienteId){
		List<OrdemDeServico> lista = new ArrayList<OrdemDeServico>();
		try {
			QueryBuilder<OrdemDeServico, Integer> qb = queryBuilder();
			lista = qb.where().eq("cliente_id", clienteId).query();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void invalidateExpiredOrcamentos(){
		//TODO
	}

}
