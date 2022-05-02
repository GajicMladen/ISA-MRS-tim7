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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
	@Column(name= "street")
	public String street;
	
	@Column(name= "houseNumber")
	public String houseNumber;
	
	@Column(name = "city")
	public String city;
	
	@Column(name = "country")
	public String country;
	
	@OneToOne(mappedBy = "livingAddress")
    private User user;

	@OneToOne(mappedBy = "address")
    private Offer offer;
}
