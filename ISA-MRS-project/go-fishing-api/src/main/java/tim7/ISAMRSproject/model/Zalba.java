package tim7.ISAMRSproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.websocket.OnError;

@Entity
public class Zalba {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "text",nullable = false)
    private String text;
    
    @Column(name = "status",nullable = false)
    private StatusOdobravanja status;
    

	@OneToOne(mappedBy = "zalba")
    private Rezervacija rezervacija;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "klijent_id")
	private Klijent klijent;
}
