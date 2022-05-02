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

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Column(name = "startDate",nullable = false)
	private LocalDateTime startDate;
	
	@Column(name = "endDate",nullable = false)
	private LocalDateTime endDate;

	@Column(name ="maxPerson",nullable = false)
	private int maxPerson;
	
	@Column(name ="cena" , nullable = false)
	private float cena;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "offer_id")
	private Offer offer;
}
