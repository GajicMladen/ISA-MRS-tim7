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
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
	@Column(name = "pocetak",nullable = false)
	private LocalDateTime pocetak;

	@Column(name = "kraj",nullable = false)
	private LocalDateTime kraj;	

	@Column(name = "ukupnaCena",nullable = false)
	private float ukupnaCena;
	
	@Column(name = "statusRezervacije" , nullable = false)
	private  StatusRezervacije status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "klijent_id")
	private Klijent klijent;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usluga_id")
	private Usluga usluga; 
	
	@OneToOne
	@JoinColumn(name = "ocena", referencedColumnName = "id",nullable = true)
	private Ocena ocena;     

	@OneToOne
	@JoinColumn(name = "zalba", referencedColumnName = "id",nullable = true)
	private Ocena zalba;  
	
	
	
}
