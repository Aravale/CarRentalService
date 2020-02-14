package com.crs.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crs.dao.VehicleCategoryDAO;
import com.crs.model.VehicleCategory;

@Repository
public class VehicleCategoryDAOImpl implements VehicleCategoryDAO {
	
	@Autowired
	private SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleCategory> getVehicleCategories() {
		
		return sessionfactory.getCurrentSession().createQuery("from VehicleCategory").list();
	}

	@Override
	public VehicleCategory getCategory(String vehcat) {
		VehicleCategory result = (VehicleCategory) sessionfactory.getCurrentSession().createQuery("from VehicleCategory where categoryName = '"+vehcat+"'").uniqueResult();
		return result;
	}		
}
