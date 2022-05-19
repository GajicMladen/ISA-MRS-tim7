package tim7.ISAMRSproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
	@Column(name= "street", nullable = false)
	private String street;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@OneToOne(mappedBy = "livingAddress", optional = true)
    private User user;

	@OneToOne(mappedBy = "address", optional = true)
    private Offer offer;
	
	public Address() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	@Override
    public boolean equals(Object o) {
 
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Address)) {
            return false;
        }
         
        Address a = (Address) o;
         
        return (a.getCity().equals(this.getCity()) && 
        		a.getCountry().equals(this.getCountry()) && 
        		a.getStreet().equals(this.getStreet()));
    }
}
