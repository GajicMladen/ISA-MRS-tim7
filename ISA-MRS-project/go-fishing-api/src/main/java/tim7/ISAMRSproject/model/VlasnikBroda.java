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
public class VlasnikBroda extends Korisnik{

	@OneToMany(mappedBy = "vlasnikBroda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Brod> brodovi = new HashSet<Brod>();
	


	public VlasnikBroda(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon);
		// TODO Auto-generated constructor stub
	}
}
