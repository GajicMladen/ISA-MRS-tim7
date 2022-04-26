package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.VikendicaDTO;
import tim7.ISAMRSproject.model.Vikendica;
import tim7.ISAMRSproject.model.VlasnikVikendice;
import tim7.ISAMRSproject.service.KorisnikService;
import tim7.ISAMRSproject.service.VikendicaService;

@RestController
@RequestMapping(value = "api/vikendice")
public class VikendicaController {

	@Autowired
	private VikendicaService vikendicaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<VikendicaDTO>> getAllVikendice(){
		
		List<Vikendica> vikendice = vikendicaService.getVikendiceAll();
		List<VikendicaDTO> vikendiceDTO = new ArrayList<VikendicaDTO>();
	
		for (Vikendica vikendica : vikendice) {
			vikendiceDTO.add(new VikendicaDTO(vikendica));
		}
		
		return new ResponseEntity<>(vikendiceDTO,HttpStatus.OK);
	} 
	
	@GetMapping(value = "/korisnik/{id}")
	public ResponseEntity<List<VikendicaDTO>> getAllVikendiceKorisnika(@PathVariable Long id){
		
		List<Vikendica> vikendice = vikendicaService.getVikendiceByVlasnik(id);
		List<VikendicaDTO> vikendiceDTO = new ArrayList<VikendicaDTO>();
	
		for (Vikendica vikendica : vikendice) {
			vikendiceDTO.add(new VikendicaDTO(vikendica));
		}
		
		return new ResponseEntity<>(vikendiceDTO,HttpStatus.OK);
	} 
	
	@PostMapping(value = "/newCottage")
	public void addNewCottage(Vikendica newOne) {
		newOne.setId(10);
		vikendicaService.addNewCottage(newOne);
	}
}
