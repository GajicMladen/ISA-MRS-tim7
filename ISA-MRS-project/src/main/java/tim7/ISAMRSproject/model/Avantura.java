package tim7.ISAMRSproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avantura extends Usluga{

	@Column(nullable =  false)
	private String biografijaInstruktora;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "instruktor_id")
	private InstruktorPecanja instruktorPecanja;
	
	
	public Avantura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avantura(Integer id, String naziv, String promoOpis, List<String> slike, List<String> pravilaPonasanja,
			float cena, int kapacitet) {
		super(id, naziv, promoOpis, slike, pravilaPonasanja, cena, kapacitet);
		// TODO Auto-generated constructor stub
	}
	
	

	public Avantura(String biografijaInstruktora) {
		super();
		this.biografijaInstruktora = biografijaInstruktora;
	}

	public String getBiografijaInstruktora() {
		return biografijaInstruktora;
	}

	public void setBiografijaInstruktora(String biografijaInstruktora) {
		this.biografijaInstruktora = biografijaInstruktora;
	}
	
	
	
	
}
