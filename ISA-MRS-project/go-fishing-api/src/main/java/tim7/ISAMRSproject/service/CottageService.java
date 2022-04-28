package tim7.ISAMRSproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.repository.CottageRepository;

@Service
public class CottageService {

	@Autowired
	private CottageRepository cottageRepository;
	
	public List<Cottage> getVikendiceAll(){
		
		return cottageRepository.findAll();
	}
	public List<Cottage> getVikendiceByVlasnik(Long ownerId){
		
		return cottageRepository.findByOwnerId(ownerId);
	}
	
	public void addNewCottage(Cottage cottage) {
		
		cottageRepository.save(cottage);
	}
	
}
