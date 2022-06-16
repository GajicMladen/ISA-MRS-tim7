package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Client extends User {
	
	private static final long serialVersionUID = 1L;

	@Column(name="penalCount")
	private int penalCount;
	
	@Column(name = "suspended")
	private boolean suspended;
	

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Reservation> reservations = new HashSet<Reservation>();
	

	@ManyToMany
	@JoinTable(
			name="subscribers",
			joinColumns = @JoinColumn(name = "client_id"),
			inverseJoinColumns = @JoinColumn(name = "offer_id")
	)
	private Set<Offer> subscribedOffers = new HashSet<Offer>();
/*
	@OneToMany(mappedBy = "klijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Complaint> zalbae = new HashSet<Complaint>();
*/

	public Client() {
	}

	public Client(Integer id, String password, String email,String name, String lastName, String phone) {
		super(id, email, password, name, lastName, phone);
		
	}

}
