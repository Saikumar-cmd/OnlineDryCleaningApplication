package com.cg.drycleaning.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.drycleaning.beans.Booking;

public interface IBookingService {

	Booking addBooking(Booking booking);

	Booking removeBooking(long bookingId);

	Booking updateBooking(long bookingId, Booking booking);

	Booking getBooking(long bookingId);

	List<Booking> getAllBookings();

	List<Booking> getBookingsByDate(LocalDate localDate);

	List<Booking> getBookingsByCustomer(String customerId);
}