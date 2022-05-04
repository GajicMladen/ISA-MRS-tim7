package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("VB")
public class BoatOwner extends User {

	@OneToMany(mappedBy = "boatOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Boat> boats = new HashSet<Boat>();


	public BoatOwner() {
	}

	public BoatOwner(Integer id, String username, String password, String email,String name, String lastName, String phone) {
		super(id, username,email, password, name, lastName, phone);
		// TODO Auto-generated constructor stub
	}

}
