package App.Service.Impl;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passenger;
import App.Service.PassengerService;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {
    Passenger passenger;

    @Override
    public Passenger registration(RequestPassengerDTO passengerDTO) {
        return passenger;
    }
}