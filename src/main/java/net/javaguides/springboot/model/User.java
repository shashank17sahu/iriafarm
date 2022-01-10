package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "land_area")
	private String land_area;
	
	@Column(name = "worker")
	private String worker;
	
	@Column(name = "infrastructure")
	private String infrastructure;
	
	@Column(name = "contract_year")
	private String contract_year;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	
	public User() {
		
	}
	

	public User(String firstName, String lastName, String location, String land_area, String worker,
			String infrastructure, String contract_year, String phone_number) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.land_area = land_area;
		this.worker = worker;
		this.infrastructure = infrastructure;
		this.contract_year = contract_year;
		this.phone_number = phone_number;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getLand_area() {
		return land_area;
	}


	public void setLand_area(String land_area) {
		this.land_area = land_area;
	}


	public String getWorker() {
		return worker;
	}


	public void setWorker(String worker) {
		this.worker = worker;
	}


	public String getInfrastructure() {
		return infrastructure;
	}


	public void setInfrastructure(String infrastructure) {
		this.infrastructure = infrastructure;
	}


	public String getContract_year() {
		return contract_year;
	}


	public void setContract_year(String contract_year) {
		this.contract_year = contract_year;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	
	
	
	
	
	
	
	
	
}
