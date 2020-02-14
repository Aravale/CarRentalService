package com.crs.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1291031229449129532L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	

	@Column
	private String manufacturer;
	
	@Column
	private String model;
	
	@Column 
	private String make;
	
	@Column
	private String color;
	
	@Column
	private String status;
	
	@Column
	private int perdayrent;
	
	@ManyToOne (fetch =FetchType.EAGER)
	@JoinColumn (name="vcategory_id")
	private VehicleCategory vehiclecategory;
	
	@OneToMany(mappedBy = "vehicle")
	private Set<Bookings> bookings;
	
	

	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public VehicleCategory getVehiclecategory() {
		return vehiclecategory;
	}

	public void setVehiclecategory(VehicleCategory vehiclecategory) {
		this.vehiclecategory = vehiclecategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPerdayrent() {
		return perdayrent;
	}

	public void setPerdayrent(int perdayrent) {
		this.perdayrent = perdayrent;
	}
	
	
}
