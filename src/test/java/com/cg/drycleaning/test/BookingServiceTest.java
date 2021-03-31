package com.cg.drycleaning.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.drycleaning.beans.Booking;
import com.cg.drycleaning.service.IBookingService;

@SpringBootTest
public class BookingServiceTest {

	@Autowired
	private IBookingService iBookingService;

	@Test
	public void addBookingTest() {
		Booking booking1 = new Booking(1001L, LocalDate.now(), null, "Drycleaning", null);
		assertEquals(1001L, iBookingService.addBooking(booking1).getBookingId());
	}

	@Test
	public void removeBookingTest() {
		Booking booking1 = new Booking(1002L, LocalDate.now(), null, "Drycleaning", null);
		iBookingService.addBooking(booking1);
		assertEquals("Drycleaning", iBookingService.removeBooking(1002L).getServiceType());
	}

	@Test
	public void updateBookingTest() {
		Booking booking1 = new Booking(1003L, LocalDate.now(), null, "Drycleaning", null);
		iBookingService.addBooking(booking1);
		booking1.setBookingId(1004L);
		assertEquals(1004L, iBookingService.updateBooking(1001L, booking1).getBookingId());
	}

	@Test
	public void getBookingTest() {
		Booking booking1 = new Booking(1001L, LocalDate.now(), null, "Drycleaning", null);
		iBookingService.addBooking(booking1);
		assertEquals("Drycleaning", iBookingService.getBooking(1001L).getServiceType());
	}

	@Test
	public void getAllBookingTest() {
		assertEquals(4, iBookingService.getAllBookings().size());
	}

	@Test
	public void getBookingsByDateTest() {
		Booking booking1 = new Booking(1001L, LocalDate.now(), null, "Drycleaning", null);
		iBookingService.addBooking(booking1);
		assertEquals(1001L, iBookingService.getBookingsByDate(LocalDate.now()).get(0).getBookingId());
	}

	@Test
	public void getBookingsByCustomerTest() {
		Booking booking1 = new Booking(1001L, LocalDate.now(), null, "Drycleaning", null);
		iBookingService.addBooking(booking1);
		assertEquals("DryClean", iBookingService.getBookingsByCustomer("Santu").get(0).getServiceType());
	}
}
