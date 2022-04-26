package tim7.ISAMRSproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.VikendicaDTO;
import tim7.ISAMRSproject.model.Korisnik;
import tim7.ISAMRSproject.repository.KorisnikRepository;

@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	public Korisnik getById(int id) {
		
		return korisnikRepository.getById(id);
	}
	
	public List<Korisnik> findAll(){
		
		return korisnikRepository.findAll();
	}
	/*
	public Korisnik getKorisnikWithVikendice(int id) {
		
		return korisnikRepository.getKorisnikWithVikendice(id);
	}
	*/
}
