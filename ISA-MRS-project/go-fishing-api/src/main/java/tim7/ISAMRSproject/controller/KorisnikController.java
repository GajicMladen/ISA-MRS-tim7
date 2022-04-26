package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.KorisnikDTO;
import tim7.ISAMRSproject.model.Korisnik;
import tim7.ISAMRSproject.service.KorisnikService;


@RestController
@RequestMapping(value = "api/korisnici")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<KorisnikDTO>> getAllKorisnici() {

		List<Korisnik> korisnici = korisnikService.findAll();

		// convert students to DTOs
		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		for (Korisnik k : korisnici) {
			korisniciDTO.add(new KorisnikDTO(k));
		}

		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
	}

	/*
	@GetMapping(value = "/vikendice/{id}")
	public ResponseEntity<Korisnik> getAllVikendice(@PathVariable int id) {

		Korisnik korisnik = korisnikService.getKorisnikWithVikendice(id);

		// convert students to DTOs

		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}
	*/
}