package tim7.ISAMRSproject.dto;

import tim7.ISAMRSproject.model.Korisnik;

public class KorisnikDTO {

	private Long id;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	
	
	public KorisnikDTO(Korisnik korisnik ) {
		
		this(korisnik.getId(),korisnik.getIme(),korisnik.getPrezime(),korisnik.getKorisnickoIme());
	}
	
	public KorisnikDTO(Long id, String ime, String prezime, String korisnickoIme) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public String getKorisnickoIme() {
		return korisnickoIme;
	}



	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	
	
}
