package tim7.ISAMRSproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ExtraFavor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String description;
	
	@ManyToMany
	@JoinTable(name = "dodatneUsluge", joinColumns = @JoinColumn(name = "dodatnaUsluga_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "usluga_id", referencedColumnName = "id"))
	private Set<Offer> offers = new HashSet<Offer>();
	

	
	public ExtraFavor() {
		super();
	}

	public ExtraFavor(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
