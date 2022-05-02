package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.service.AdventureService;
import tim7.ISAMRSproject.service.ReservationService;

@RestController
@RequestMapping(value = "adventure")
public class AdventureController {

	@Autowired
	private AdventureService adventureService;
	
	@Autowired
	private ReservationService reservationService;
	
	@CrossOrigin(origins="http://localhost:4200/")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAdventure(@PathVariable Integer id) {
		Adventure adventure = adventureService.findOne(id);
		
		if (adventure != null) {
			if (!reservationService.AdventureHasReservations(id)) {
				adventureService.remove(id);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
