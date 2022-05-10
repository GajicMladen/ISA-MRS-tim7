package tim7.ISAMRSproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}

	/*
	public User getKorisnikWithVikendice(int id) {
		
		return userRepository.getKorisnikWithVikendice(id);
	}
	*/
}
