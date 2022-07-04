package App.Controller;

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
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TicketControllerTest {
    @Setter(onMethod = @__({@Autowired}))
    TicketController ticketController;
    @Setter(onMethod = @__({@Autowired}))
    PassengerRepository passengerRepository;
    @Setter(onMethod = @__({@Autowired}))
    FlightRepository flightRepository;
    @Setter(onMethod = @__({@Autowired}))
    TicketRepository ticketRepository;
    @Setter(onMethod = @__({@Autowired}))
    RouteRepository routeRepository;
    RequestTicketDTO requestTicketDTO = RequestTicketDTO.builder()
            .name("Moroz Bogdan")
            .passportNumber("632574352")
            .place("560M")
            .placeFrom("Kiev")
            .placeTo("London")
            .time("2022-04-12 19:40:00")
            .build();
    ResponseTicketDTO responseTicketDTO = ResponseTicketDTO.builder()
            .place("560M")
            .placeFrom("Kiev")
            .placeTo("London")
            .time("2022-04-12T19:40:00.000Z")
            .build();

    @Test
    void buyTickets() {
        assertEquals(ticketController.buyTickets(requestTicketDTO), responseTicketDTO);
        Passenger passenger = passengerRepository.findPassengerByName(requestTicketDTO.getName());
        Route route = routeRepository.findRouteByPlaceFromAndPlaceTo(requestTicketDTO.getPlaceFrom(),
                                                                     requestTicketDTO.getPlaceTo());
        Flight flight = flightRepository.findFlightByRouteIdAndTime(route.getId(), requestTicketDTO.getTime());
        Ticket ticket = ticketRepository.findTicketByFlightAndPlace(flight, requestTicketDTO.getPlace());
        assertEquals(passenger.getTickets().get(1), ticket);
    }
}