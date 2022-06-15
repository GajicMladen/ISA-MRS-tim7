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

import tim7.ISAMRSproject.dto.BoatDTO;
import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.dto.DeletionRequestOutDTO;
import tim7.ISAMRSproject.dto.RegistrationRequestOutDTO;
import tim7.ISAMRSproject.dto.UserDTO;
import tim7.ISAMRSproject.dto.UserRegisterDTO;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.DeletionRequest.DeletionRequestStatus;
import tim7.ISAMRSproject.model.RegistrationRequest.RegistrationRequestStatus;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.AdminService;
import tim7.ISAMRSproject.service.BoatService;
import tim7.ISAMRSproject.service.CottageService;
import tim7.ISAMRSproject.service.UserService;
import tim7.ISAMRSproject.utils.EmailServiceImpl;


@RestController
@RequestMapping(value = "admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailServiceImpl mailService;
	
	@Autowired
	private BoatService boatService;
	
	@Autowired
	private CottageService cottageService;
	
	@PutMapping(value = "/update")
	public ResponseEntity<Void> updateAdminData(@RequestBody UserDTO i) {
		this.adminService.updateAdminData(i);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addAdmin(@RequestBody UserRegisterDTO userRegisterDTO) {
		User existingUser = userService.findByEmail(userRegisterDTO.getEmail());	
		if (existingUser != null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Email is already taken!");
		}
		
		User newUser = userService.saveAdmin(userRegisterDTO);
		mailService.sendAdminConfirmationMail(newUser);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	
	@GetMapping(value = "/deletionRequests")
	public ResponseEntity<?> getDeletionRequests() {
		List<User> users = userService.findAll();
		List<DeletionRequestOutDTO> deletionRequests = new ArrayList<DeletionRequestOutDTO>();
		for (User u : users) {
			if ((u.getDeletionRequest() != null) && (u.getDeletionRequest().getRequestStatus() == DeletionRequestStatus.PENDING)) {
				DeletionRequestOutDTO dto = new DeletionRequestOutDTO();
				dto.setDeletionReason(u.getDeletionRequest().getDeletionReason());
				dto.setUserId(u.getId().toString());
				dto.setName(u.getName());
				dto.setLastName(u.getLastName());
				deletionRequests.add(dto);
			}
		}
		return new ResponseEntity<>(deletionRequests, HttpStatus.OK);
	}
	
	@GetMapping(value = "/registrationRequests")
	public ResponseEntity<?> getRegistrationRequests() {
		List<User> users = userService.findAll();
		List<RegistrationRequestOutDTO> registrationRequests = new ArrayList<RegistrationRequestOutDTO>();
		for (User u : users) {
			if ((u.getRegistrationRequest() != null) && (u.getRegistrationRequest().getRequestStatus() == RegistrationRequestStatus.PENDING)) {
				RegistrationRequestOutDTO dto = new RegistrationRequestOutDTO();
				dto.setRegistrationReason(u.getRegistrationRequest().getRegistrationReason());				
				dto.setUserId(u.getId().toString());
				dto.setName(u.getName());
				dto.setLastName(u.getLastName());				
				registrationRequests.add(dto);
			}
		}
		return new ResponseEntity<>(registrationRequests, HttpStatus.OK);
	}
	
	@PostMapping(value = "/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		Optional<User> user = this.userService.findById(id);
		if (user.isPresent()) {
			User u = user.get();
			u.setDeleted(true);
			u.getDeletionRequest().setRequestStatus(DeletionRequestStatus.ACCEPTED);
			this.userService.save(u);
			this.mailService.sendDeletionEmail(u, true, "");
		}	
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/refuseDeletion/{id}")
	public ResponseEntity<Void> refuseDeletion(@PathVariable int id, @RequestBody String adminReason) {
		Optional<User> user = this.userService.findById(id);
		if (user.isPresent()) {
			User u = user.get();			
			u.getDeletionRequest().setRequestStatus(DeletionRequestStatus.DECLINED);
			this.userService.save(u);
			this.mailService.sendDeletionEmail(u, false, adminReason);
		}	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/registerUser/{id}")
	public ResponseEntity<Void> registerUser(@PathVariable int id) {
		Optional<User> user = this.userService.findById(id);
		if (user.isPresent()) {
			User u = user.get();
			u.setActive(true);
			this.userService.save(u);
			this.mailService.sendRegistrationEmail(u, true, "");
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/refuseRegistration/{id}") 
	public ResponseEntity<Void> refuseRegistration(@PathVariable int id, @RequestBody String reason) {
		Optional<User> user = this.userService.findById(id);
		if (user.isPresent()) {
			User u = user.get();
			u.setActive(false);
			this.userService.save(u);
			this.mailService.sendRegistrationEmail(u, false, reason);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/allBoats")
	public ResponseEntity<?> getAllBoats() {
		List<Boat> boats = this.boatService.getAllBoats();
		List<BoatDTO> dtos = new ArrayList<BoatDTO>();
		for (Boat b : boats) {
			BoatDTO dto = new BoatDTO(b);
			dtos.add(dto);
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allCottages")
	public ResponseEntity<?> getAllCottages() {
		List<Cottage> cottages = this.cottageService.getAllCottages();
		List<CottageDTO> dtos = new ArrayList<CottageDTO>();
		for (Cottage c : cottages) {
			CottageDTO dto = new CottageDTO(c);
			dtos.add(dto);
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allInstructors")
	public ResponseEntity<?> getAllInstructors() {
		List<User> users = this.userService.findAll();
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (User u : users) {
			if (u.hasRole("ROLE_INSTRUCTOR") && !u.isDeleted()) {
				UserDTO dto = new UserDTO(u);
				dtos.add(dto);
			}
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allClients")
	public ResponseEntity<?> getAllClients() {
		List<User> users = this.userService.findAll();
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (User u : users) {
			if (u.hasRole("ROLE_USER") && !u.isDeleted()) {
				UserDTO dto = new UserDTO(u);
				dtos.add(dto);
			}
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allBoatOwners")
	public ResponseEntity<?> getAllBoatOwners() {
		List<User> users = this.userService.findAll();
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (User u : users) {
			if (u.hasRole("ROLE_BOAT_OWNER") && !u.isDeleted()) {
				UserDTO dto = new UserDTO(u);
				dtos.add(dto);
			}
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allCottageOwners")
	public ResponseEntity<?> getAllCottageOwners() {
		List<User> users = this.userService.findAll();
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (User u : users) {
			if (u.hasRole("ROLE_COTTAGE_OWNER") && !u.isDeleted()) {
				UserDTO dto = new UserDTO(u);
				dtos.add(dto);
			}
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteUser/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable int id) {
		Optional<User> user = this.userService.findById(id);
		if (user.isPresent()) {
			User u = user.get();
			u.setDeleted(true);			
			this.userService.save(u);			
		}			
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteCottage/{id}")
	public ResponseEntity<Void> deleteCottageById(@PathVariable int id) {
		this.cottageService.deleteCottage(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteBoat/{id}")
	public ResponseEntity<Void> deleteBoatById(@PathVariable int id) {
		System.out.println("***************" + id);
		this.boatService.deleteBoat(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
