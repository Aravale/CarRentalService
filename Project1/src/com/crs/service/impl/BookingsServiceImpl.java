package com.crs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crs.dao.BookingsDAO;
import com.crs.model.Bookings;
import com.crs.service.BookingsService;

@Service
public class BookingsServiceImpl implements BookingsService {

	@Autowired
	BookingsDAO bookingsDAO;
	

	@Transactional
	public void saveBooking(Bookings bookings) {
		bookingsDAO.saveBooking(bookings);
	}

	@Transactional
	public void updateBooking(Bookings bookings) {
		bookingsDAO.updateBooking(bookings);
	}

	@Transactional
	public void deleteBooking(Bookings bookings) {
		bookingsDAO.deleteBooking(bookings);
	}

	@Transactional
	public List<Bookings> getBookings() {
		return bookingsDAO.getBookings();
	}

	@Transactional
	public List<Bookings> getBookingsbyCustomerId(int id) {
		return bookingsDAO.getBookingsbyCustomerId(id);
	}

	@Transactional
	public Bookings getBookingbyId(int id) {
		return bookingsDAO.getBookingbyId(id);
	}
}
