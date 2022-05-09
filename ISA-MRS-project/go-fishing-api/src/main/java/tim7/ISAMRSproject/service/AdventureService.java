package tim7.ISAMRSproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.AdventureDTO;
import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.repository.AdventureRepository;

@Service
public class AdventureService {
	
	@Autowired
	private AdventureRepository adventureRepository;
	
	@Autowired
	private UserService userService;
	
	public Optional<Adventure> findById(Integer id) {
		return adventureRepository.findById(id);
	}
	
	public void remove(Integer id) {
		this.adventureRepository.deleteById(id);
	}

	public void addAdventure(AdventureDTO a) {
		Adventure adventure = new Adventure(a, userService.findById(a.getInstructorId()));
		this.adventureRepository.save(adventure);
	}
}
