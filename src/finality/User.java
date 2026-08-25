package finality;

// import
import javax.persistence.*;



@Entity
public class User {
	
	@GeneratedValue( strategy = GenerationType.AUTO) // Auto Incremented
	@Id 
	private int id;
	
	@Column(name="UserName") // optional
	private String Name; // Small attribute
	
	@Column(name="Password_User") // optional
	private int Password;
	
	
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



	public int getPassword() {
		return Password;
	}



	public void setPassword(int password) {
		Password = password;
	}



	public User() {}
	
	public User(String Name , int Password) {
		
		this.Name = Name;
		this.Password = Password;
		
		
	}

}
