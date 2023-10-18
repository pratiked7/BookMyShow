package com.pratiked.bookmyshow.models;

import com.pratiked.bookmyshow.models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeat;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    private LocalDateTime timeOfBooking;
}
