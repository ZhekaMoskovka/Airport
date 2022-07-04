package App.DTO.Mapper;

import App.DTO.ResponsePassengerDTO;
import App.DTO.ResponseTicketDTO;
import App.Entity.Passenger;
import App.Entity.Passport;
import App.Entity.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MapToResponsePassengerDTO {
    private MapStructToResponseTicketDTO mapStructToResponseTicketDTO;
    public ResponsePassengerDTO mapToResponsePassengerDTO(Passenger passenger) {
        Passport passport = passenger.getPassport();
        List<Ticket> tickets = passenger.getTickets();
        List<ResponseTicketDTO> responseTicketDTOS = new ArrayList<>();
        for (Ticket ticket:tickets) {
            responseTicketDTOS.add(mapStructToResponseTicketDTO
                    .mapToResponseTicketDTO(ticket, ticket.getFlight(), ticket.getFlight().getRoute()));
        }
        return ResponsePassengerDTO.builder()
                .name(passenger.getName())
                .passportNumber(passport.getPassportNumber())
                .birthday(passport.getBirthday())
                .responseTicketDTO(responseTicketDTOS)
                .build();
    }
}