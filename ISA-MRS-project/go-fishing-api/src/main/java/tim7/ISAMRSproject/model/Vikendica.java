package tim7.ISAMRSproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vikendica extends Usluga{
		

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vlasnik_id")
	private VlasnikVikendice vlasnikVikendice;
	
	
	
}
