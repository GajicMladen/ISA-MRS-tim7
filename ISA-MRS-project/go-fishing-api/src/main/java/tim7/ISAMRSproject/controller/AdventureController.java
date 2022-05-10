package tim7.ISAMRSproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.AdventureDTO;
import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.service.AdventureService;
import tim7.ISAMRSproject.service.ReservationService;

@RestController
@RequestMapping(value = "adventure")
@CrossOrigin(origins = "http://localhost:4200")
public class AdventureController {

	@Autowired
	private AdventureService adventureService;
	
	@Autowired
	private ReservationService reservationService;
	
	@DeleteMapping(value = "/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<AdventureDTO> deleteAdventure(@PathVariable Integer id) {
		Optional<Adventure> adventure = adventureService.findById(id);
		
		if (adventure.isPresent()) {
			//if (!reservationService.AdventureHasReservations(id)) {
			adventureService.remove(id);
			return new ResponseEntity<AdventureDTO>(new AdventureDTO(adventure.get()), HttpStatus.OK);
			//}
			//return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
		else {
			return new ResponseEntity<AdventureDTO>(new AdventureDTO(adventure.get()), HttpStatus.NOT_FOUND);
		}
	}
	
	//TODO: Koristiti Data Transfer Object u komunikaciji sa klijentom
	@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping()
	public ResponseEntity<Void> addAdventure(@RequestBody AdventureDTO a) {
		this.adventureService.addAdventure(a);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
