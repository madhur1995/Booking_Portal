package com.madhur.bookingportal.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhur.bookingportal.Entity.BookingPortal;
import com.madhur.bookingportal.Entity.MovieTicket;
import com.madhur.bookingportal.Exception.BookingPortalNotFoundException;
import com.madhur.bookingportal.Exception.BookingPortalServiceException;
import com.madhur.bookingportal.Repository.BookingPortalRepository;
import com.madhur.bookingportal.Repository.MovieTicketRepository;

@Service
@Transactional
public class MovieTicketService implements IMovieTicketService {

	@Autowired
	MovieTicketRepository ticketRepo;

	@Autowired
	BookingPortalRepository portalRepo;

	@Override
	public String bookTicket(MovieTicket ticketDetails) throws BookingPortalServiceException {

		Optional<BookingPortal>  portal = portalRepo.findById(ticketDetails.getBookingPortal().getBookingPortalId());

		if (portal == null) {
			throw new BookingPortalNotFoundException("No portal found with entered id");
		}

		ticketRepo.save(ticketDetails);

		return "Ticket booked";
	}
}
