package com.crs.dao;

import java.util.List;

import com.crs.model.Bookings;

public interface BookingsDAO {
	
	void saveBooking(Bookings bookings);
	void updateBooking(Bookings bookings);
	void deleteBooking(Bookings bookings);
	List<Bookings>  getBookings();
	List<Bookings>  getBookingsbyCustomerId(int id);
	Bookings getBookingbyId(int id);
}
