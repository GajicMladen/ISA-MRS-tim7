package tim7.ISAMRSproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.Cottage;
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
	
	public void addNewCottage(Cottage cottage) {
		
		cottageRepository.save(cottage);

	}
	
}
