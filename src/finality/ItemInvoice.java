package finality;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class ItemInvoice implements Serializable{
	
	
	@Id
	@Column(name="item_id")
	private int id;
	
	
	
	@Id
	@Column(name= "voice_id")
	private int invoiceId;
	
	
	private int qty;
	private double price; // حسب الي فهمت ان مرات السعر بيتغير في المنتج الواحد
	
	
	public int getId() {
		return id;
	}
	public void setItemId(int id) {
		this.id = id;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoceId) {
		this.invoiceId = invoceId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	
		
}
