package tim7.ISAMRSproject.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tim7.ISAMRSproject.dto.AdventureDTO;

@Entity
public class Adventure extends Offer {

	@Column(nullable =  false, columnDefinition = "TEXT")
	private String instructorBiography;


	//@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instruktor_id")
	private FishingInstructor fishingInstructor;
	
	
	public Adventure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adventure(Integer id, String naziv, String promoOpis, List<String> slike, List<String> pravilaPonasanja,
					 float cena, int kapacitet) {
		super(id, naziv, promoOpis, cena, kapacitet);
		// TODO Auto-generated constructor stub
	}
	
	public Adventure(AdventureDTO dto, User fishingInstructor) {
		super(10, dto.getName(), dto.getPromoDescription(), dto.getPrice(), dto.getCapacity());
		this.fishingInstructor = (FishingInstructor) fishingInstructor;
		this.instructorBiography = dto.getInstructorBiography();
	}
	

	public Adventure(String instructorBiografy) {
		super();
		this.instructorBiography = instructorBiografy;
	}

	public String getInstructorBiography() {
		return instructorBiography;
	}

	public void setInstructorBiography(String instructorBiography) {
		this.instructorBiography = instructorBiography;
	}
	
	public Integer getInstructorId() {
		return this.fishingInstructor.getId();
	}
	
	
}
