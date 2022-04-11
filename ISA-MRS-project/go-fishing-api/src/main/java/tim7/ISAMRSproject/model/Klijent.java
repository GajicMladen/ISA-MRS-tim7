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
public class Klijent extends Korisnik{
	
	@Column(name="brojPenala")
	private int brojPenala;
	
	@Column(name = "suspendovan")
	private boolean suspendovan;
	

	@OneToMany(mappedBy = "klijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Rezervacija> rezervacije = new HashSet<Rezervacija>();
	


	@OneToMany(mappedBy = "klijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Zalba> zalbae = new HashSet<Zalba>();
	

	public Klijent(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon);
		// TODO Auto-generated constructor stub
	}

}
