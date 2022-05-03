package tim7.ISAMRSproject.dto;

import org.springframework.util.StringUtils;

// DTO koji preuzima podatke iz registracione forme
public class UserRegisterDTO {
	
	private Long id;
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	private String lastName;
	private String country;
	private String town;
	private String address;
	private String phoneNumber;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean validate() {
		return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") &&
			   password.length() >= 8 && password.length() <= 30 &&
			   password.equals(confirmPassword) &&
			   phoneNumber.matches("^[+][0-9]{10,12}$");
	}
	
	public void casify() {
		this.name = toTitleCase(this.name);
		this.lastName = toTitleCase(this.lastName);
		this.country = toTitleCase(this.country);
		this.town = toTitleCase(this.town);
		this.address = toTitleCase(this.address);
	}
	
	public String toTitleCase(String str) {
		String[] tokens = str.split(" ");
		String res = "";
		for(String token: tokens)
			res += StringUtils.capitalize(token.toLowerCase()) + " ";
		return res.trim();
	}

}
