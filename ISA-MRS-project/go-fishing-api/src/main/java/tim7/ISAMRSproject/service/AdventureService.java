package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.repository.AdventureRepository;

@Service
public class AdventureService {
	
	@Autowired
	private AdventureRepository adventureRepository;
	
	public Adventure findOne(Integer id) {
		return adventureRepository.findById(id).orElse(null);
	}
	
	public void remove(Integer id) {
		adventureRepository.deleteById(id);
	}
}
