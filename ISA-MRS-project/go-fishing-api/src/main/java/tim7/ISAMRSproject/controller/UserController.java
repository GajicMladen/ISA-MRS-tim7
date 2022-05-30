package tim7.ISAMRSproject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import tim7.ISAMRSproject.dto.ChangePasswordDTO;
import tim7.ISAMRSproject.dto.DeletionRequestDTO;
import tim7.ISAMRSproject.dto.UserDTO;
import tim7.ISAMRSproject.dto.UserRegisterDTO;
import tim7.ISAMRSproject.model.DeletionRequest;
import tim7.ISAMRSproject.model.DeletionRequest.DeletionRequestStatus;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.UserService;


@RestController
@RequestMapping(value = "/api/users", produces=MediaType.APPLICATION_JSON_VALUE)
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
	
	
	@GetMapping(value = "/getUserData")
	public UserRegisterDTO user(Principal user){
		
		return UserRegisterDTO.getUserDTOFromUser(userService.findByEmail(user.getName()));
	}
	
	@PostMapping(value = "/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody UserRegisterDTO userRegisterDTO, UriComponentsBuilder ucBuilder){
		// Converts appropriate fields to title case.
		userRegisterDTO.casify();
		
		if(!userRegisterDTO.validate())
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Invalid data!");
		
		User existingUser = userService.findByEmail(userRegisterDTO.getEmail());
		userService.updateUser(existingUser, userRegisterDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(existingUser);
	}
	
	@PostMapping(value = "/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO, UriComponentsBuilder ucBuilder, Principal user){
		
		if(!changePasswordDTO.validate())
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Invalid data!");
		
		User changedUser = userService.findByEmail(user.getName());
		userService.changeUserPassword(changedUser, changePasswordDTO);		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(changedUser);
	}
	
	@GetMapping(value = "/loyaltyPoints")
	public String getLoyaltyPoints(Principal user){
		User reqUser = this.userService.findByEmail(user.getName());
		return "{ \"loyaltyPoints\": " + reqUser.getLoyaltyPoints() + "}";
	}
	
	@PostMapping(value="/deletionRequest")
	public ResponseEntity<?> saveDeletionRequest(@RequestBody DeletionRequestDTO deletionRequestDTO, UriComponentsBuilder ucBuilder, Principal user){
		if (deletionRequestDTO.getDeletionReason().length() < 10) return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Invalid data!");
		User requestUser = userService.findByEmail(user.getName());
		
		DeletionRequest deletionRequest = new DeletionRequest();
		deletionRequest.setDeletionReason(deletionRequestDTO.getDeletionReason());
		deletionRequest.setRequestStatus(DeletionRequestStatus.PENDING);
		deletionRequest.setUser(requestUser);
		requestUser.setDeletionRequest(deletionRequest);
		userService.save(requestUser);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(requestUser);
	}
}