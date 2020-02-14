package com.crs.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.crs.dao.VehicleDAO;
import com.crs.model.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getVehicles() {
		
		return sessionfactory.getCurrentSession().createQuery("from Vehicle").list();
	}
	
	@Override
	public void SaveVehicle(Vehicle vehicle) {
		sessionfactory.getCurrentSession().save(vehicle);
		
	}

	@Override
	public void UpdateVehicle(Vehicle vehicle) {
		sessionfactory.getCurrentSession().update(vehicle);
		
	}

	@Override
	public void DeleteVehicle(Vehicle vehicle) {

		sessionfactory.getCurrentSession().delete(vehicle);
	}

	@Override
	public Vehicle getVehiclebyId(int id) {
		return (Vehicle)sessionfactory.getCurrentSession().createQuery("from Vehicle where id = '"+id+"'").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getAvailableVehicles() {
		
		return sessionfactory.getCurrentSession().createQuery("from Vehicle where status = 'Available'").list();
	}

}
