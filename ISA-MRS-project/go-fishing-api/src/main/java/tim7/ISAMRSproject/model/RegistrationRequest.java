package tim7.ISAMRSproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class RegistrationRequest {
	public static enum RegistrationRequestStatus{
		PENDING,
		ACCEPTED,
		DECLINED
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @Column(name= "registration_reason", nullable = false)
	private String RegistrationReason;
    
	@Column(name = "registration_request_status", nullable = false)
	private RegistrationRequestStatus requestStatus;
	
	@OneToOne(mappedBy = "registrationRequest", optional = true)
    private User user;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegistrationReason() {
		return RegistrationReason;
	}

	public void setRegistrationReason(String registrationReason) {
		RegistrationReason = registrationReason;
	}

	public RegistrationRequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RegistrationRequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}	
}
