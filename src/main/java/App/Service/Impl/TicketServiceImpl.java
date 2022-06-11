package App.Service.Impl;

import App.DTO.Mapper.MapStructToResponseTicketDTO;
import App.DTO.RequestTicketDTO;
import App.DTO.ResponseTicketDTO;
import App.Entity.Flight;
import App.Entity.Passenger;
import App.Entity.Route;
import App.Entity.Ticket;
import App.Repository.*;
import App.Service.TicketService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Setter(onMethod = @__({@Autowired}))
    private PassengerRepository passengerRepository;
    @Setter(onMethod = @__({@Autowired}))
    private TicketRepository ticketRepository;
    @Setter(onMethod = @__({@Autowired}))
    private RouteRepository routeRepository;
    @Setter(onMethod = @__({@Autowired}))
    private FlightRepository flightRepository;
    @Setter(onMethod = @__({@Autowired}))
    private MapStructToResponseTicketDTO mapStructToResponseTicketDTO;
    private Passenger passenger = new Passenger();
    private Ticket ticket = new Ticket();
    private Route route = new Route();
    private Flight flight = new Flight();

    @Override
    public ResponseTicketDTO buyTickets(RequestTicketDTO ticketDTO) {
        passenger = passengerRepository.findPassengerByName(ticketDTO.getName());
        if (passenger.getPassport().getPassportNumber().equals(ticketDTO.getPassportNumber())) {
            route = routeRepository.findRouteByPlaceFromAndPlaceTo(ticketDTO.getPlaceFrom(), ticketDTO.getPlaceTo());
            flight = flightRepository.findFlightByRouteIdAndTime(route.getId(), ticketDTO.getTime());
            ticket = ticketRepository.findTicketByFlightAndPlace(flight, ticketDTO.getPlace());
            if (ticket.getPassenger() == null) {
                ticket.setPassenger(passenger);
                ticketRepository.save(ticket);
                return mapStructToResponseTicketDTO.mapToResponseTicketDTO(ticket, flight, route);
            } else {
                return null;
            }
        } else {

            return null;
        }

    }
}