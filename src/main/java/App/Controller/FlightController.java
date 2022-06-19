package App.Controller;

import App.DTO.RequestFlightDTO;
import App.DTO.ResponseFlightDTO;
import App.Service.Impl.FlightServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FlightController {
    private FlightServiceImpl flightService;

    @GetMapping("/flight/search/borders")
    public List<ResponseFlightDTO> flightInBorders (@RequestParam String dateFrom, @RequestParam String dateTo) {
        return flightService.flightInBorders(dateFrom, dateTo);
    }
    @DeleteMapping("/flight/delete")
    public String deleteFlight(@RequestBody RequestFlightDTO requestFlightDTO) {
        return flightService.deleteFlight(requestFlightDTO);
    }
}