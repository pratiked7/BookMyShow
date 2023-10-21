package com.pratiked.bookmyshow.service;

import com.pratiked.bookmyshow.exception.ShowSeatNotAvailableException;
import com.pratiked.bookmyshow.models.ShowSeat;
import com.pratiked.bookmyshow.models.Ticket;
import com.pratiked.bookmyshow.models.User;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(List<Integer> showSeatIds, User user) throws ShowSeatNotAvailableException;
}
