package com.crs.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crs.dao.BookingsDAO;
import com.crs.model.Bookings;

@Repository
public class BookingsDAOImpl implements BookingsDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Bookings> getBookings() {
		
		return sessionfactory.getCurrentSession().createQuery("from Bookings").list();
	}
	
	@Override
	public void saveBooking(Bookings bookings) {
		sessionfactory.getCurrentSession().save(bookings);
	
	}

	@Override
	public void updateBooking(Bookings bookings) {
		sessionfactory.getCurrentSession().update(bookings);
		
	}

	@Override
	public void deleteBooking(Bookings bookings) {
		sessionfactory.getCurrentSession().delete(bookings);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bookings> getBookingsbyCustomerId(int id) {
		return sessionfactory.getCurrentSession().createQuery("from Bookings where customer_id = '"+id+ "'").list();
	}

	@Override
	public Bookings getBookingbyId(int id) {
		return (Bookings)sessionfactory.getCurrentSession().createQuery("from Bookings where id = '"+id+ "'").uniqueResult();
	}
}
