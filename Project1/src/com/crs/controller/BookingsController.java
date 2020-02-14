package com.crs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crs.model.Bookings;
import com.crs.model.Customer;
import com.crs.model.Vehicle;
import com.crs.service.BookingsService;
import com.crs.service.CustomerService;
import com.crs.service.VehicleService;

@Controller
@RequestMapping("/booking")
public class BookingsController {

	@Autowired
	private BookingsService bookservice;
	
	@Autowired
	private VehicleService vehservice;
	
	@Autowired
	private CustomerService custservice;
	
	@RequestMapping("/ViewBookings")
    public ModelAndView viewbookings(
    		@RequestParam("id") String id
    		) {
        ModelAndView mv = new ModelAndView("ViewBookings");
        List<Vehicle> availablevehicles = vehservice.getAvailableVehicles();
        List<Bookings> bookings = bookservice.getBookingsbyCustomerId(Integer.parseInt(id));
        mv.addObject("customerid",id);
        mv.addObject("bookings",bookings);
        mv.addObject("availablevehicles",availablevehicles);
        return mv;       
    }
	
	@RequestMapping("/managebookings")
    public ModelAndView managebookings() {
        ModelAndView mv = new ModelAndView("managebookings");       
        List<Bookings> bookings = bookservice.getBookings();
        mv.addObject("bookings",bookings);
        return mv;       
    }
	
	@RequestMapping("/cancelBooking")
	public ModelAndView cancelbooking(
			@RequestParam("bookid") String bookid,
			@RequestParam("custid") String id,
			@RequestParam("vehicleid") String vehid
			) {
		Bookings booking = new Bookings();
		booking = bookservice.getBookingbyId(Integer.parseInt(bookid));
		bookservice.deleteBooking(booking);
		Vehicle vehicle = vehservice.getVehiclebyId(Integer.parseInt(vehid));
		vehicle.setStatus("Available");
		vehservice.updateVehicle(vehicle);				
		return viewbookings(id);
	}
	
	@RequestMapping("/cancelBooking")
	public ModelAndView cancelbooking(
			@RequestParam("bookid") String bookid,
			@RequestParam("vehicleid") String vehid
			) {
		Bookings booking = new Bookings();
		booking = bookservice.getBookingbyId(Integer.parseInt(bookid));
		bookservice.deleteBooking(booking);
		Vehicle vehicle = vehservice.getVehiclebyId(Integer.parseInt(vehid));
		vehicle.setStatus("Available");
		vehservice.updateVehicle(vehicle);				
		return managebookings();
	}
	
	@RequestMapping("/bookVehicle")
	public ModelAndView bookveh(HttpServletRequest request
			/*@RequestParam("custid") String id,
			@RequestParam("vehid") String vehid,
			@RequestParam("days") String days*/
			) {
		String vehid=request.getParameter("vehid");
		String id=request.getParameter("custid");
		String days=request.getParameter("days");
		Bookings booking = new Bookings();
		Vehicle vehicle = vehservice.getVehiclebyId(Integer.parseInt(vehid));
		Customer customer = custservice.getCustomerById(Integer.parseInt(id));
		int totaldays = Integer.parseInt(days);
		vehicle.setStatus("Booked");
		vehservice.updateVehicle(vehicle);
		booking.setCustomer(customer);
		booking.setVehicle(vehicle);
		booking.setDays(totaldays);
		booking.setTotalrent();
		bookservice.saveBooking(booking);
		
		ModelAndView mv = new ModelAndView("ViewBookings");
		mv.addObject("id",id);
		return mv;
		
	}
}
