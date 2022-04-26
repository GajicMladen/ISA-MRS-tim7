package tim7.ISAMRSproject.dto;

import tim7.ISAMRSproject.model.Vikendica;

public class VikendicaDTO {

	private Integer id;
	private String naziv;
	private String promoOpis;
	private float cena;
	private int kapacitet;
	
	public VikendicaDTO() {
		
		
	}
	
	public VikendicaDTO(Vikendica vikendica) {
		
		id = vikendica.getId();
		naziv = vikendica.getNaziv();
		promoOpis = vikendica.getPromoOpis();
		cena = vikendica.getCena();
		kapacitet = vikendica.getKapacitet();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer idI) {
		this.id = idI;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getPromoOpis() {
		return promoOpis;
	}
	public void setPromoOpis(String promoOpis) {
		this.promoOpis = promoOpis;
	}
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	
	
}
