package tim7.ISAMRSproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
	@Column(name= "ulica")
	public String ulica;
	
	@Column(name= "broj")
	public String broj;
	
	@Column(name = "mesto")
	public String mesto;
	
	@Column(name = "drzava")
	public String drzava;
	
	@OneToOne(mappedBy = "adresaStanovanja")
    private Korisnik korisnik;

	@OneToOne(mappedBy = "adresaUsluge")
    private Usluga usluga;
}
