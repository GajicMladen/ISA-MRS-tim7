package tim7.ISAMRSproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.AdventureDTO;
import tim7.ISAMRSproject.dto.InstructorDTO;
import tim7.ISAMRSproject.dto.UserDTO;
import tim7.ISAMRSproject.model.Address;
import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.model.FishingInstructor;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.repository.AdventureRepository;

@Service
public class AdventureService {
	
	@Autowired
	private AdventureRepository adventureRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	public Optional<Adventure> findById(Integer id) {
		return this.adventureRepository.findById(id);
	}
	
	public void remove(Integer id) {
		try{
			Optional<Adventure> a =  this.adventureRepository.findById(id);
			if (a.isPresent()) {
				Adventure adventure = a.get();
				adventure.setDeleted(true);
				this.adventureRepository.save(adventure);
				
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void addAdventure(AdventureDTO a) {
		Adventure adventure = new Adventure();
		Address address = new Address();
		address.setStreet(a.getStreet());
		address.setCity(a.getCity());
		address.setCountry(a.getCountry());
		address.setLatitude(a.getLatitude());
		address.setLongitude(a.getLongitude());
		adventure.setAddress(address);
		adventure.setCapacity(a.getCapacity());
		adventure.setDeleted(false);
		adventure.setEquipment(a.getEquipment());
		adventure.setFishingInstructor((FishingInstructor)userService.findById(a.getInstructorId()).get());
		adventure.setInstructorBiography(a.getInstructorBiography());
		adventure.setMoreInfo(a.getMoreInfo());
		adventure.setName(a.getName());
		adventure.setPrice(a.getPrice());
		adventure.setPromoDescription(a.getPromoDescription());
		adventure.setRulesOfCancelation(a.getRulesOfCancelation());
		adventure.setRulesOfConduct(a.getRulesOfConduct());
		this.adventureRepository.save(adventure);
	}
	
	public void updateInstructorData(UserDTO instructor) {
		Optional<User> user = userService.findById(instructor.getId());
		if (user.isPresent()) {
			User i = user.get();
			i.setName(instructor.getName());
			i.setLastName(instructor.getLastName());
			i.setPhone(instructor.getPhone());
			/*Optional<Address> address = addressService.findById(i.getAddress().getId());
			if (address.isPresent()) {
				Address a = address.get();
				a.setStreet(instructor.getStreet());
				a.setCity(instructor.getCity());
				a.setCountry(instructor.getCountry());
				a.setLongitude(instructor.getLongitude());
				a.setLatitude(instructor.getLatitude());
				addressService.save(a);
			}*/
			i.getAddress().setStreet(instructor.getStreet());
			i.getAddress().setCity(instructor.getCity());
			i.getAddress().setCountry(instructor.getCountry());
			i.getAddress().setLatitude(instructor.getLatitude());
			i.getAddress().setLongitude(instructor.getLongitude());
			
			userService.save(i);
		}
	}

	public List<Adventure> getAdventuresByInstructorId(int id) {
		return adventureRepository.findByInstructorId(id);
	}
	
	public void editAdventure(AdventureDTO adventureDTO) {
		Optional<Adventure> a = adventureRepository.findById(adventureDTO.getId());
		if (a.isPresent()) {
			Adventure adventure = a.get();
			adventure.setName(adventureDTO.getName());
			adventure.getAddress().setStreet(adventureDTO.getStreet());
			adventure.getAddress().setCity(adventureDTO.getCity());
			adventure.getAddress().setCountry(adventureDTO.getCountry());
			adventure.getAddress().setLatitude(adventureDTO.getLatitude());
			adventure.getAddress().setLongitude(adventureDTO.getLongitude());
			adventure.setCapacity(adventureDTO.getCapacity());
			adventure.setDeleted(false);
			adventure.setEquipment(adventureDTO.getEquipment());
			adventure.setInstructorBiography(adventureDTO.getInstructorBiography());
			adventure.setMoreInfo(adventureDTO.getMoreInfo());
			adventure.setPrice(adventureDTO.getPrice());
			adventure.setPromoDescription(adventureDTO.getPromoDescription());
			adventure.setRulesOfCancelation(adventureDTO.getRulesOfCancelation());
			adventure.setRulesOfConduct(adventureDTO.getRulesOfConduct());
			
			adventureRepository.save(adventure);
		}
	}
}
