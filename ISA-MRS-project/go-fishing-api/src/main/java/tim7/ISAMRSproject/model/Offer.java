package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Offer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "name",unique = true)
	private String name;

	@Column(name = "promoDescription",columnDefinition = "TEXT")
	private String promoDescription;
	/*
	@Column(name = "slike")
	private List<String> slike;
	
	@Column(name = "pravilaPonasanja")
	private List<String> pravilaPonasanja;
	*/
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "capacity")
	private int capacity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address" ,referencedColumnName = "id")
	private Address address;

	@ManyToMany(mappedBy = "offers")
	private Set<ExtraFavor> extraFavors = new HashSet<ExtraFavor>();

	@OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<FreePeriod> freePeriods = new HashSet<FreePeriod>();
	
	@OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	@OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Action> actions = new HashSet<Action>();
	
	
	
	public Offer() {
		super();
	}

	public Offer(Integer id, String name, String promoDescription, float price, int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.promoDescription = promoDescription;
//		this.slike = slike;
//		this.pravilaPonasanja = pravilaPonasanja;
		this.price = price;
		this.capacity = capacity;
	}
	
	public Offer(Offer offer) {
		super();
		this.id = offer.id;
		this.name = offer.name;
		this.promoDescription = offer.promoDescription;
//		this.slike = offer.slike;
//		this.pravilaPonasanja = offer.pravilaPonasanja;
		this.price = offer.price;
		this.capacity = offer.capacity;
	}
	
	public Set<ExtraFavor> getExtraFavors() {
		return extraFavors;
	}

	public void setExtraFavors(Set<ExtraFavor> extraFavors) {
		this.extraFavors = extraFavors;
	}

	public Set<FreePeriod> getFreePeriods() {
		return freePeriods;
	}

	public void setFreePeriods(Set<FreePeriod> freePeriods) {
		this.freePeriods = freePeriods;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPromoDescription() {
		return promoDescription;
	}
	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

	/*
	
	private float izracunajProsecnuOcena() {
		
	}
	 
	 */


}
