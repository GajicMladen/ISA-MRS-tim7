package tim7.ISAMRSproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.Userr;
import tim7.ISAMRSproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Userr getById(int id) {
		
		return userRepository.getById(id);
	}
	
	public List<Userr> findAll(){
		
		return userRepository.findAll();
	}
	/*
	public Userr getKorisnikWithVikendice(int id) {
		
		return userRepository.getKorisnikWithVikendice(id);
	}
	*/
}
