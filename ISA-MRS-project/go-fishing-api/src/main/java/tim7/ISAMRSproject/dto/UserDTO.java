package tim7.ISAMRSproject.dto;

import tim7.ISAMRSproject.model.Userr;

public class UserDTO {

	private Long id;
	private String name;
	private String lastName;
	private String username;
	
	
	public UserDTO(Userr userr) {
		
		this(userr.getId(), userr.getName(), userr.getLastName(), userr.getUsername());
	}
	
	public UserDTO(Long id, String name, String lastName, String username) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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
	
	
	
}
