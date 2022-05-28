package App.Controller;

import App.Entity.Passenger;
import App.Repository.PassengerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PassengerController {
    private PassengerRepository passengerRepository;
    @GetMapping("/hello/")
    public String hello() {
        Passenger passenger;
        passenger = passengerRepository.getById(1);
        System.out.println(passenger);
        return passenger.toString();
    }
}
