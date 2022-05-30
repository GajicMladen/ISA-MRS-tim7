package tim7.ISAMRSproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class DeletionRequest {
	
	public static enum DeletionRequestStatus{
		PENDING,
		ACCEPTED,
		DECLINED
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @Column(name= "deletion_reason", nullable = false)
	private String deletionReason;
    
	@Column(name = "deletion_request_status", nullable = false)
	private DeletionRequestStatus requestStatus;
	
	@OneToOne(mappedBy = "deletionRequest", optional = true)
    private User user;
	
	public DeletionRequest() {
		
	}
	
	public DeletionRequest(String reason) {
		this.deletionReason = reason;
	}
	
	public String getDeletionReason() {
		return deletionReason;
	}
	public void setDeletionReason(String deletionReason) {
		this.deletionReason = deletionReason;
	}
	public DeletionRequestStatus getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(DeletionRequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
