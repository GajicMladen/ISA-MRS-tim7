package tim7.ISAMRSproject.service;

import java.util.List;
import java.util.Optional;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.CottageOwner;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.repository.CottageRepository;

@Service
public class CottageService {

	@Autowired
	private CottageRepository cottageRepository;
	
	public List<Cottage> getAllCottages(){
		
		return cottageRepository.findAll();
	}
	public Optional<Cottage> getCottageById(Integer id){
		return cottageRepository.findById(id);
	}

	public List<Cottage> getCottagesByOwnerId(Integer ownerId){
		
		return cottageRepository.findByOwnerId(ownerId);
	}
	
	public Cottage addNewCottage(CottageDTO cottageDTO, User user) {

		Cottage cottage = new Cottage(cottageDTO);
		cottage.setCottageOwner((CottageOwner) user);
		return cottageRepository.save(cottage);

	}

	public boolean deleteCottage(Integer id){
		try{
			cottageRepository.deleteById(id);
			return true;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
