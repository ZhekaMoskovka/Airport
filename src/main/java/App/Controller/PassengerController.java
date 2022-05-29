package App.Controller;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passenger;
import App.Repository.PassengerRepository;
import App.Service.Impl.PassengerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PassengerController {
    private PassengerRepository passengerRepository;
    private PassengerServiceImpl passengerService;

    @GetMapping("/hello/")
    public String hello() {
        Passenger passenger;
        passenger = passengerRepository.getById(1);
        System.out.println(passenger);
        return passenger.toString();
    }

    @PostMapping("/registration/")
    public String registration(@RequestBody RequestPassengerDTO passengerDTO) {
        passengerService.registration(passengerDTO);
        return "Registered";
    }
    @GetMapping("/passenger/all")
    public String getAll() {
        List<Passenger> passengerList;

        return ;
    }
}