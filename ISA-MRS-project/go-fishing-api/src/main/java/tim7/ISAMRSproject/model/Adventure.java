package tim7.ISAMRSproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Adventure extends Offer {

	@Column(nullable =  false)
	private String instructorBiography;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "instruktor_id")
	private FishingInstructor fishingInstructor;
	
	
	public Adventure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adventure(Integer id, String naziv, String promoOpis, List<String> slike, List<String> pravilaPonasanja,
					 float cena, int kapacitet) {
		super(id, naziv, promoOpis, slike, pravilaPonasanja, cena, kapacitet);
		// TODO Auto-generated constructor stub
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
	
	
	
	
}
