package finality;

// Invoice Table

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class InvoiceT {

	@Id
	@GeneratedValue  // Auto Increment
	private int id;
	
	
	
	// costumer
	private String costumer;
	
	
	private Date date;
	
	//
	private double TotalPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}
	
	public InvoiceT(){}
	
	public InvoiceT(int Total){}

	public void setCostumer(String costumer) {
		this.costumer = costumer;
		
	}

	public String getCostumer() {
		return costumer;
	}

	
	
	
}
