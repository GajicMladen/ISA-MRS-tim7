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
public class Client extends Userr {
	
	@Column(name="penalCount")
	private int penalCount;
	
	@Column(name = "suspended")
	private boolean suspended;
	

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Reservation> reservations = new HashSet<Reservation>();
	

/*
	@OneToMany(mappedBy = "klijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Complaint> zalbae = new HashSet<Complaint>();
*/

	public Client() {
	}

	public Client(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon);
		// TODO Auto-generated constructor stub
	}

}
