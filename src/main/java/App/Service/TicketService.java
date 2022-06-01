package App.Service;

import App.DTO.RequestTicketDTO;

public interface TicketService {
    boolean buyTickets (RequestTicketDTO ticketDTO);
}