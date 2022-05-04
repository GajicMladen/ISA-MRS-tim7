package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usluga {
	
	@Id
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen")
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "naziv")
	private String naziv;

	@Column(name = "promoOpis")
	private String promoOpis;
	/*
	@Column(name = "slike")
	private List<String> slike;
	
	@Column(name = "pravilaPonasanja")
	private List<String> pravilaPonasanja;
	*/
	
	@Column(name = "cena")
	private float cena;
	
	@Column(name = "kapacitet")
	private int kapacitet;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresaUsluge" ,referencedColumnName = "id")
	private Adresa adresaUsluge;

	@ManyToMany(mappedBy = "usluge")
	private Set<DodatnaUsluga> dodatneUsluge = new HashSet<DodatnaUsluga>();

	@OneToMany(mappedBy = "usluga", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<SlobodanTermin> slobodniTermini = new HashSet<SlobodanTermin>();
	
	@OneToMany(mappedBy = "usluga", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Rezervacija> rezervacije = new HashSet<Rezervacija>();
	
	@OneToMany(mappedBy = "usluga", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Akcija> akcije = new HashSet<Akcija>();
	
	
	
	public Usluga() {
		super();
	}

	public Usluga(Integer id, String naziv, String promoOpis, List<String> slike, List<String> pravilaPonasanja,
			float cena, int kapacitet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.promoOpis = promoOpis;
//		this.slike = slike;
//		this.pravilaPonasanja = pravilaPonasanja;
		this.cena = cena;
		this.kapacitet = kapacitet;
	}
	
	
	
	public Set<DodatnaUsluga> getDodatneUsluge() {
		return dodatneUsluge;
	}

	public void setDodatneUsluge(Set<DodatnaUsluga> dodatneUsluge) {
		this.dodatneUsluge = dodatneUsluge;
	}

	public Set<SlobodanTermin> getSlobodniTermini() {
		return slobodniTermini;
	}

	public void setSlobodniTermini(Set<SlobodanTermin> slobodniTermini) {
		this.slobodniTermini = slobodniTermini;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getPromoOpis() {
		return promoOpis;
	}
	public void setPromoOpis(String promoOpis) {
		this.promoOpis = promoOpis;
	}
	/*
	public List<String> getSlike() {
		return slike;
	}
	public void setSlike(List<String> slike) {
		this.slike = slike;
	}
	public List<String> getPravilaPonasanja() {
		return pravilaPonasanja;
	}
	public void setPravilaPonasanja(List<String> pravilaPonasanja) {
		this.pravilaPonasanja = pravilaPonasanja;
	}
	*/
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	

	/*
	
	private float izracunajProsecnuOcena() {
		
	}
	 
	 */


}
