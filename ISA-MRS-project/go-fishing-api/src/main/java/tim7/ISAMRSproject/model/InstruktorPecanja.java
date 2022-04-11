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
public class InstruktorPecanja extends Korisnik{

	@OneToMany(mappedBy = "instruktorPecanja", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Avantura> avanture = new HashSet<Avantura>();
	
	
	
	public InstruktorPecanja(Long id, String korisnickoIme, String lozinka, String ime, String prezime,
			String telefon) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon);
		// TODO Auto-generated constructor stub
	}

}