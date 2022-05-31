package tim7.ISAMRSproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Boat extends Offer {

	public BoatOwner getBoatOwner() {
		return boatOwner;
	}

	public void setBoatOwner(BoatOwner boatOwner) {
		this.boatOwner = boatOwner;
	}

	@Column(name = "type",nullable = false)
	private String type;
	
	@Column(name = "length",nullable = false)
	private float length;
	
	@Column(name = "motorsCount",nullable = false)
	private int motorsCount;
	
	@Column(name = "motorPower",nullable = false)
	private float motorPower;
	
	@Column(name = "maxSpeed",nullable = false)
	private float maxSpeed;
	
	@Column(name ="cancelConditions",nullable = false)
	private String cancelConditions;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vlasnik_id")
	private BoatOwner boatOwner;
	
	
	public Boat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boat(Integer id, String naziv, String promoOpis, List<String> slike, List<String> pravilaPonasanja, float cena,
				int kapacitet) {
		super(id, naziv, promoOpis, cena, kapacitet);
	}

	public Boat(Integer id, String naziv, String promoOpis, List<String> slike, List<String> pravilaPonasanja, float cena,
				int kapacitet, String type, float length, int motorsCount, float motorPower, float maxSpeed,
				String cancelConditions) {
		super(id, naziv, promoOpis, cena, kapacitet);
		this.type = type;
		this.length = length;
		this.motorsCount = motorsCount;
		this.motorPower = motorPower;
		this.maxSpeed = maxSpeed;
		this.cancelConditions = cancelConditions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public int getMotorsCount() {
		return motorsCount;
	}

	public void setMotorsCount(int motorsCount) {
		this.motorsCount = motorsCount;
	}

	public float getMotorPower() {
		return motorPower;
	}

	public void setMotorPower(float motorPower) {
		this.motorPower = motorPower;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getCancelConditions() {
		return cancelConditions;
	}

	public void setCancelConditions(String cancelConditions) {
		this.cancelConditions = cancelConditions;
	}
	
	
}
