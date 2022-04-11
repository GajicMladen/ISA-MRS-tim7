package tim7.ISAMRSproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Brod extends Usluga{

	@Column(name = "tipBroda",nullable = false)
	private String TipBroda;
	
	@Column(name = "duzina",nullable = false)
	private float DuzinaBroda;
	
	@Column(name = "brojMotora",nullable = false)
	private int BrojMotora;
	
	@Column(name = "snagaMotora",nullable = false)
	private float SnagaMotora;
	
	@Column(name = "maxBrzina",nullable = false)
	private float MaxBrzina;
	
	@Column(name ="usloviOtkazaRezervacije",nullable = false)
	private String UsloviOtkazaRezervacije;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vlasnik_id")
	private VlasnikBroda vlasnikBroda;
	
	
	public Brod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brod(Integer id, String naziv, String promoOpis, List<String> slike, List<String> pravilaPonasanja, float cena,
			int kapacitet) {
		super(id, naziv, promoOpis, slike, pravilaPonasanja, cena, kapacitet);
	}

	public Brod(Integer id, String naziv, String promoOpis, List<String> slike, List<String> pravilaPonasanja, float cena,
			int kapacitet,String tipBroda, float duzinaBroda, int brojMotora, float snagaMotora, float maxBrzina,
			String usloviOtkazaRezervacije) {
		super(id, naziv, promoOpis, slike, pravilaPonasanja, cena, kapacitet);
		TipBroda = tipBroda;
		DuzinaBroda = duzinaBroda;
		BrojMotora = brojMotora;
		SnagaMotora = snagaMotora;
		MaxBrzina = maxBrzina;
		UsloviOtkazaRezervacije = usloviOtkazaRezervacije;
	}

	public String getTipBroda() {
		return TipBroda;
	}

	public void setTipBroda(String tipBroda) {
		TipBroda = tipBroda;
	}

	public float getDuzinaBroda() {
		return DuzinaBroda;
	}

	public void setDuzinaBroda(float duzinaBroda) {
		DuzinaBroda = duzinaBroda;
	}

	public int getBrojMotora() {
		return BrojMotora;
	}

	public void setBrojMotora(int brojMotora) {
		BrojMotora = brojMotora;
	}

	public float getSnagaMotora() {
		return SnagaMotora;
	}

	public void setSnagaMotora(float snagaMotora) {
		SnagaMotora = snagaMotora;
	}

	public float getMaxBrzina() {
		return MaxBrzina;
	}

	public void setMaxBrzina(float maxBrzina) {
		MaxBrzina = maxBrzina;
	}

	public String getUsloviOtkazaRezervacije() {
		return UsloviOtkazaRezervacije;
	}

	public void setUsloviOtkazaRezervacije(String usloviOtkazaRezervacije) {
		UsloviOtkazaRezervacije = usloviOtkazaRezervacije;
	}
	
	
}
