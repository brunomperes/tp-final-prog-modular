package dao;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import entities.ItemOrcamento;

public class ItemOrcamentoDao extends BaseDaoImpl<ItemOrcamento, Integer> implements BasicOperationsDao{
	
	public ItemOrcamentoDao(ConnectionSource connectionSource)
      throws SQLException {
        super(connectionSource, ItemOrcamento.class);
    }

}
