package com.madhur.bookingportal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madhur.bookingportal.Entity.BookingPortal;
import com.madhur.bookingportal.Entity.MovieTicket;
import com.madhur.bookingportal.Exception.BookingPortalServiceException;
import com.madhur.bookingportal.Service.IBookingPortalService;
import com.madhur.bookingportal.Service.IMovieTicketService;

@RestController
@RequestMapping("/BookingPortal")
public class BookingPortalController {

	@Autowired
	IBookingPortalService bookingPortalService;

	@Autowired
	IMovieTicketService ticketService;

	@PostMapping(value = "/add")
	public ResponseEntity<?> addBookingPortal(@RequestBody BookingPortal portalDetails) {

		try {
			return new ResponseEntity<>(bookingPortalService.addBookingPortal(portalDetails), HttpStatus.ACCEPTED);
		} catch (BookingPortalServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(value = "/book")
	public ResponseEntity<?> bookTicket(@RequestBody MovieTicket ticketDetails) throws BookingPortalServiceException {

		return new ResponseEntity<>(ticketService.bookTicket(ticketDetails), HttpStatus.ACCEPTED);

	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> deleteBooingPortal(@RequestParam int portalId) {

		try {
			return new ResponseEntity<>(bookingPortalService.deletePortal(portalId), HttpStatus.ACCEPTED);
		} catch (BookingPortalServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<?> getAll() {

		return new ResponseEntity<List<BookingPortal>>(bookingPortalService.getAll(), HttpStatus.OK);
	}

}
