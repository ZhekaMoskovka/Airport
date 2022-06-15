package App.Controller;

import App.DTO.*;
import App.Service.Impl.FlightServiceImpl;
import App.Service.Impl.PassengerServiceImpl;
import App.Service.Impl.TicketServiceImpl;
import App.Service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TimeZone;

@RestController
@AllArgsConstructor
public class MainController {
    private PassengerServiceImpl passengerService;
    private TicketServiceImpl ticketService;
    private FlightServiceImpl flightService;
    private RouteService routeService;
    @PostMapping("/registration/")
    public String registration(@RequestBody RequestPassengerDTO passengerDTO) {
        return passengerService.registration(passengerDTO);
    }
    @GetMapping("/passenger/all/")
    public List<ResponsePassengerDTO> getAll() {
        return passengerService.getAll();
    }
    @PostMapping("/buying-tickets/")
    public ResponseTicketDTO buyTickets (@RequestBody RequestTicketDTO ticketDTO) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return ticketService.buyTickets(ticketDTO);
    }
    @GetMapping("/search/flight/borders/")
    public List<ResponseFlightDTO> flightInBorders (@RequestParam String dateFrom, @RequestParam String dateTo) {
        return flightService.flightInBorders(dateFrom, dateTo);
    }
    @DeleteMapping("/delete/flight/")
    public String deleteFlight(@RequestBody RequestFlightDTO requestFlightDTO) {
        return flightService.deleteFlight(requestFlightDTO);
    }
    @DeleteMapping("/delete/route/")
    public String deleteRoute(@RequestBody RequestRouteDTO requestRouteDTO) {
        return routeService.deleteRoute(requestRouteDTO);
    }
    @DeleteMapping("/delete/passenger/")
    public String deleteRoute(@RequestBody RequestPassengerDTO requestPassengerDTO) {
        return passengerService.deletePassenger(requestPassengerDTO);
    }

    @GetMapping("/hello/")
    public String hello() {
        return "Hello";
    }
}