package entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import dao.FuncionarioDao;

@DatabaseTable(daoClass = FuncionarioDao.class)
public class Funcionario {
	
	@DatabaseField(id = true)
	private int id;
	@DatabaseField
	private String nome;
	@DatabaseField
	private String telefone;
	@DatabaseField
	private String email;
	@DatabaseField
	private String especialidade;
	
	public Funcionario(){
		
	}
}
