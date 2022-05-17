package tim7.ISAMRSproject.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.dto.FreePeriodDTO;
import tim7.ISAMRSproject.model.*;
import tim7.ISAMRSproject.repository.CottageRepository;
import tim7.ISAMRSproject.repository.FreePeriodRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CottageService {

	@Autowired
	private CottageRepository cottageRepository;

	@Autowired
	private FreePeriodRepository freePeriodRepository;

	
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

	public void editCottage(CottageDTO cottageDTO){
		cottageRepository.updateCottage(cottageDTO.getId(), cottageDTO.getName(),
				cottageDTO.getPromoDescription(), cottageDTO.getPrice(),cottageDTO.getCapacity());
	}


}
