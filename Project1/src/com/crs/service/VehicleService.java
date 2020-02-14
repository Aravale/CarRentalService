package com.crs.service;

import java.util.List;

import com.crs.model.Vehicle;

public interface VehicleService {

	List<Vehicle> getVehicleList();
	void saveVehicle(Vehicle vehicle);
	void updateVehicle(Vehicle vehicle);
	void deleteVehicle(Vehicle vehicle);
	Vehicle getVehiclebyId(int id);
	List<Vehicle> getAvailableVehicles();

	
}
