package App.Service;

import App.DTO.RequestTicketDTO;
import App.DTO.ResponseTicketDTO;

public interface TicketService {
    ResponseTicketDTO buyTickets (RequestTicketDTO ticketDTO);
}