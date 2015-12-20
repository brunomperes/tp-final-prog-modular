package dao;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import entities.OrdemDeServico;

public class OrdemDeServicoDao  extends BaseDaoImpl<OrdemDeServico, Integer> implements BasicOperationsDao{
	
	public OrdemDeServicoDao(ConnectionSource connectionSource)
      throws SQLException {
        super(connectionSource, OrdemDeServico.class);
    }

}
