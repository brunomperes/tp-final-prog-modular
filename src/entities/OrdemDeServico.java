package entities;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import dao.OrdemDeServicoDao;

@DatabaseTable(daoClass = OrdemDeServicoDao.class)
public class OrdemDeServico {

	@DatabaseField(id = true)
	private int id;
	@DatabaseField(foreign = true)
	private Cliente cliente;
	@DatabaseField(foreign = true)
	private Funcionario funcionario;
	@DatabaseField
	private String especialidade;
	@DatabaseField
	private String descricao;
	@DatabaseField
	private int status;
	@DatabaseField
	private Date validade;
	
	public OrdemDeServico(){
		
	}
}
