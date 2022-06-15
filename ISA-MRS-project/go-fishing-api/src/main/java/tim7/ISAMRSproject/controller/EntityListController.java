package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.OfferShortDTO;
import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.repository.AdventureRepository;
import tim7.ISAMRSproject.repository.BoatRepository;
import tim7.ISAMRSproject.repository.CottageRepository;

@RestController
@RequestMapping(value = "/api/entity", produces=MediaType.APPLICATION_JSON_VALUE)
public class EntityListController {

	@Autowired
	private CottageRepository cottageRepository;
	
	@Autowired
	private BoatRepository boatRepository;
	
	@Autowired
	private AdventureRepository adventureRepository;
	
	@GetMapping(value = "/cottages/all")
	public ResponseEntity<List<OfferShortDTO>> getCottagesPage(@RequestParam("page") int page, @RequestParam("perPage") int perPage, @RequestParam("sort") String sort){
		List<OfferShortDTO> cottagesDTO = new ArrayList<OfferShortDTO>();
		Page<Cottage> cottages;
		switch(sort) {
			case "name-asc":
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage, Sort.by("name").ascending()));
				break;
			case "name-desc":
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage, Sort.by("name").descending()));
				break;
			case "rating-asc":
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage, Sort.by("rating").ascending()));
				break;
			case "rating-desc":
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage, Sort.by("rating").descending()));
				break;
			case "location-asc":
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage, Sort.by("address.city").ascending()));
				break;
			case "location-desc":
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage, Sort.by("address.city").descending()));
				break;
			case "price-asc":
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage, Sort.by("price").ascending()));
				break;
			case "price-desc":
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage, Sort.by("price").descending()));
				break;
			default:
				cottages = cottageRepository.findAll(PageRequest.of(page, perPage));
		}
		for(Cottage c: cottages)
			cottagesDTO.add(new OfferShortDTO(c));
		return new ResponseEntity<>(cottagesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/cottages/count")
	public ResponseEntity<Integer> getTotalCottages(){
		Integer total = cottageRepository.getTotalCottages();
		return new ResponseEntity<>(total, HttpStatus.OK);
	}
	
	@GetMapping(value = "/boats/all")
	public ResponseEntity<List<OfferShortDTO>> getBoatsPage(@RequestParam("page") int page, @RequestParam("perPage") int perPage, @RequestParam("sort") String sort){
		List<OfferShortDTO> boatsDTO = new ArrayList<OfferShortDTO>();
		Page<Boat> boats;
		switch(sort) {
			case "name-asc":
				boats = boatRepository.findAll(PageRequest.of(page, perPage, Sort.by("name").ascending()));
				break;
			case "name-desc":
				boats = boatRepository.findAll(PageRequest.of(page, perPage, Sort.by("name").descending()));
				break;
			case "rating-asc":
				boats = boatRepository.findAll(PageRequest.of(page, perPage, Sort.by("rating").ascending()));
				break;
			case "rating-desc":
				boats = boatRepository.findAll(PageRequest.of(page, perPage, Sort.by("rating").descending()));
				break;
			case "location-asc":
				boats = boatRepository.findAll(PageRequest.of(page, perPage, Sort.by("address.city").ascending()));
				break;
			case "location-desc":
				boats = boatRepository.findAll(PageRequest.of(page, perPage, Sort.by("address.city").descending()));
				break;
			case "price-asc":
				boats = boatRepository.findAll(PageRequest.of(page, perPage, Sort.by("price").ascending()));
				break;
			case "price-desc":
				boats = boatRepository.findAll(PageRequest.of(page, perPage, Sort.by("price").descending()));
				break;
			default:
				boats = boatRepository.findAll(PageRequest.of(page, perPage));
		}
		for(Boat b: boats)
			boatsDTO.add(new OfferShortDTO(b));
		return new ResponseEntity<>(boatsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/boats/count")
	public ResponseEntity<Integer> getTotalBoats(){
		Integer total = boatRepository.getTotalBoats();
		return new ResponseEntity<>(total, HttpStatus.OK);
	}
	
	@GetMapping(value = "/adventures/all")
	public ResponseEntity<List<OfferShortDTO>> getAdventuresPage(@RequestParam("page") int page, @RequestParam("perPage") int perPage, @RequestParam("sort") String sort){
		List<OfferShortDTO> adventuresDTO = new ArrayList<OfferShortDTO>();
		Page<Adventure> adventures;
		switch(sort) {
			case "name-asc":
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage, Sort.by("name").ascending()));
				break;
			case "name-desc":
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage, Sort.by("name").descending()));
				break;
			case "rating-asc":
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage, Sort.by("rating").ascending()));
				break;
			case "rating-desc":
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage, Sort.by("rating").descending()));
				break;
			case "location-asc":
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage, Sort.by("address.city").ascending()));
				break;
			case "location-desc":
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage, Sort.by("address.city").descending()));
				break;
			case "price-asc":
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage, Sort.by("price").ascending()));
				break;
			case "price-desc":
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage, Sort.by("price").descending()));
				break;
			default:
				adventures = adventureRepository.findAll(PageRequest.of(page, perPage));
		}
		for(Adventure a: adventures)
			adventuresDTO.add(new OfferShortDTO(a));
		return new ResponseEntity<>(adventuresDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/adventures/count")
	public ResponseEntity<Integer> getTotalAdventures(){
		Integer total = adventureRepository.getTotalAdventures();
		return new ResponseEntity<>(total, HttpStatus.OK);
	}
}
