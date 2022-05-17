package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.UserDTO;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.UserService;


@RestController
@RequestMapping(value = "api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<UserDTO>> getAllKorisnici() {

		List<User> users = userService.findAll();

		List<UserDTO> userDTOS = new ArrayList<>();
		for (User u : users) {
			userDTOS.add(new UserDTO(u));
		}

		return new ResponseEntity<>(userDTOS, HttpStatus.OK);
	}

	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable int id){

		Optional<User> user = userService.findById(id);

		if(user != null)
			return new ResponseEntity<>(new UserDTO(user.get()),HttpStatus.OK);

		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping(value = "/getUserByEmail/{email}")
	public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email){

		Optional<User> user = Optional.ofNullable(userService.findByEmail(email));

		if(user != null)
			return new ResponseEntity<>(new UserDTO(user.get()),HttpStatus.OK);

		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

}