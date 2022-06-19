package App.Controller;

import App.DTO.RequestPassengerDTO;
import App.DTO.ResponsePassengerDTO;
import App.Service.Impl.PassengerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TimeZone;

@RestController
@AllArgsConstructor
@Slf4j
public class PassengerController {
    private PassengerServiceImpl passengerService;

    @PostMapping("/passenger/registration")
    public String registration(@RequestBody RequestPassengerDTO passengerDTO) {
        log.info("Passenger controller registration");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return passengerService.registration(passengerDTO);
    }
    @GetMapping("/passenger/all")
    public List<ResponsePassengerDTO> getAll() {
        log.info("Passenger controller get all passengers");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return passengerService.getAll();
    }
    @DeleteMapping("/passenger/delete")
    public String deletePassenger(@RequestBody RequestPassengerDTO requestPassengerDTO) {
        log.info("Passenger controller delete passenger");
        return passengerService.deletePassenger(requestPassengerDTO);
    }
}