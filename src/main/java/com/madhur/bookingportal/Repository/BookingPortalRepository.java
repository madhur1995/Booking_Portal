package com.madhur.bookingportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhur.bookingportal.Entity.BookingPortal;

public interface BookingPortalRepository extends JpaRepository<BookingPortal, Integer>  {

}
