package runner;

import java.util.Date;
import java.sql.SQLException;
import java.util.Date;

import ui.MenuInicial;

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
		Cliente account = new Cliente("asdf", "124131324", new Date(), "3333-3333", "cliente@email.com");

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
		Funcionario jorge = new Funcionario("Jorge Mario","111111","@jorgemario", "Encanador");
		funcionarioDao.create(jorge);
		Funcionario joao = new Funcionario("Joao Nascimento","111111","@joaonascimento", "Pedreiro");
		funcionarioDao.create(joao);
		Funcionario altair = new Funcionario("Ailtair Ribeiro","111111","@altairribeiro", "Eletricista");
		funcionarioDao.create(altair);
		Funcionario valdeci = new Funcionario("Valdeci Silva","111111","@helton", "Mecanico");
		funcionarioDao.create(valdeci);
		
		//OS Sample Test <<MOISES>>
		OrdemDeServico os1 = new OrdemDeServico(moises,jorge,"Encanador","Reparo da Caixa D`agua",new Date());
		ordemdeservicoDao.create(os1);
		OrdemDeServico os2 = new OrdemDeServico(lais,joao,"Pedreiro","Reparo do Telhado",new Date());
		ordemdeservicoDao.create(os2);
		
		//Orcamento Sample Test <<MOISES>>
		ItemOrcamento orcamentoOS1 = new ItemOrcamento (os1, 10,7,"Cano PVC",false);
		itemorcamentoDao.create(orcamentoOS1);
		orcamentoOS1 = new ItemOrcamento (os1, 5,2,"Fita Teflon",false);
		itemorcamentoDao.create(orcamentoOS1);
		orcamentoOS1 = new ItemOrcamento (os1, 10,4,"Mao de obra (R$/Hora)",false);
		itemorcamentoDao.create(orcamentoOS1);
		
		ItemOrcamento orcamentoOS2 = new ItemOrcamento (os2, 30,2,"Telhas",false);
		itemorcamentoDao.create(orcamentoOS2);
		orcamentoOS2 = new ItemOrcamento (os2, 10,1,"Areia",false);
		itemorcamentoDao.create(orcamentoOS2);
		orcamentoOS2 = new ItemOrcamento (os2, 20,1,"Cimento",false);
		itemorcamentoDao.create(orcamentoOS2);
		orcamentoOS2 = new ItemOrcamento (os2, 20,5,"Mao de obra (R$/Hora",false);
		itemorcamentoDao.create(orcamentoOS2);
		//========================================
		//END - SAMPLE DATA FOR TEST
		//=======================================
		
		
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
