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

	public Funcionario(String nome, String telefone, String email,
			String especialidade) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.especialidade = especialidade;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public int getId() {
		return id;
	}
}
