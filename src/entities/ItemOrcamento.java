package entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import dao.ItemOrcamentoDao;

@DatabaseTable(daoClass = ItemOrcamentoDao.class)
public class ItemOrcamento {
	
	@DatabaseField(id = true)
	private int id;
	@DatabaseField(foreign = true)
	private OrdemDeServico ordemServico;
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
}
