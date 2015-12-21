package entities;

import java.util.Date;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import dao.OrdemDeServicoDao;

@DatabaseTable(daoClass = OrdemDeServicoDao.class)
public class OrdemDeServico {
	
	//	Lista de status
	public enum STATUS {
		_UNUSED_, CADASTRADA, AGUARDANDO_ORCAMENTO, AGUARDANDO_APROVACAO, APROVADA, EM_ANDAMENTO, CONCLUIDA, EM_COBRANCA, ENCERRADA, CANCELADA
	}

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(foreign = true, foreignAutoRefresh = true)
	private Cliente cliente;
	@DatabaseField(foreign = true, foreignAutoRefresh = true)
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
			String especialidade, String descricao, Date validade) {
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.especialidade = especialidade;
		this.descricao = descricao;
		this.status = STATUS.AGUARDANDO_ORCAMENTO.ordinal();
		this.validade = validade;
	}

	public OrdemDeServico(Cliente cliente,
			String especialidade, String descricao, Date validade) {
		this.cliente = cliente;
		this.especialidade = especialidade;
		this.descricao = descricao;
		this.status = STATUS.CADASTRADA.ordinal();
		this.validade = validade;
	}
	
	public boolean canGoTo(STATUS destinationStatus){
		if (this.status == STATUS.CADASTRADA.ordinal() && destinationStatus == STATUS.AGUARDANDO_ORCAMENTO){
			return true;
		}
		if (this.status == STATUS.CADASTRADA.ordinal() && destinationStatus == STATUS.CANCELADA){
			return true;
		}
		if (this.status == STATUS.AGUARDANDO_ORCAMENTO.ordinal() && destinationStatus == STATUS.AGUARDANDO_APROVACAO){
			return true;
		}
		if (this.status == STATUS.AGUARDANDO_APROVACAO.ordinal() && destinationStatus == STATUS.CANCELADA){
			return true;
		}
		if (this.status == STATUS.AGUARDANDO_APROVACAO.ordinal() && destinationStatus == STATUS.APROVADA){
			return true;
		}
		if (this.status == STATUS.APROVADA.ordinal() && destinationStatus == STATUS.EM_ANDAMENTO){
			return true;
		}
		if (this.status == STATUS.EM_ANDAMENTO.ordinal() && destinationStatus == STATUS.CONCLUIDA){
			return true;
		}
		if (this.status == STATUS.CONCLUIDA.ordinal() && destinationStatus == STATUS.EM_COBRANCA){
			return true;
		}
		if (this.status == STATUS.EM_COBRANCA.ordinal() && destinationStatus == STATUS.ENCERRADA){
			return true;
		}
		return false;
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
		if (this.status == STATUS.CADASTRADA.ordinal()){
			this.status = STATUS.AGUARDANDO_ORCAMENTO.ordinal();
		}
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
	
	public static double getValorImpostoNoOrcamento(List<ItemOrcamento> listaItems){
		double valorImposto = 0;
		for (ItemOrcamento itemOrcamento : listaItems) {
			if (itemOrcamento.isGeraImposto()){
				valorImposto += itemOrcamento.getValorTotal() * ItemOrcamento.PORCENTAGEM_IMPOSTO_SERVICO;
			} 
		}
		return valorImposto;
	}
	
	/**
	 * Ja inclui imposto
	 * @return
	 */
	public static double getValorTotalOrcamento(List<ItemOrcamento> listaItems){
		double total = 0;
		for (ItemOrcamento itemOrcamento : listaItems) {
			total += itemOrcamento.getValorTotal();
			if (itemOrcamento.isGeraImposto()){
				total += itemOrcamento.getValorTotal() * ItemOrcamento.PORCENTAGEM_IMPOSTO_SERVICO;
			} 
		}
		return total;
	}
	
}
