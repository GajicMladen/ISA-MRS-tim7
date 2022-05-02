package tim7.ISAMRSproject.model;

import static javax.persistence.DiscriminatorType.STRING;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=STRING)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "username",unique = true,nullable = false)
	private String username;
	
	@Column(name = "password",nullable = false)
	private String password;

	@Column(name="email",nullable = false)
	private String email;

	@Column(name ="name",nullable = false)
	private String name;
	
	@Column(name = "lastname",nullable = false)
	private String lastName;
	
	@Column(name = "phone",nullable = false)
	private String phone;

	@Column(name = "deleted",nullable = false)
	private boolean deleted;
	
	@Column(name = "active",nullable = false)
	private boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address livingAddress;
	
    @Column(name = "userType")
    private UserType userType;
    
    public User() {
    	
    }
	
	public User(Integer id, String username, String password, String email, String name, String lastName, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.active = false;
		this.deleted = false;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String password) {
		this.email = email;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	/*
	 * private UserType userType;
	 * private LojalniStatus lojalniStatus;
	 * 
	 * */
	
	
}
