package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("VV")
public class CottageOwner extends User {


	
	
	@OneToMany(mappedBy = "cottageOwner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Cottage> cottages = new HashSet<Cottage>();

	public CottageOwner(Integer id, String username, String password, String email,String name, String lastName, String phone) {
		super(id, username,email, password, name, lastName, phone);
		// TODO Auto-generated constructor stub
	}
	
	public CottageOwner() {
	}
}
