package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.DeletionRequestOutDTO;
import tim7.ISAMRSproject.dto.UserDTO;
import tim7.ISAMRSproject.dto.UserRegisterDTO;
import tim7.ISAMRSproject.model.DeletionRequest.DeletionRequestStatus;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.AdminService;
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
	
}
