package tim7.ISAMRSproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cottage extends Offer {
		

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vlasnik_id")
	private CottageOwner cottageOwner;

	public Cottage(){

	}
	public Cottage(Offer offer) {
		super(offer);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
