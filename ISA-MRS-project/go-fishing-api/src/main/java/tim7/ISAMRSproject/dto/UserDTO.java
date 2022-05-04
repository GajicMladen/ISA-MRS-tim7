package tim7.ISAMRSproject.dto;

import tim7.ISAMRSproject.model.User;

public class UserDTO {

	private Integer id;
	private String name;
	private String lastName;
	private String username;
	private String email;
	private String phone;

	
	public UserDTO(User user) {
		
		this(user.getId(), user.getName(), user.getLastName(), user.getUsername(),user.getEmail(),user.getPhone());
	}
	
	public UserDTO(Integer id, String name, String lastName, String username,String email,String phone) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
