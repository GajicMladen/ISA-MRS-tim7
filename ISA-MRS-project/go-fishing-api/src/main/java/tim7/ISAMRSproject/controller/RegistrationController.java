package tim7.ISAMRSproject.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import tim7.ISAMRSproject.dto.UserRegisterDTO;
import tim7.ISAMRSproject.model.User;

/*
 * Ova klasa predstavlja kontroler za registraciju korisnika.
 * */

@RestController
@RequestMapping(value="/reg", produces=MediaType.APPLICATION_JSON_VALUE)
public class RegistrationController {

	/*
	 * Endpoint za registraciju novog korisnika
	 * */
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserRegisterDTO userRegisterDTO, UriComponentsBuilder ucBuilder){
		return null;
		
	}
	
}
