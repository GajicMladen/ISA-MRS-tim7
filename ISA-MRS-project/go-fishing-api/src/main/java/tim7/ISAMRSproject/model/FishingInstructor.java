package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("IP")
public class FishingInstructor extends User {

	@OneToMany(mappedBy = "fishingInstructor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Adventure> adventures = new HashSet<Adventure>();


	public FishingInstructor() {
	}


	public FishingInstructor(Integer id, String username, String password, String email,String name, String lastName, String phone) {
		super(id, username,email, password, name, lastName, phone);
		// TODO Auto-generated constructor stub
	}

}
