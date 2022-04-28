package tim7.ISAMRSproject.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
	@Column(name = "startDateTime",nullable = false)
	private LocalDateTime startDateTime;

	@Column(name = "endDateTime",nullable = false)
	private LocalDateTime endDateTime;

	@Column(name = "totalPrice",nullable = false)
	private float totalPrice;
	
	@Column(name = "status" , nullable = false)
	private ReservationStatus status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	@OneToOne
	@JoinColumn(name = "grade", referencedColumnName = "id",nullable = true)
	private Grade grade;

	@OneToOne
	@JoinColumn(name = "complaint", referencedColumnName = "id",nullable = true)
	private Complaint complaint;
	
	
	
}
