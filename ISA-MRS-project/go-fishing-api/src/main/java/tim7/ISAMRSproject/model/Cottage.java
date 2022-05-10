package tim7.ISAMRSproject.model;

import tim7.ISAMRSproject.dto.CottageDTO;

import javax.persistence.*;

@Entity
public class Cottage extends Offer {
		

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private CottageOwner cottageOwner;

	@Column(name = "roomCount" , nullable = false)
	private int roomCount;

	@Column(name = "bedCount" , nullable = false)
	private int bedCount;

	public Cottage(){

	}

	public Cottage(CottageDTO cottageDTO){
		super(cottageDTO.getId(), cottageDTO.getName(), cottageDTO.getPromoDescription(), null,null, cottageDTO.getPrice(), cottageDTO.getCapacity());
		roomCount = cottageDTO.getRoomCount();
		bedCount = cottageDTO.getBedCount();
	}
	
	public int getCottageOwnerId(){
		return cottageOwner.getId() != null ? cottageOwner.getId() : 1;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public CottageOwner getCottageOwner() {
		return cottageOwner;
	}

	public void setCottageOwner(CottageOwner cottageOwner) {
		this.cottageOwner = cottageOwner;
	}
}
