package tim7.ISAMRSproject.model;

import tim7.ISAMRSproject.dto.CottageDTO;

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

	public Cottage(CottageDTO cottageDTO){
		super(cottageDTO.getId(), cottageDTO.getName(), cottageDTO.getPromoDescription(), null,null, cottageDTO.getPrice(), cottageDTO.getCapacity());

	}
	
	public int getCottageOwnerId(){
		return cottageOwner.getId() != null ? cottageOwner.getId() : 1;
	}

	public CottageOwner getCottageOwner() {
		return cottageOwner;
	}

	public void setCottageOwner(CottageOwner cottageOwner) {
		this.cottageOwner = cottageOwner;
	}
}
