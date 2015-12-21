package dao;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import entities.Cliente;

public class ClienteDao extends BaseDaoImpl<Cliente, Integer>{
	
	public ClienteDao(ConnectionSource connectionSource)
      throws SQLException {
        super(connectionSource, Cliente.class);
    }
	
	public Cliente findByMatricula(int Matricula){
		try {
			return queryForId(Matricula);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
