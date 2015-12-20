package dao;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import entities.Funcionario;

public class FuncionarioDao  extends BaseDaoImpl<Funcionario, Integer> implements BasicOperationsDao{
	
	public FuncionarioDao(ConnectionSource connectionSource)
      throws SQLException {
        super(connectionSource, Funcionario.class);
    }
	
	public Funcionario findByMatricula(int Matricula){
		try {
			return queryForId(Matricula);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
