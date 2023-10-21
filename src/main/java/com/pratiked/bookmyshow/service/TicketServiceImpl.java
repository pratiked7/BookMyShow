package com.pratiked.bookmyshow.service;

import com.pratiked.bookmyshow.exception.ShowSeatNotAvailableException;
import com.pratiked.bookmyshow.models.ShowSeat;
import com.pratiked.bookmyshow.models.Ticket;
import com.pratiked.bookmyshow.models.User;
import com.pratiked.bookmyshow.models.constants.ShowSeatStatus;
import com.pratiked.bookmyshow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TicketServiceImpl implements TicketService{

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, User user) throws ShowSeatNotAvailableException {

        //TODO: optimise the DB calls

        for(Integer showSeatId : showSeatIds){
            ShowSeat seat = showSeatRepository.findById(showSeatId).get();
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("Show seat is not available");
            }
        }

        for(Integer showSeatId : showSeatIds){
            ShowSeat seat = showSeatRepository.findById(showSeatId).get();
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(seat);
        }

        return new Ticket();
    }
}
