package steveonjava.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Bill implements Serializable {

	private static final long serialVersionUID = 3278687307859250132L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String billNumber;
    
	@OneToMany
	@JoinColumn(name = "billId")
	private List<BillPosition> billPositions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public List<BillPosition> getBillPositions() {
		return billPositions;
	}

	public void setBillPositions(List<BillPosition> billPositions) {
		this.billPositions = billPositions;
	}
}
