package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.AdventureDTO;
import tim7.ISAMRSproject.dto.ChangePasswordDTO;
import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.dto.InstructorDTO;
import tim7.ISAMRSproject.dto.UserDTO;
import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.AdventureService;
import tim7.ISAMRSproject.service.ReservationService;
import tim7.ISAMRSproject.service.UserService;

@RestController
@RequestMapping(value = "adventure")
@CrossOrigin(origins = "http://localhost:4200")
public class AdventureController {

	@Autowired
	private AdventureService adventureService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<AdventureDTO> getAdventureById(@PathVariable Integer id){
		Optional<Adventure> adventure = adventureService.findById(id);
		if (adventure.isPresent()) {
			System.out.println(adventure.get().getName());
			return new ResponseEntity<AdventureDTO>(new AdventureDTO(adventure.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/instructor/adventures/{id}")
	public ResponseEntity<List<AdventureDTO>> getInstructorAdventures(@PathVariable int id){
		
		List<Adventure> adventures = adventureService.getAdventuresByInstructorId(id);
		List<AdventureDTO> adventuresDTO = new ArrayList<AdventureDTO>();
		
	
		for (Adventure a : adventures) {
			adventuresDTO.add(new AdventureDTO(a));
		}
		
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}
	
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
	
	@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping()
	public ResponseEntity<Void> addAdventure(@RequestBody AdventureDTO a) {
		this.adventureService.addAdventure(a);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/instructor")
	public ResponseEntity<Void> updateInstructorData(@RequestBody UserDTO i) {
		this.adventureService.updateInstructorData(i);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<Void> editAdventure(@RequestBody AdventureDTO a) {
		try {
			this.adventureService.editAdventure(a);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/instructor/passwordChange/{id}")
	public ResponseEntity<?> changeInstructorPassword(@PathVariable Integer id, @RequestBody ChangePasswordDTO changePasswordDTO) {
		if(!changePasswordDTO.validate())
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Pogrešni podaci!");
		
		Optional<User> user = userService.findById(id);
		if (user.isPresent()) {
			User changedUser = user.get();
			userService.changeUserPassword(changedUser, changePasswordDTO);		
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(changedUser);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nepostojeći korisnik");
		
	}
	
}
