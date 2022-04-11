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
public class VlasnikVikendice extends Korisnik {


	@OneToMany(mappedBy = "vlasnikVikendice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Vikendica> vikendice = new HashSet<Vikendica>();
	
	public VlasnikVikendice(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon);
		// TODO Auto-generated constructor stub
	}

}
