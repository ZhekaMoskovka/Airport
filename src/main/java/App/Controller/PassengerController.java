package App.Controller;

import App.DTO.RequestPassengerDTO;
import App.DTO.ResponsePassengerDTO;
import App.Service.Impl.PassengerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TimeZone;

@RestController
@AllArgsConstructor
public class PassengerController {
    private PassengerServiceImpl passengerService;

    @PostMapping("/registration")
    public String registration(@RequestBody RequestPassengerDTO passengerDTO) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return passengerService.registration(passengerDTO);
    }
    @GetMapping("/passenger/all")
    public List<ResponsePassengerDTO> getAll() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return passengerService.getAll();
    }
    @DeleteMapping("/delete/passenger")
    public String deletePassenger(@RequestBody RequestPassengerDTO requestPassengerDTO) {
        return passengerService.deletePassenger(requestPassengerDTO);
    }
}