package App.Service.Impl;

import App.DTO.Mapper.MapStructToResponseFlightDTO;
import App.DTO.RequestFlightDTO;
import App.DTO.ResponseFlightDTO;
import App.Entity.Flight;
import App.Entity.Route;
import App.Entity.Ticket;
import App.Repository.FlightRepository;
import App.Repository.RouteRepository;
import App.Service.FlightService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Component
@Slf4j
public class FlightServiceImpl implements FlightService {
    @Setter(onMethod = @__({@Autowired}))
    private FlightRepository flightRepository;
    @Setter(onMethod = @__({@Autowired}))
    private RouteRepository routeRepository;
    @Setter(onMethod = @__({@Autowired}))
    private MapStructToResponseFlightDTO mapStructToResponseFlightDTO;
    @Override
    public List<ResponseFlightDTO> flightInBorders(String dateFrom, String dateTo) {
        log.info("Flight service search flight in borders (dateFrom = " + dateFrom + " dateTo = " + dateTo + ")");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        List<Flight> flightsInBorders = flightRepository.flightsInBorders(dateFrom, dateTo);
        log.info("Search list of flights with repository");
        List<ResponseFlightDTO> responseFlightDTOS = new ArrayList<>();
        for (Flight flight : flightsInBorders) {
            responseFlightDTOS.add(mapStructToResponseFlightDTO.mapToResponseFlightDTO(flight, flight.getRoute(), flight.getTerminal()));
        }
        log.info("Mapping list of flights to list of responseFlightDTOS");
        return responseFlightDTOS;
    }

    @Override
    public String deleteFlight(RequestFlightDTO requestFlightDTO) {
        log.info("Flight service delete flight: requestFlightDTO = " + requestFlightDTO);
        Route route = routeRepository.findRouteByPlaceFromAndPlaceTo(requestFlightDTO.getPlaceFrom(), requestFlightDTO.getPlaceTo());
        log.info("Search route by placeFrom = " + requestFlightDTO.getPlaceFrom() + " and placeTo = " + requestFlightDTO.getPlaceTo());
        Flight flight = flightRepository.findFlightByRouteIdAndTime(route.getId(), requestFlightDTO.getTime());
        log.info("Search flight by route_id = " + route.getId() + " and time = " + requestFlightDTO.getTime());
        List<Ticket> tickets = flight.getTickets();
        log.info("Forming list of tickets from flight");
        for (Ticket ticket: tickets) {
            ticket.setPassenger(null);
        }
        log.info("Set tickets' passenger as null");
        flight.setAirline(null);
        log.info("Set flight's airline as null");
        flight.setRoute(null);
        log.info("Set flight's route as null");
        flight.setTerminal(null);
        log.info("Set flight's terminal as null");
        flightRepository.delete(flight);
        return "Flight deleted";
    }
}