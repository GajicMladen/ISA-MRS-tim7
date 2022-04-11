package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.Korisnik;
import tim7.ISAMRSproject.repository.KorisnikRepository;

@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	public Korisnik getById(int id) {
		
		return korisnikRepository.getById(id);
	}
	
}
