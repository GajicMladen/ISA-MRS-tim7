package tim7.ISAMRSproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ocena {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Column(name = "ocena",nullable = false)
	private int ocena;
	
	@Column(name= "revizija" ,nullable = false)
	private String revizija;
	
	@Column(name= "status",nullable = false)
	private StatusOdobravanja status;

	@OneToOne(mappedBy = "ocena")
    private Rezervacija rezervacija;
	
	
}
