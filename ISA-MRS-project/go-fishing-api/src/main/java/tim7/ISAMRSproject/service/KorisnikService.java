package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.UserRegisterDTO;
import tim7.ISAMRSproject.model.Korisnik;
import tim7.ISAMRSproject.repository.KorisnikRepository;

@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Korisnik getById(Long id) {
		return korisnikRepository.findById(id).orElse(null);
	}
	
	public Korisnik findByEmail(String email) {
		return korisnikRepository.findByEmail(email).orElse(null);
	}
	
	public Korisnik save(UserRegisterDTO userRegisterDTO) {
		
		Korisnik user = new Korisnik();
		
		user.setEmail(userRegisterDTO.getEmail());
		user.setLozinka(userRegisterDTO.getPassword());
		user.setIme(userRegisterDTO.getName());
		user.setPrezime(userRegisterDTO.getSurname());
		user.setTelefon(userRegisterDTO.getPhoneNumber());
	}
	
}
