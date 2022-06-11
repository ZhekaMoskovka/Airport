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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Component
public class FlightServiceImpl implements FlightService {
    @Setter(onMethod = @__({@Autowired}))
    private FlightRepository flightRepository;
    @Setter(onMethod = @__({@Autowired}))
    private RouteRepository routeRepository;
    @Setter(onMethod = @__({@Autowired}))
    private MapStructToResponseFlightDTO mapStructToResponseFlightDTO;
    @Override
    public List<ResponseFlightDTO> flightInBorders(String dateFrom, String dateTo) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        List<Flight> flightsInBorders = flightRepository.flightsInBorders(dateFrom, dateTo);
        List<ResponseFlightDTO> responseFlightDTOS = new ArrayList<>();
        for (Flight flight : flightsInBorders) {
            responseFlightDTOS.add(mapStructToResponseFlightDTO.mapToResponseFlightDTO(flight, flight.getRoute(), flight.getTerminal()));
        }
        return responseFlightDTOS;
    }

    @Override
    public String deleteFlight(RequestFlightDTO requestFlightDTO) {
        Route route = routeRepository.findRouteByPlaceFromAndPlaceTo(requestFlightDTO.getPlaceFrom(), requestFlightDTO.getPlaceTo());
        Flight flight = flightRepository.findFlightByRouteIdAndTime(route.getId(), requestFlightDTO.getTime());
        List<Ticket> tickets = flight.getTickets();
        for (Ticket ticket: tickets) {
            ticket.setPassenger(null);
        }
        flight.setAirline(null);
        flight.setRoute(null);
        flight.setTerminal(null);
        flightRepository.delete(flight);
        return "Flight deleted";
    }
}