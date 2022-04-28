package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.UserDTO;
import tim7.ISAMRSproject.model.Userr;
import tim7.ISAMRSproject.service.UserService;


@RestController
@RequestMapping(value = "api/korisnici")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<UserDTO>> getAllKorisnici() {

		List<Userr> korisnici = userService.findAll();

		// convert students to DTOs
		List<UserDTO> korisniciDTO = new ArrayList<>();
		for (Userr k : korisnici) {
			korisniciDTO.add(new UserDTO(k));
		}

		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
	}

	/*
	@GetMapping(value = "/vikendice/{id}")
	public ResponseEntity<Userr> getAllVikendice(@PathVariable int id) {

		Userr korisnik = userService.getKorisnikWithVikendice(id);

		// convert students to DTOs

		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}
	*/
}