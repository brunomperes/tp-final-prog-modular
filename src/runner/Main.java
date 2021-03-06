package runner;

import java.sql.SQLException;
import java.util.Calendar;
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
	
	public static JdbcConnectionSource connectionSource;
	public static ClienteDao clienteDao;
	public static FuncionarioDao funcionarioDao;
	public static OrdemDeServicoDao ordemDeServicoDao;
	public static ItemOrcamentoDao itemOrcamentoDao;
	private static Cliente currentCliente;
	private static Funcionario currentFuncionario;
	private static OrdemDeServico currentOS;
	
	private static final boolean USE_MEMORY_DATABASE = false;
	private static final boolean CREATE_MOCK_DATA_IF_EMPTY_DB = true;

	public static void main(String[] args) throws SQLException {
		
		String databaseUrl;
		if (USE_MEMORY_DATABASE){
			databaseUrl = "jdbc:h2:mem:account";
		} else {
			databaseUrl = "jdbc:sqlite:mydatabase.db";
		}
		connectionSource = new JdbcConnectionSource(databaseUrl);

		clienteDao = new ClienteDao(connectionSource);
		funcionarioDao = new FuncionarioDao(connectionSource);
		ordemDeServicoDao = new OrdemDeServicoDao(connectionSource);
		itemOrcamentoDao = new ItemOrcamentoDao(connectionSource);
		
		createDbTables();
		
		if (CREATE_MOCK_DATA_IF_EMPTY_DB){
			if (clienteDao.countOf() == 0){
				createMockData();
			}
		}
                
        new MenuInicial().setVisible(true);
        
	}
	
	public static void loginCliente(Cliente currentCliente){
		Main.currentCliente = currentCliente;
	}
	
	public static void loginFuncionario(Funcionario currentFuncionario){
		Main.currentFuncionario = currentFuncionario;
	}
	
	public static void logout(){
		Main.currentCliente = null;
		Main.currentFuncionario = null;
	}
	
	public static OrdemDeServico getCurrentOS() {
		return currentOS;
	}

	public static void setCurrentOS(OrdemDeServico currentOS) {
		Main.currentOS = currentOS;
	}
	
	public static Cliente getCurrentCliente(){
		return currentCliente;
	}
	
	public static Funcionario getCurrentFuncionario(){
		return currentFuncionario;
	}
	
	public static void closeProgram(){
		// destroy the data source which should close underlying connections
        try {
			connectionSource.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
        System.exit(0);
	}
	
	public static void createDbTables() throws SQLException{
		
		TableUtils.createTableIfNotExists(connectionSource, Cliente.class);
		TableUtils.createTableIfNotExists(connectionSource, Funcionario.class);
		TableUtils.createTableIfNotExists(connectionSource, ItemOrcamento.class);
		TableUtils.createTableIfNotExists(connectionSource, OrdemDeServico.class);
	}
	
	public static void createMockData() throws SQLException{
		//========================================
		//BEGIN - SAMPLE DATA FOR TEST
		//=======================================
		//Client Sample Test <<MOISES>>
		Cliente bruno = new Cliente("BrunoPeres","000000", "111111",new Date(),"111111","@brunoperes");
		clienteDao.create(bruno);
		Cliente moises = new Cliente("MoisePaje","12312300", "222222",new Date(),"222222","@moisesrodrigues");
		clienteDao.create(moises);
		Cliente thiago = new Cliente("ThiagoSandi", "12312300", "333333",new Date(),"333333","@thiagosandi");
		clienteDao.create(thiago);
		Cliente lais = new Cliente("LaisMota", "12312300", "333333",new Date(),"333333","@laismota");
		clienteDao.create(lais);
		
		//TECHNICIAN Sample Test <<MOISES>>
		Funcionario jorge = new Funcionario("Jorge Mario","111111","@jorgemario", "Encanador");
		funcionarioDao.create(jorge);
		Funcionario joao = new Funcionario("Joao Nascimento","111111","@joaonascimento", "Pedreiro");
		funcionarioDao.create(joao);
		Funcionario altair = new Funcionario("Ailtair Ribeiro","111111","@altairribeiro", "Eletricista");
		funcionarioDao.create(altair);
		Funcionario valdeci = new Funcionario("Valdeci Silva","111111","@valdeci", "Mecanico");
		funcionarioDao.create(valdeci);
		
		//OS Sample Test <<MOISES>>
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.MONTH, 1);
		OrdemDeServico os1 = new OrdemDeServico(moises,jorge,"Encanador","Reparo da Caixa D`agua",cal.getTime());
		ordemDeServicoDao.create(os1);
		OrdemDeServico os2 = new OrdemDeServico(lais,joao,"Pedreiro","Reparo do Telhado", cal.getTime());
		ordemDeServicoDao.create(os2);
		OrdemDeServico os3 = new OrdemDeServico(moises,"Bombeiro","Reparo da Caixa D`agua",cal.getTime());
		ordemDeServicoDao.create(os3);
		
		//Orcamento Sample Test <<MOISES>>
		ItemOrcamento orcamentoOS1 = new ItemOrcamento (os1, 10,7,"Cano PVC",false);
		itemOrcamentoDao.create(orcamentoOS1);
		orcamentoOS1 = new ItemOrcamento (os1, 5,2,"Fita Teflon",false);
		itemOrcamentoDao.create(orcamentoOS1);
		orcamentoOS1 = new ItemOrcamento (os1, 10,4,"Mao de obra (R$/Hora)",false);
		itemOrcamentoDao.create(orcamentoOS1);
		
		ItemOrcamento orcamentoOS2 = new ItemOrcamento (os2, 30,2,"Telhas",false);
		itemOrcamentoDao.create(orcamentoOS2);
		orcamentoOS2 = new ItemOrcamento (os2, 10,1,"Areia",false);
		itemOrcamentoDao.create(orcamentoOS2);
		orcamentoOS2 = new ItemOrcamento (os2, 20,1,"Cimento",false);
		itemOrcamentoDao.create(orcamentoOS2);
		orcamentoOS2 = new ItemOrcamento (os2, 20,5,"Mao de obra (R$/Hora",false);
		itemOrcamentoDao.create(orcamentoOS2);
		//========================================
		//END - SAMPLE DATA FOR TEST
		//=======================================
	}

}
