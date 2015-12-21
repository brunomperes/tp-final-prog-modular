package entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import dao.ItemOrcamentoDao;

@DatabaseTable(daoClass = ItemOrcamentoDao.class)
public class ItemOrcamento {
	
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(foreign = true, foreignAutoRefresh = true)
	private OrdemDeServico ordemDeServico;
	@DatabaseField
	private double valorUnitario;
	@DatabaseField
	private double quantidade;
	@DatabaseField
	private String descricao;
	@DatabaseField
	private boolean geraImposto;
	
	public ItemOrcamento(){
		
	}

	public ItemOrcamento(OrdemDeServico ordemServico, double valorUnitario,
			double quantidade, String descricao, boolean geraImposto) {
		super();
		this.ordemDeServico = ordemServico;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.geraImposto = geraImposto;
	}

	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(OrdemDeServico ordemServico) {
		this.ordemDeServico = ordemServico;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isGeraImposto() {
		return geraImposto;
	}

	public void setGeraImposto(boolean geraImposto) {
		this.geraImposto = geraImposto;
	}

	public int getId() {
		return id;
	}

	public double getValorTotal() {
		return quantidade * valorUnitario;
	}
}
