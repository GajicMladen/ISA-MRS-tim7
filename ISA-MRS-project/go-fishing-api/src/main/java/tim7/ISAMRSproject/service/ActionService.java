package tim7.ISAMRSproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.model.Action;
import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.repository.ActionRepository;
import tim7.ISAMRSproject.repository.AdventureRepository;

@Service
public class ActionService {
	
	@Autowired
	private ActionRepository actionRepository;
	
	@Autowired AdventureRepository adventureRepository;

	public boolean addAction(ActionDTO actionDTO) {
		if (checkDate(actionDTO)) {
			Action action = new Action();
			action.setStartDate(actionDTO.getStartDate());
			action.setEndDate(actionDTO.getEndDate());
			action.setPrice(actionDTO.getTotalPrice());
			Optional<Adventure> adventure = adventureRepository.findById(actionDTO.getOfferId());
	        if (adventure.isPresent()) {
	        	action.setOffer(adventure.get());
	        	action.setMaxPerson(adventure.get().getCapacity());
	        	actionRepository.save(action);
	        	return true;
	        }
	        return false;
		}
		else {
			return false;
		}
	}

	private boolean checkDate(ActionDTO actionDTO) {
		return true;
	}

	public List<Action> getActionByOfferId(int id) { 
		return this.actionRepository.findAllByOfferId(id);
	}
}
