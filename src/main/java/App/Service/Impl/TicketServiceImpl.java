package App.Service.Impl;

import App.DTO.RequestTicketDTO;
import App.Entity.*;
import App.Repository.*;
import App.Service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    PassengerRepository passengerRepository;
    PassportRepository passportRepository;
    TicketRepository ticketRepository;
    RouteRepository routeRepository;
    FlightRepository flightRepository;
    Passenger passenger;
    Passport passport;
    Ticket ticket;
    Route route;
    Flight flight;
    @Override
    public boolean buyTickets(RequestTicketDTO ticketDTO) {
        passenger = passengerRepository.findPassengerByName(ticketDTO.getName());
        passport = passportRepository.findPassportByPassportNumber(ticketDTO.getPassportNumber());
        if (passenger.getPassport().equals(passport)){
            route = routeRepository.findRouteByPlaceFromAndPlaceTo(ticketDTO.getPlaceFrom(), ticketDTO.getPlaceTo());
            flight = flightRepository.findFlightByRouteAndTime(route, ticketDTO.getTime());
            ticket = ticketRepository.findTicketByFlightAndPlace(flight, ticketDTO.getPlace());
            if (ticket.getPassenger() == null) {
                ticket.setPassenger(passenger);
                ticketRepository.save(ticket);
                return true;
            }
            else {
                return false;
            }
        }
        else {

            return false;
        }
    }
}