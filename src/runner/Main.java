package runner;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import dao.ClienteDao;
import entities.Cliente;

public class Main {
	
	private static JdbcConnectionSource connectionSource;

	public static void main(String[] args) throws SQLException {
		
		// h2 by default but change to match your database
		String databaseUrl = "jdbc:h2:mem:account";
		connectionSource = new JdbcConnectionSource(
				databaseUrl);

		// instantiate the dao with the connection source
		ClienteDao accountDao = new ClienteDao(connectionSource);
		
		createDbTables();

		// create an instance of Account
		Cliente account = new Cliente();

		// persist the account object to the database
		accountDao.create(account);

		// destroy the data source which should close underlying connections
		connectionSource.close();
	}
	
	public static void createDbTables() throws SQLException{
		
		TableUtils.createTable(connectionSource, Cliente.class);
		
	}

}
