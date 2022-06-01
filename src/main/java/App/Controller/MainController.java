package App.Controller;

import App.DTO.RequestPassengerDTO;
import App.DTO.RequestTicketDTO;
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
        boolean isSuccess;
        isSuccess = passengerService.registration(passengerDTO);
        if (isSuccess) {
            return "Registered";
        }
        else {
            return "Something went wrong";
        }
    }
    @GetMapping("/passenger/all/")
    public String getAll() {
        return passengerRepository.findAll().toString();
    }
    @PostMapping("/buyingTickets/")
    public String buyTickets (@RequestBody RequestTicketDTO ticketDTO) {
        boolean isSuccess;
        isSuccess = ticketService.buyTickets(ticketDTO);
        if (isSuccess){
            return "You bought ticket(s)";
        }
        else {
            return "Something went wrong";
        }
    }
    @GetMapping("/search/flight/borders/")
    public String flightInBorders (@RequestParam String dateFrom, @RequestParam String dateTo) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        List<Flight> flightsInBorders = flightRepository.flightsInBorders(dateFrom, dateTo);
        return flightsInBorders.toString();
    }
    @GetMapping("/flights/")
    public String getFlights() {
        return flightRepository.findAll().toString();
    }
}