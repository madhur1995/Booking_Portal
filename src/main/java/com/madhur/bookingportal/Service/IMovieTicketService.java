package com.madhur.bookingportal.Service;

import com.madhur.bookingportal.Entity.MovieTicket;
import com.madhur.bookingportal.Exception.BookingPortalServiceException;

public interface IMovieTicketService {

	String bookTicket(MovieTicket ticketDetails) throws BookingPortalServiceException;

}
