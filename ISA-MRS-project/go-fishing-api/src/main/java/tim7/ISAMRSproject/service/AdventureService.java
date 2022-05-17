package tim7.ISAMRSproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.AdventureDTO;
import tim7.ISAMRSproject.dto.InstructorDTO;
import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.model.User;
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
		Adventure adventure = new Adventure(a, userService.findById(a.getInstructorId()).get());
		this.adventureRepository.save(adventure);
	}
	
	public void updateInstructorData(InstructorDTO instructor) {
		Optional<User> user = userService.findById(instructor.getId());
		if (user.isPresent()) {
			User i = user.get();
			i.setName(instructor.getName());
			i.setLastName(instructor.getSurname());
			i.setPhone(instructor.getPhone());
			userService.save(i);
		}
	}

	public List<Adventure> getAdventuresByInstructorId(int id) {
		return adventureRepository.findByInstructorId(id);
	}
}
