package com.madhur.bookingportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhur.bookingportal.Entity.MovieTicket;

public interface MovieTicketRepository extends JpaRepository<MovieTicket, Integer> {

}
