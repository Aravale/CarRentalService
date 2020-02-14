package com.crs.service;

import java.util.List;

import com.crs.model.VehicleCategory;

public interface VehicleCategoryService {
	List<VehicleCategory> getVehicleCategories();
	VehicleCategory getCategory(String vehcat);

}
