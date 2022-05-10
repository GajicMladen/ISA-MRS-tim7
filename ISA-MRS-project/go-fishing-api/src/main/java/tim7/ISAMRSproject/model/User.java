package tim7.ISAMRSproject.model;


import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
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
	
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address livingAddress;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
    
    public User() {
    	
    }
	
	public User(Integer id, String password, String email, String name, String lastName, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.active = false;
		this.deleted = false;

	}
	
	public User(User user) {
		super();
		this.id = user.id;
		this.password = user.password;
		this.email = user.email;
		this.name = user.name;
		this.lastName = user.name;
		this.phone = user.name;
		this.active = user.active;
		this.deleted = user.deleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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
	
	@JsonIgnore
	public Address getAddress() {
		return livingAddress;
	}
	
	public void setAddress(Address address) {
		this.livingAddress = address;
	}
	
    public List<Role> getRoles() {
        return roles;
     }
    
    public void setRoles(List<Role> roles) {
    	this.roles = roles;
    }

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return this.roles;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return email;
	}
}
