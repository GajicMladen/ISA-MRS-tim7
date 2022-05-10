package tim7.ISAMRSproject.dto;

import tim7.ISAMRSproject.model.Cottage;

public class CottageDTO {

	private Integer id;
	private String name;
	private String promoDescription;
	private float price;
	private int capacity;

	private int bedCount;
	private int roomCount;

	private Integer ownerId;


	
	public CottageDTO() {
		
		
	}
	
	public CottageDTO(Cottage cottage) {
		
		id = cottage.getId();
		name = cottage.getName();
		promoDescription = cottage.getPromoDescription();
		price = cottage.getPrice();
		capacity = cottage.getCapacity();
		ownerId = cottage.getCottageOwnerId();
		roomCount = cottage.getRoomCount();
		bedCount = cottage.getBedCount();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer idI) {
		this.id = idI;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public Integer getOwnerId() {
		return  ownerId;
	}
	public void setOwnerId(Integer idI) {
		this.ownerId = idI;
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
	
	
}
