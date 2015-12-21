package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import entities.ItemOrcamento;
import entities.OrdemDeServico;

public class ItemOrcamentoDao extends BaseDaoImpl<ItemOrcamento, Integer> implements BasicOperationsDao{
	
	public ItemOrcamentoDao(ConnectionSource connectionSource)
      throws SQLException {
        super(connectionSource, ItemOrcamento.class);
    }
	
	public List<ItemOrcamento> findAllItemsFromOS(OrdemDeServico os){
		List<ItemOrcamento> lista = new ArrayList<ItemOrcamento>();
		try {
			QueryBuilder<ItemOrcamento, Integer> qb = queryBuilder();
			lista = qb.where().eq("ordemDeServico_id", os.getId()).query();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
