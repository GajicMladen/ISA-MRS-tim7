package tim7.ISAMRSproject.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.LoyaltyDTO;
import tim7.ISAMRSproject.model.LoyaltyDefinition;
import tim7.ISAMRSproject.repository.UserRepository;
import tim7.ISAMRSproject.service.LoyaltyService;

@RestController
@RequestMapping(value="api/loyalty")
public class LoyaltyController {

	@Autowired
	private LoyaltyService loyaltyService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/getLoyalties")
	public ResponseEntity<?> getAllLoyalties(){
		ArrayList<LoyaltyDTO> loyalties = new ArrayList<LoyaltyDTO>();
		for(LoyaltyDefinition l: loyaltyService.getLoyalties()) {
			LoyaltyDTO dto = new LoyaltyDTO();
			dto.setId(l.getId());
			dto.setRankName(l.getRankName());
			dto.setMaxPoints(l.getMaxPoints());
			dto.setMinPoints(l.getMinPoints());
			dto.setDiscountRate(l.getDiscountRate());
			dto.setPointsPerReservation(l.getPointsPerReservation());
			loyalties.add(dto);
		}
		return new ResponseEntity<>(loyalties, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getLoyalty")
	public ResponseEntity<?> getLoyaly(Principal user){
		float userDiscount = loyaltyService.getDiscountForUser(userRepository.findByEmail(user.getName()));
		return new ResponseEntity<>(userDiscount, HttpStatus.OK);
	}
	
}
