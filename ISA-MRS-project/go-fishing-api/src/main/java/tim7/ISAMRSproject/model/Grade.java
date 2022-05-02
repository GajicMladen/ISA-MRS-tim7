package tim7.ISAMRSproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Grade {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Column(name = "grade",nullable = false)
	private int grade;
	
	@Column(name= "revision" ,nullable = false)
	private String revision;
	
	@Column(name= "status",nullable = false)
	private ApprovalStatus status;

	@OneToOne(mappedBy = "grade")
    private Reservation reservation;
	
	
}
