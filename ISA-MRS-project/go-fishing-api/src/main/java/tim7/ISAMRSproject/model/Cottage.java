package tim7.ISAMRSproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cottage extends Offer {
		

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private CottageOwner cottageOwner;

	public Cottage(){

	}
	
	public int getCottageOwnerId(){
		return cottageOwner.getId() != null ? cottageOwner.getId() : 1;
	}
	
}
