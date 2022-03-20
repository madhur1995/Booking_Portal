package com.madhur.bookingportal.Service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhur.bookingportal.Controller.SortTicket;
import com.madhur.bookingportal.Entity.BookingPortal;
import com.madhur.bookingportal.Exception.BookingPortalNotFoundException;
import com.madhur.bookingportal.Exception.BookingPortalServiceException;
import com.madhur.bookingportal.Exception.DuplicateNameException;
import com.madhur.bookingportal.Repository.BookingPortalRepository;

@Service
@Transactional
public class BookingPortalService implements IBookingPortalService {

	@Autowired
	BookingPortalRepository portalRepo;

	@Override
	public String addBookingPortal(BookingPortal portalDetails) throws BookingPortalServiceException {

		List<BookingPortal> portalList = portalRepo.findAll();

		for (BookingPortal bookingPortal : portalList) {
			if (bookingPortal.getBookingPortalName().equalsIgnoreCase(portalDetails.getBookingPortalName())) {
				throw new DuplicateNameException("Name already Exists");
			}
		}

		portalRepo.save(portalDetails);

		return "Booking portal added";
	}

	@Override
	public String deletePortal(int portalId) throws BookingPortalServiceException {

		BookingPortal portal = portalRepo.findById(portalId).orElse(null);

		if (portal == null) {
			throw new BookingPortalNotFoundException("No portal found with entered id");
		}

		portalRepo.deleteById(portalId);

		return "Booking portal deleted";
	}

	@Override
	public List<BookingPortal> getAll() {
		List<BookingPortal> list = portalRepo.findAll();

		for (BookingPortal bookingPortal : list) {
			Collections.sort(bookingPortal.getTicketList(), new SortTicket());
			bookingPortal.toString();
		}
		return list;

	}
}