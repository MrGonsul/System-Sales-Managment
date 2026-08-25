package finality;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="Items") //optional
public class Item {

	
	@Id 
	private int id;
	@Column(name="Item_Name") // optional
	
	private String Name;
	private int Quantity;
	private double Sellprice;
	
	
	private boolean deleted;
	private double Buyprice;

	
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Item() {}
	
	public Item(int id ,String Name,int Quantity,double Buyprice,double Sellprice,boolean deleted) {
		this.id = id;
		this.Name = Name;
		this.Quantity = Quantity;
		this.deleted = deleted;
		this.Buyprice = Buyprice;
		this.Sellprice = Sellprice;
		
		
	}

	public void setSellprice(double sellprice) {
		Sellprice = sellprice;
	}

	public double getSellprice() {
		return Sellprice;
	}

	public void setBuyprice(double buyprice) {
		Buyprice = buyprice;
	}

	public double getBuyprice() {
		return Buyprice;
	}
	
	
	@Transient
	 // Method Calc The Total
	public Double getTotalPrice() {
		return (this.Sellprice*this.Quantity);
	}

	

}
