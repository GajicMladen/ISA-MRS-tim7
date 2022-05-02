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
public class FreePeriod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDateTime startDateTime;
	
	@Column(nullable = false)
	private LocalDateTime endDateTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	
	
}
