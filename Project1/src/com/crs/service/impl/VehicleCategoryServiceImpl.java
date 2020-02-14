package com.crs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crs.dao.VehicleCategoryDAO;
import com.crs.model.VehicleCategory;
import com.crs.service.VehicleCategoryService;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService{
	
	@Autowired
	private VehicleCategoryDAO vehiclecategoryDAO;

	@Transactional
	public List<VehicleCategory> getVehicleCategories() {
		return vehiclecategoryDAO.getVehicleCategories();
	}

	@Transactional
	public VehicleCategory getCategory(String vehcat) {
		return vehiclecategoryDAO.getCategory(vehcat);
	}

}
