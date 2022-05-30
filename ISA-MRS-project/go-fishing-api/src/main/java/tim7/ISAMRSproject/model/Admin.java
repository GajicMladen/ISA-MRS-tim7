package tim7.ISAMRSproject.model;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

	private static final long serialVersionUID = 1L;

	public Admin() {
	}

	public Admin(Integer id, String password, String email,String name, String lastName, String phone) {
		super(id, email, password, name, lastName, phone);
	}

}
