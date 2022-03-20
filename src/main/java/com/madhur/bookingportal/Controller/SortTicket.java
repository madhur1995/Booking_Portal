package com.madhur.bookingportal.Controller;

import java.util.Comparator;

import com.madhur.bookingportal.Entity.MovieTicket;

public class SortTicket implements Comparator<MovieTicket> {

	@Override
	public int compare(MovieTicket t1, MovieTicket t2) {
		if (t1.getPrice() < t2.getPrice()) {
			return 1;
		} else if (t1.getPrice() > t2.getPrice()) {
			return -1;
		} else
			return 0;

	}

}
