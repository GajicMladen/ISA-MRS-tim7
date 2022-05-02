package tim7.ISAMRSproject.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Admin extends User {


	public Admin() {
	}

	public Admin(Integer id, String username, String password, String email,String name, String lastName, String phone) {
		super(id, username,email, password, name, lastName, phone);
		// TODO Auto-generated constructor stub
	}

}
