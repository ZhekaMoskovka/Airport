package App.Service;

import App.DTO.RequestTicketDTO;
import App.DTO.ResponseTicketDTO;

import java.util.List;

public interface TicketService {
    ResponseTicketDTO buyTickets (RequestTicketDTO ticketDTO);
    List<ResponseTicketDTO> getTickets();
    String deleteTicket(RequestTicketDTO requestTicketDTO);
}