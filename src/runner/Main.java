package runner;

import java.util.Date;
import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

import dao.ClienteDao;
import dao.FuncionarioDao;
import dao.ItemOrcamentoDao;
import dao.OrdemDeServicoDao;
import entities.Cliente;
import entities.Funcionario;
import entities.ItemOrcamento;
import entities.OrdemDeServico;

public class Main {
	
	private static JdbcConnectionSource connectionSource;

	public static void main(String[] args) throws SQLException {
		
		// h2 by default but change to match your database
		String databaseUrl = "jdbc:h2:mem:account";
		connectionSource = new JdbcConnectionSource(
				databaseUrl);

		// instantiate the dao with the connection source
		ClienteDao clienteDao = new ClienteDao(connectionSource);
		FuncionarioDao funcionarioDao = new FuncionarioDao(connectionSource);
		OrdemDeServicoDao ordemdeservicoDao = new OrdemDeServicoDao(connectionSource);
		ItemOrcamentoDao itemorcamentoDao = new ItemOrcamentoDao(connectionSource);
		
		createDbTables();

		// create an instance of Account
		Cliente account = new Cliente();

		// persist the account object to the database
		clienteDao.create(account);
		
		//========================================
		//BEGIN - SAMPLE DATA FOR TEST
		//=======================================
		//Client Sample Test <<MOISES>>
		Cliente bruno = new Cliente("BrunoPeres","111111",new Date(),"111111","@brunoperes");
		clienteDao.create(bruno);
		Cliente moises = new Cliente("MoisePaje","222222",new Date(),"222222","@moisesrodrigues");
		clienteDao.create(moises);
		Cliente thiago = new Cliente("ThiagoSandi","333333",new Date(),"333333","@thiagosandi");
		clienteDao.create(thiago);
		Cliente lais = new Cliente("LaisMota","333333",new Date(),"333333","@laismota");
		clienteDao.create(lais);
		
		//TECHNICIAN Sample Test <<MOISES>>
		
		//========================================
		//END - SAMPLE DATA FOR TEST
		//=======================================
		
		
		// destroy the data source which should close underlying connections
		connectionSource.close();
	}
	
	public static void createDbTables() throws SQLException{
		
		TableUtils.createTable(connectionSource, Cliente.class);
		TableUtils.createTable(connectionSource, Funcionario.class);
		TableUtils.createTable(connectionSource, ItemOrcamento.class);
		TableUtils.createTable(connectionSource, OrdemDeServico.class);
		
	}

}
