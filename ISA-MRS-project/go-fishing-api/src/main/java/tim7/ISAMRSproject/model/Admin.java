package tim7.ISAMRSproject.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Admin extends Userr {


	public Admin() {
	}

	public Admin(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon) {
		super(id, korisnickoIme, lozinka, ime, prezime, telefon);
		// TODO Auto-generated constructor stub
	}

}
