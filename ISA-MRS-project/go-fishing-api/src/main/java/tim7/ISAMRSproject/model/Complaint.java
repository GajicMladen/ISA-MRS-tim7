package tim7.ISAMRSproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Complaint {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "text",nullable = false)
    private String text;
    
    @Column(name = "status",nullable = false)
    private ApprovalStatus status;
    

	@OneToOne(mappedBy = "complaint")
    private Reservation reservation;
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "klijent_id")
	private Client klijent;
	*/
}
