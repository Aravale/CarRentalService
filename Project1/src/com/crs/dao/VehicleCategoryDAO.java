package com.crs.dao;

import java.util.List;

import com.crs.model.VehicleCategory;

public interface VehicleCategoryDAO {
	List<VehicleCategory> getVehicleCategories();
	VehicleCategory getCategory(String vehcat);
}
