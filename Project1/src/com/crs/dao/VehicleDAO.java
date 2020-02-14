package com.crs.dao;

import java.util.List;

import com.crs.model.Vehicle;

public interface VehicleDAO {

	List<Vehicle> getVehicles();
	void SaveVehicle(Vehicle vehicle);
	void UpdateVehicle(Vehicle vehicle);
	void DeleteVehicle(Vehicle vehicle);
	Vehicle getVehiclebyId(int id);
	List<Vehicle> getAvailableVehicles();
		
	
}
