package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("K")
public class Client extends User {
	
	@Column(name="penalCount")
	private int penalCount;
	
	@Column(name = "suspended")
	private boolean suspended;
	

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Reservation> reservations = new HashSet<Reservation>();
	

/*
	@OneToMany(mappedBy = "klijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Complaint> zalbae = new HashSet<Complaint>();
*/

	public Client() {
	}

	public Client(Integer id, String username, String password, String email,String name, String lastName, String phone) {
		super(id, username,email, password, name, lastName, phone);
		// TODO Auto-generated constructor stub
	}

}
