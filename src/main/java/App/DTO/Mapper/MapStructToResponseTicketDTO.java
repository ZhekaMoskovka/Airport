package App.DTO.Mapper;

import App.DTO.ResponseTicketDTO;
import App.Entity.Flight;
import App.Entity.Route;
import App.Entity.Ticket;
import org.mapstruct.Mapper;

@Mapper
public interface MapStructToResponseTicketDTO {
    ResponseTicketDTO mapToResponseTicketDTO (Ticket ticket, Flight flight, Route route);
}