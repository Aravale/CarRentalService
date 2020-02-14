package com.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crs.model.Vehicle;
import com.crs.model.VehicleCategory;
import com.crs.service.VehicleCategoryService;
import com.crs.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehservice;
	
	@Autowired
	private VehicleCategoryService vehctservice;
	
	@RequestMapping("/ViewVehicles")
	public ModelAndView viewvehicles(){
		ModelAndView mv = new ModelAndView("ViewVehicle");
		List<Vehicle> vc=vehservice.getVehicleList();
		mv.addObject("vc", vc);
		return mv;
	}
	
	@RequestMapping("/AddVehicle")
	public ModelAndView land(){
	
		ModelAndView mv = new ModelAndView("AddVehicle");
		//List<VehicleCategory> vc=vehctservice.getVehicleCategories();
		//mv.addObject("vc", vc);
		return mv;
	}
	
	@RequestMapping("/deleteVehicle")
	public ModelAndView delVehicle(
			@RequestParam("id") String id) {
		Vehicle veh = vehservice.getVehiclebyId(Integer.parseInt(id));
		vehservice.deleteVehicle(veh);
				
		return viewvehicles();		
		
	}
	
	@RequestMapping("/editVehicle")
	public ModelAndView updatelanding(
			@RequestParam("id") String id
			) {
		
		Vehicle result = vehservice.getVehiclebyId(Integer.parseInt(id));		
		ModelAndView mv = new ModelAndView("vehicleupdate");
		mv.addObject("vehiclecategory",result.getVehiclecategory());
		mv.addObject("vehicle",result);
		return mv;		
	}
	
	@RequestMapping("/UpdateVehicle")
	public ModelAndView updateVehicle(
			@RequestParam("id") String id,
			@RequestParam("manufacturer") String manufacturer,
			@RequestParam("make") String make,
			@RequestParam("model") String model,
			@RequestParam("color") String color,
			@RequestParam("perdayrent") String perdayrent,
			@RequestParam("vcategory") String vcategory) {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(Integer.parseInt(id));
		vehicle.setManufacturer(manufacturer);
		vehicle.setMake(make);
		vehicle.setModel(model);
		vehicle.setColor(color);
		vehicle.setPerdayrent(Integer.parseInt(perdayrent));
		VehicleCategory vcid=vehctservice.getCategory(vcategory);
		vehicle.setVehiclecategory(vcid);
		vehservice.updateVehicle(vehicle);
		return viewvehicles();
		
	}
	
	
	
	@RequestMapping("/vehicleadd")
	public ModelAndView vhcladd(
			@RequestParam("manufacturer") String manufacturer,
			@RequestParam("make") String make,
			@RequestParam("model") String model,
			@RequestParam("color") String color,
			@RequestParam("perdayrent") String perdayrent,
			@RequestParam("vcategory") String vcategory
			){
		
		Vehicle vehicle = new Vehicle();
		vehicle.setManufacturer(manufacturer);
		vehicle.setMake(make);
		vehicle.setModel(model);
		vehicle.setStatus("Available");
		vehicle.setColor(color);
		vehicle.setPerdayrent(Integer.parseInt(perdayrent));
		System.out.println(vcategory);
		VehicleCategory vcid=vehctservice.getCategory(vcategory);
		vehicle.setVehiclecategory(vcid);
		vehservice.saveVehicle(vehicle);
	
		return viewvehicles();
	}
}
