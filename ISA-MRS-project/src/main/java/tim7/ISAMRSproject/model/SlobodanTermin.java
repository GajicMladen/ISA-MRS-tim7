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
import javax.persistence.OneToMany;

@Entity
public class SlobodanTermin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDateTime pocetak;
	
	@Column(nullable = false)
	private LocalDateTime kraj;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usluga_id")
	private Usluga usluga;
	
	
	
}
