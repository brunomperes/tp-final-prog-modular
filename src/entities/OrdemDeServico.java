package entities;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import dao.OrdemDeServicoDao;

@DatabaseTable(daoClass = OrdemDeServicoDao.class)
public class OrdemDeServico {
	
	//	Lista de status
	public enum STATUS {
		CADASTRADA, AGUARDANDO_ORCAMENTO, AGUARDANDO_APROVACAO, APROVADA, EM_ANDAMENTO, CONCLUIDA, EM_COBRANCA, ENCERRADA, CANCELADA
	}

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

	public OrdemDeServico(Cliente cliente, Funcionario funcionario,
			String especialidade, String descricao, int status, Date validade) {
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.especialidade = especialidade;
		this.descricao = descricao;
		this.status = status;
		this.validade = validade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getId() {
		return id;
	}
	
	
}
