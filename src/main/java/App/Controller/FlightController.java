package App.Controller;

import App.DTO.RequestFlightDTO;
import App.DTO.ResponseFlightDTO;
import App.Service.Impl.FlightServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class FlightController {
    private FlightServiceImpl flightService;

    @GetMapping("/flight/search/borders")
    public List<ResponseFlightDTO> flightInBorders (@RequestParam String dateFrom, @RequestParam String dateTo) {
        log.info("Flight controller search flight in borders");
        return flightService.flightInBorders(dateFrom, dateTo);
    }
    @DeleteMapping("/flight/delete")
    public String deleteFlight(@RequestBody RequestFlightDTO requestFlightDTO) {
        log.info("Flight controller delete flight");
        return flightService.deleteFlight(requestFlightDTO);
    }
}