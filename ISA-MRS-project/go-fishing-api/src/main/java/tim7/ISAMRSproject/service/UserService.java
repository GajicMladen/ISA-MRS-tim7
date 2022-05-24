package tim7.ISAMRSproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.ChangePasswordDTO;
import tim7.ISAMRSproject.dto.UserRegisterDTO;
import tim7.ISAMRSproject.model.Address;
import tim7.ISAMRSproject.model.BoatOwner;
import tim7.ISAMRSproject.model.CottageOwner;
import tim7.ISAMRSproject.model.DeletionRequest;
import tim7.ISAMRSproject.model.FishingInstructor;
import tim7.ISAMRSproject.model.Role;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.repository.BoatOwnerRepository;
import tim7.ISAMRSproject.repository.CottageOwnerRepository;
import tim7.ISAMRSproject.repository.DeletionRequestRepository;
import tim7.ISAMRSproject.repository.InstructorRepository;
import tim7.ISAMRSproject.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BoatOwnerRepository boatOwnerRepository;

	@Autowired
	private CottageOwnerRepository cottageOwnerRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Autowired
	private DeletionRequestRepository deletionRequestRepository;
	
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
		
		newUser.setEmail(userRegisterDTO.getEmail());
		newUser.setName(userRegisterDTO.getName());
		newUser.setLastName(userRegisterDTO.getLastName());
		newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
		newUser.setPhone(userRegisterDTO.getPhoneNumber());
		newUser.setAddress(address);
		newUser.setDeleted(false);
		newUser.setActive(false);
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleService.findByName("ROLE_USER"));
		if (!userRegisterDTO.getRole().equals("ROLE_USER"))
			roles.add(roleService.findByName(userRegisterDTO.getRole()));
		newUser.setRoles(roles);
		
		switch(userRegisterDTO.getRole()) {
			case("ROLE_USER"):
				return (User)(this.userRepository.save(newUser));
			case("ROLE_BOAT_OWNER"):
				return (User)(this.boatOwnerRepository.save(new BoatOwner(newUser)));
			case("ROLE_COTTAGE_OWNER"):
				return (User)(this.cottageOwnerRepository.save(new CottageOwner(newUser)));
			case("ROLE_INSTRUCTOR"):
				return (User)(this.instructorRepository.save(new FishingInstructor(newUser)));
		}
		return null;
	}
	
	public void updateUser(User user, UserRegisterDTO dto) {
		if (!(user.getName().equals(dto.getName())))
			user.setName(dto.getName());
		if (!(user.getLastName().equals(dto.getLastName())))
			user.setLastName(dto.getLastName());
		if (!(user.getPhone().equals(dto.getPhoneNumber())))
			user.setPhone(dto.getPhoneNumber());
		
		Address dtoAddress = new Address();
		dtoAddress.setCity(dto.getTown());
		dtoAddress.setCountry(dto.getCountry());
		dtoAddress.setStreet(dto.getAddress());
		
		if (!(user.getAddress().equals(dtoAddress))) {
			dtoAddress.setUser(user);
			user.setAddress(dtoAddress);			
		}
		
		this.userRepository.save(user);
		
	}
	
	public void changeUserPassword(User user, ChangePasswordDTO changePasswordDTO) {
		user.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
		this.userRepository.save(user);
	}
	
	public User save(User user) {
		return this.userRepository.save(user);
	}
	
	public DeletionRequest saveDeletionRequest(DeletionRequest deletionRequest) {
		return this.deletionRequestRepository.save(deletionRequest);
	}
	
}
