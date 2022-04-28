package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.service.CottageService;

@RestController
@RequestMapping(value = "api/cottages")
public class CottageController {

	@Autowired
	private CottageService cottageService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<CottageDTO>> getAllCottages(){
		
		List<Cottage> cottages = cottageService.getVikendiceAll();
		List<CottageDTO> cottageDTOS = new ArrayList<CottageDTO>();
	
		for (Cottage cottage : cottages) {
			cottageDTOS.add(new CottageDTO(cottage));
		}
		
		return new ResponseEntity<>(cottageDTOS,HttpStatus.OK);
	} 
	
	@GetMapping(value = "/owner/{id}")
	public ResponseEntity<List<CottageDTO>> getOwnerCottages(@PathVariable Long id){
		
		List<Cottage> cottages = cottageService.getVikendiceByVlasnik(id);
		List<CottageDTO> cottageDTOS = new ArrayList<CottageDTO>();
	
		for (Cottage cottage : cottages) {
			cottageDTOS.add(new CottageDTO(cottage));
		}
		
		return new ResponseEntity<>(cottageDTOS,HttpStatus.OK);
	} 
	
	@PostMapping(
			value = "/newCottage",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addNewCottage(@RequestBody Cottage newOne) {

		cottageService.addNewCottage(newOne);
	}
}
