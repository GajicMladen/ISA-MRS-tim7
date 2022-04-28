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
public class CottageOwner extends Userr {


	
	
	@OneToMany(mappedBy = "cottageOwner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Cottage> cottages = new HashSet<Cottage>();
	
	public CottageOwner(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon);
		// TODO Auto-generated constructor stub
	}
	
	public CottageOwner() {
		super();
	}
}
