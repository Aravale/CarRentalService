package com.crs.service.impl;

import java.util.List;

import com.crs.dao.VehicleDAO;
import com.crs.model.Vehicle;
import com.crs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleDAO vehicleDAO;
	
	@Transactional
	public List<Vehicle> getVehicleList() {
		return vehicleDAO.getVehicles();
	}

	@Transactional
	public void saveVehicle(Vehicle vehicle) {
		vehicleDAO.SaveVehicle(vehicle);
		
	}

	@Transactional
	public void updateVehicle(Vehicle vehicle) {
		vehicleDAO.UpdateVehicle(vehicle);
		
	}

	@Transactional
	public void deleteVehicle(Vehicle vehicle) {
		vehicleDAO.DeleteVehicle(vehicle);
	}

	@Transactional
	public Vehicle getVehiclebyId(int id) {
		return vehicleDAO.getVehiclebyId(id);
	}

	@Transactional
	public List<Vehicle> getAvailableVehicles() {
		return vehicleDAO.getAvailableVehicles();
	}

}
