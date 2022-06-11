package App.Service.Impl;

import App.DTO.RequestRouteDTO;
import App.Entity.Flight;
import App.Entity.Route;
import App.Entity.Ticket;
import App.Repository.RouteRepository;
import App.Service.RouteService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    @Setter(onMethod = @__({@Autowired}))
    private RouteRepository routeRepository;
    @Override
    public String deleteRoute(RequestRouteDTO requestRouteDTO) {
        Route route = routeRepository.findRouteByPlaceFromAndPlaceTo(requestRouteDTO.getPlaceFrom(), requestRouteDTO.getPlaceTo());
        for (Flight flight: route.getFlights()) {
            List<Ticket> tickets = flight.getTickets();
            for (Ticket ticket: tickets) {
                ticket.setPassenger(null);
            }
            flight.setAirline(null);
            flight.setTerminal(null);
        }
        routeRepository.delete(route);
        return "Route deleted";
    }
}
