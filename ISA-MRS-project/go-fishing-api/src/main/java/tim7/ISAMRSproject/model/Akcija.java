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
public class Akcija {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Column(name = "datumPocetka",nullable = false)
	private LocalDateTime datumPocetka;
	
	@Column(name = "datumKraja",nullable = false)
	private LocalDateTime datumKraja;

	@Column(name ="maxOsoba",nullable = false)
	private int maxOsoba;
	
	@Column(name ="cena" , nullable = false)
	private float cena;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usluga_id")
	private Usluga usluga;
}
