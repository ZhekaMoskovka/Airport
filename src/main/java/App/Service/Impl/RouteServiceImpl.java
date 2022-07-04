package App.Service.Impl;

import App.DTO.RequestRouteDTO;
import App.Entity.Flight;
import App.Entity.Route;
import App.Entity.Ticket;
import App.Repository.RouteRepository;
import App.Service.RouteService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RouteServiceImpl implements RouteService {
    @Setter(onMethod = @__({@Autowired}))
    private RouteRepository routeRepository;
    @Override
    public String deleteRoute(RequestRouteDTO requestRouteDTO) {
        log.info("Route service delete route from requestRouteDTO = " + requestRouteDTO);
        Route route = routeRepository.findRouteByPlaceFromAndPlaceTo(requestRouteDTO.getPlaceFrom(), requestRouteDTO.getPlaceTo());
        log.info("Search route by placeFrom = " + requestRouteDTO.getPlaceFrom() + " and placeTo = " + requestRouteDTO.getPlaceTo());
        for (Flight flight: route.getFlights()) {
            List<Ticket> tickets = flight.getTickets();
            log.info("Get flight's tickets");
            for (Ticket ticket: tickets) {
                ticket.setPassenger(null);
            }
            log.info("Set tickets' passenger as null");
            flight.setAirline(null);
            log.info("Set flight's airline as null");
            flight.setTerminal(null);
            log.info("Set flight's terminal as null");
        }
        routeRepository.delete(route);
        return "Route deleted";
    }
}
