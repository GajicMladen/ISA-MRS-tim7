package tim7.ISAMRSproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.LoyaltyDefinition;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.repository.LoyaltyRepository;

@Service
@Transactional
public class LoyaltyService {

	@Autowired
	private LoyaltyRepository loyaltyRepository;
	
	public List<LoyaltyDefinition> getLoyalties(){
		return loyaltyRepository.findAll();
	}
	
	public float getDiscountForUser(User u) {
		List<LoyaltyDefinition> loyalties = loyaltyRepository.findAll();
		for(LoyaltyDefinition l: loyalties) {
			if (l.getMinPoints() <= u.getLoyaltyPoints() && u.getLoyaltyPoints() <= l.getMaxPoints())
				return l.getDiscountRate();
		}
		return 1;
	}
}
