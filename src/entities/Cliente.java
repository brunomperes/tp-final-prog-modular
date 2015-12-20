package entities;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import dao.ClienteDao;

@DatabaseTable(daoClass = ClienteDao.class)
public class Cliente {

	@DatabaseField(id = true)
	private int id;
	@DatabaseField
	private String nome;
	@DatabaseField
	private String rg;
	@DatabaseField
	private Date dataNascimento;
	@DatabaseField
	private String telefone;
	@DatabaseField
	private String email;

	public Cliente(){
		
	}
	
	public Cliente(String nome, String rg, Date dataNascimento, String telefone, String email){
		this.nome = nome;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public int getId() {
		return id;
	}
}
