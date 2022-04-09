package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class DodatnaUsluga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column
	private String opis;
	
	@ManyToMany
	@JoinTable(name = "dodatneUsluge", joinColumns = @JoinColumn(name = "dodatnaUsluga_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "usluga_id", referencedColumnName = "id"))
	private Set<Usluga> usluge = new HashSet<Usluga>();
	

	
	public DodatnaUsluga() {
		super();
	}

	public DodatnaUsluga(Integer id, String naziv, String opis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
}
