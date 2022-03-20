package com.madhur.bookingportal.Service;

import java.util.List;

import com.madhur.bookingportal.Entity.BookingPortal;
import com.madhur.bookingportal.Exception.BookingPortalServiceException;

public interface IBookingPortalService {
	
	public String addBookingPortal (BookingPortal portalDetails) throws BookingPortalServiceException;

	public String deletePortal( int portalId) throws BookingPortalServiceException;

	public List<BookingPortal> getAll ();


}

