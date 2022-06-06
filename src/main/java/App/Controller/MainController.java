package App.Controller;

import App.DTO.RequestPassengerDTO;
import App.DTO.RequestTicketDTO;
import App.DTO.ResponsePassengerDTO;
import App.DTO.ResponseTicketDTO;
import App.Entity.Flight;
import App.Repository.FlightRepository;
import App.Repository.PassengerRepository;
import App.Service.Impl.PassengerServiceImpl;
import App.Service.Impl.TicketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TimeZone;

@RestController
@AllArgsConstructor
public class MainController {
    private PassengerRepository passengerRepository;
    private PassengerServiceImpl passengerService;
    private TicketServiceImpl ticketService;
    private FlightRepository flightRepository;
    @PostMapping("/registration/")
    public String registration(@RequestBody RequestPassengerDTO passengerDTO) {
        passengerService.registration(passengerDTO);
        return "Registered";
    }
    @GetMapping("/passenger/all/")
    public List<ResponsePassengerDTO> getAll() {
        return passengerService.getAll();
    }
    @PostMapping("/buyingTickets/")
    public ResponseTicketDTO buyTickets (@RequestBody RequestTicketDTO ticketDTO) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return ticketService.buyTickets(ticketDTO);
    }
    @GetMapping("/search/flight/borders/")
    public String flightInBorders (@RequestParam String dateFrom, @RequestParam String dateTo) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        List<Flight> flightsInBorders = flightRepository.flightsInBorders(dateFrom, dateTo);
        return flightsInBorders.toString();
    }
}