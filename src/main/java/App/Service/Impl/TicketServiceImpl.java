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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private PassengerRepository passengerRepository;
    private PassportRepository passportRepository;
    private TicketRepository ticketRepository;
    private RouteRepository routeRepository;
    private FlightRepository flightRepository;
    private MapStructToResponseTicketDTO mapStructToResponseTicketDTO;
    private Passenger passenger = new Passenger();
    private Ticket ticket = new Ticket();
    private Route route = new Route();
    private Flight flight = new Flight();

    @Override
    public ResponseTicketDTO buyTickets(RequestTicketDTO ticketDTO) {
        passenger = passengerRepository.findPassengerByName(ticketDTO.getName());
        if (passenger.getPassport().getPassportNumber().equals(ticketDTO.getPassportNumber())){
            route = routeRepository.findRouteByPlaceFromAndPlaceTo(ticketDTO.getPlaceFrom(), ticketDTO.getPlaceTo());
            flight = flightRepository.findFlightByRouteIdAndTime(route.getId(), ticketDTO.getTime());
            ticket = ticketRepository.findTicketByFlightAndPlace(flight, ticketDTO.getPlace());
            if (ticket.getPassenger() == null) {
                ticket.setPassenger(passenger);
                ticketRepository.save(ticket);
                return mapStructToResponseTicketDTO.mapToResponseTicketDTO(ticket, flight, route);
            }
            else {
                return null;
            }
        }
        else {

            return null;
        }

    }
    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Autowired
    public void setPassportRepository(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Autowired
    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Autowired
    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Autowired
    public void setMapStructToResponseTicketDTO(MapStructToResponseTicketDTO mapStructToResponseTicketDTO) {
        this.mapStructToResponseTicketDTO = mapStructToResponseTicketDTO;
    }
}