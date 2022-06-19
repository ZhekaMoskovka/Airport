package App.Service.Impl;

import App.DTO.Mapper.MapStructToResponseTicketDTO;
import App.DTO.RequestTicketDTO;
import App.DTO.ResponseTicketDTO;
import App.Entity.Flight;
import App.Entity.Passenger;
import App.Entity.Route;
import App.Entity.Ticket;
import App.Repository.FlightRepository;
import App.Repository.PassengerRepository;
import App.Repository.RouteRepository;
import App.Repository.TicketRepository;
import App.Service.TicketService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
        log.info("Ticket service buy tickets from requestTicketDTO = " + ticketDTO);
        passenger = passengerRepository.findPassengerByName(ticketDTO.getName());
        log.info("Search passenger by name = " + ticketDTO.getName());
        if (passenger.getPassport().getPassportNumber().equals(ticketDTO.getPassportNumber())) {
            log.info("Check correct passport number (true)");
            route = routeRepository.findRouteByPlaceFromAndPlaceTo(ticketDTO.getPlaceFrom(), ticketDTO.getPlaceTo());
            log.info("Search route by placeFrom = " + ticketDTO.getPlaceFrom() + " and placeTo = " + ticketDTO.getPlaceTo());
            flight = flightRepository.findFlightByRouteIdAndTime(route.getId(), ticketDTO.getTime());
            log.info("Search flight by route_id = " + route.getId() + " and time = " + ticketDTO.getTime());
            ticket = ticketRepository.findTicketByFlightAndPlace(flight, ticketDTO.getPlace());
            log.info("Search ticket by flight = " + flight + " and place = " + ticketDTO.getPlace());
            if (ticket.getPassenger() == null) {
                log.info("Ticket's passenger is null");
                ticket.setPassenger(passenger);
                log.info("Set ticket's passenger = " + passenger);
                ticketRepository.save(ticket);
                return mapStructToResponseTicketDTO.mapToResponseTicketDTO(ticket, flight, route);
            } else {
                log.info("Ticket's passenger isn't null");
                return null;
            }
        } else {
            log.info("Check correct passport number (false)");
            return null;
        }

    }
}