package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.model.UserType;
import tim7.ISAMRSproject.service.CottageService;
import tim7.ISAMRSproject.service.UserService;

import javax.jws.soap.SOAPBinding;

@RestController
@RequestMapping(value = "api/cottages")
public class CottageController {

	@Autowired
	private CottageService cottageService;

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<CottageDTO>> getAllCottages(){
		
		List<Cottage> cottages = cottageService.getAllCottages();
		List<CottageDTO> cottageDTOS = new ArrayList<CottageDTO>();
	
		for (Cottage cottage : cottages) {
			cottageDTOS.add(new CottageDTO(cottage));
		}
		
		return new ResponseEntity<>(cottageDTOS,HttpStatus.OK);
	}

	@GetMapping(value = "/getCottage/{id}")
	public ResponseEntity<CottageDTO> getCottageById(@PathVariable Integer id){

		Optional<Cottage> cottage =  cottageService.getCottageById(id);
		if(cottage.isPresent())
			return new ResponseEntity<>(new CottageDTO(cottage.get()), HttpStatus.OK);
		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/owner/{id}")
	public ResponseEntity<List<CottageDTO>> getOwnerCottages(@PathVariable int id){
		
		List<Cottage> cottages = cottageService.getCottagesByOwnerId(id);
		List<CottageDTO> cottageDTOS = new ArrayList<CottageDTO>();
	
		for (Cottage cottage : cottages) {
			cottageDTOS.add(new CottageDTO(cottage));
		}
		
		return new ResponseEntity<>(cottageDTOS,HttpStatus.OK);
	} 
	
	@PostMapping(
			value = "/newCottage",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public CottageDTO addNewCottage(@RequestBody CottageDTO newOne) {
		Optional<User> user = userService.findById(newOne.getOwnerId());
		if(user.isPresent() && user.get().getUserType() == UserType.VLASNIK_VIKENDICE)
			return new CottageDTO(cottageService.addNewCottage(newOne,user.get()));
		return null;
	}

	@DeleteMapping(value = "/deleteCottage/{id}")
	public boolean deleteCottage(@PathVariable Integer id){

		return cottageService.deleteCottage(id);

	}

	@PutMapping(value = "/updateCottage",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateCottage(@RequestBody CottageDTO cottage){
		System.out.println(cottage.getName());
		System.out.println("================");
		cottageService.editCottage(cottage);
	}
}
