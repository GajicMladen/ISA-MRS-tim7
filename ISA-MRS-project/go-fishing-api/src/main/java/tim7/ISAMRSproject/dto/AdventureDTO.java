package tim7.ISAMRSproject.dto;

import tim7.ISAMRSproject.model.Adventure;

public class AdventureDTO {
	
	private Integer id;
	private String name;
	private String promoDescription;
	private float price;
	private int capacity;

	private Integer instructorId;
	private String instructorBiography;
	
	public AdventureDTO() {
	
	}
	
	public AdventureDTO(Adventure adventure) {
		this.id = adventure.getId();
		this.name = adventure.getName();
		this.promoDescription = adventure.getPromoDescription();
		this.price = adventure.getPrice();
		this.capacity = adventure.getCapacity();
		this.instructorId = adventure.getInstructorId();
		this.instructorBiography = adventure.getInstructorBiography();
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

	public Integer getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorBiography() {
		return instructorBiography;
	}

	public void setInstructorBiography(String instructorBiography) {
		this.instructorBiography = instructorBiography;
	}
	
	
}
