package com.cg.drycleaning.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.drycleaning.beans.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {

	@Query(value = "SELECT booking FROM Booking booking WHERE booking.customerDetails.userId=:customerId")
	List<Booking> getBookingsByCustomer(@Param(value = "customerId") String customerId);

	@Query(value = "SELECT booking FROM Booking booking WHERE booking.bookingDate=:localDate")
	List<Booking> getBookingsByDate(@Param(value = "localDate") LocalDate localDate);

}