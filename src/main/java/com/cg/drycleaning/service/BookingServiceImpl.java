package com.cg.drycleaning.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drycleaning.beans.Booking;
import com.cg.drycleaning.dao.IBookingRepository;
import com.cg.drycleaning.exception.EmptyEntityListException;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.exception.EntityDeletionException;
import com.cg.drycleaning.exception.EntityNotFoundException;
import com.cg.drycleaning.exception.EntityUpdationException;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository bookingRepository;

	@Override
	public Booking addBooking(Booking booking) {
		try {
			Booking booking1 = bookingRepository.save(booking);
			return booking1;
		} catch (Exception e) {
			throw new EntityCreationException("Failed to Create Booking.");
		}
	}

	@Override
	public Booking removeBooking(long bookingId) {
		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		Booking booking = null;
		if (optionalBooking.isPresent()) {
			booking = optionalBooking.get();
			bookingRepository.deleteById(bookingId);
			return booking;
		} else {
			throw new EntityDeletionException("Booking With Id " + bookingId + " does Not Exist.");
		}

	}

	@Override
	public Booking updateBooking(long bookingId, Booking booking) {
		Optional<Booking> optionalBooking = null;
		Booking booking1 = null;

		optionalBooking = bookingRepository.findById(bookingId);
		if (optionalBooking.isPresent()) {
			booking1 = bookingRepository.save(booking);
			return booking1;
		} else {
			throw new EntityUpdationException("Booking With Id " + bookingId + "is Not Found.");
		}
	}

	@Override
	public Booking getBooking(long bookingId) {
		Booking booking1 = null;

		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if (optionalBooking.isPresent()) {
			booking1 = optionalBooking.get();
			return booking1;
		} else {
			throw new EntityNotFoundException("Booking With Id " + bookingId + " does Not Exist.");
		}
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> allBookings = new ArrayList<Booking>();
		allBookings = bookingRepository.findAll();
		if (!allBookings.isEmpty()) {
			return allBookings;
		} else {
			throw new EmptyEntityListException("No Bookings Found.");
		}
	}

	@Override
	public List<Booking> getBookingsByDate(LocalDate localDate) {
		List<Booking> bookings = new ArrayList<Booking>();

		bookings = bookingRepository.getBookingsByDate(localDate);
		if (!bookings.isEmpty()) {
			return bookings;
		} else {
			throw new EmptyEntityListException("No Bookings Found.");
		}
	}

	@Override
	public List<Booking> getBookingsByCustomer(String customerId) {
		List<Booking> bookings = new ArrayList<Booking>();

		bookings = bookingRepository.getBookingsByCustomer(customerId);
		if (!bookings.isEmpty()) {
			return bookings;
		} else {
			throw new EmptyEntityListException("No Bookings Found.");
		}
	}

}
