package tim7.ISAMRSproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.UserDTO;
import tim7.ISAMRSproject.model.User;

@Service
public class AdminService {
	
	@Autowired
	private UserService userService;

	public void updateAdminData(UserDTO i) {
		Optional<User> user = userService.findById(i.getId());
		if (user.isPresent()) {
			User u = user.get();
			u.setName(i.getName());
			u.setLastName(i.getLastName());
			u.setPhone(u.getPhone());			
			u.getAddress().setStreet(i.getStreet());
			u.getAddress().setCity(i.getCity());
			u.getAddress().setCountry(i.getCountry());			
			
			userService.save(u);
		}
	}

	
	
}
