package com.crs.service;

import java.util.List;

import com.crs.model.Bookings;

public interface BookingsService {

	void saveBooking(Bookings bookings);
	void updateBooking(Bookings bookings);
	void deleteBooking(Bookings bookings);
	List<Bookings>  getBookingsbyCustomerId(int id);	
	List<Bookings>  getBookings();
	Bookings getBookingbyId(int id);

}
