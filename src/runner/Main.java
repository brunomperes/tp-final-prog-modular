package runner;

import java.sql.SQLException;
import java.util.Date;

import ui.MenuInicial;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import dao.ClienteDao;
import dao.FuncionarioDao;
import entities.Cliente;
import entities.Funcionario;
import entities.ItemOrcamento;
import entities.OrdemDeServico;

public class Main {
	
	public static JdbcConnectionSource connectionSource;
	public static ClienteDao clienteDao;
	public static FuncionarioDao funcionarioDao;
        
	public static void main(String[] args) throws SQLException {
		
		// h2 by default but change to match your database
		String databaseUrl = "jdbc:h2:mem:account";
		connectionSource = new JdbcConnectionSource(
				databaseUrl);

		// instantiate the dao with the connection source
		clienteDao = new ClienteDao(connectionSource);
		funcionarioDao = new FuncionarioDao(connectionSource);
		
		createDbTables();

		// create an instance of Account
		Cliente account = new Cliente("asdf", "124131324", new Date(), "3333-3333", "cliente@email.com");

		// persist the account object to the database
		clienteDao.create(account);
		
		//Client Sample Test <<MOISES>>

		// destroy the data source which should close underlying connections
		connectionSource.close();
                
        new MenuInicial().setVisible(true);
        
	}
	
	public static void createDbTables() throws SQLException{
		
		TableUtils.createTable(connectionSource, Cliente.class);
		TableUtils.createTable(connectionSource, Funcionario.class);
		TableUtils.createTable(connectionSource, ItemOrcamento.class);
		TableUtils.createTable(connectionSource, OrdemDeServico.class);
		
	}

}
