package steveonjava.server.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BillPosition implements Serializable {

	private static final long serialVersionUID = -3537922349645187154L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
	@ManyToOne
	@JoinColumn(name = "billId")
    private Bill bill;
    
    private String positionText;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getPositionText() {
		return positionText;
	}

	public void setPositionText(String positionText) {
		this.positionText = positionText;
	}       
}
