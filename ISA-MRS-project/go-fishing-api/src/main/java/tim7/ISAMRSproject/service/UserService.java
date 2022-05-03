package tim7.ISAMRSproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.UserRegisterDTO;
import tim7.ISAMRSproject.model.Address;
import tim7.ISAMRSproject.model.Role;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;
	
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with email '%s'.", username));
		} else {
			return user;
		}
	}
	
	public User findByEmail(String email) throws AccessDeniedException{
		return userRepository.findByEmail(email);
	}
	
	public User save(UserRegisterDTO userRegisterDTO) {
		
		User newUser = new User();
		Address address = new Address();
		
		address.setCountry(userRegisterDTO.getCountry());
		address.setCity(userRegisterDTO.getTown());
		address.setStreet(userRegisterDTO.getAddress());
		address.setUser(newUser);
		
		newUser.setEmail(userRegisterDTO.getEmail());
		newUser.setName(userRegisterDTO.getName());
		newUser.setLastName(userRegisterDTO.getLastName());
		newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
		newUser.setPhone(userRegisterDTO.getPhoneNumber());
		newUser.setAddress(address);
		newUser.setDeleted(false);
		newUser.setActive(false);
		
		List<Role> roles = roleService.findByName("ROLE_USER");
		newUser.setRoles(roles);
		
		return this.userRepository.save(newUser);
	}
	
	public User save(User user) {
		return this.userRepository.save(user);
	}
	
}
