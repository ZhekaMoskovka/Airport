package App.Service.Impl;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passenger;
import App.Entity.Passport;
import App.Service.PassengerService;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {
    Passenger passenger;

    @Override
    public Passenger registration(RequestPassengerDTO passengerDTO) {
        Passport passport = new Passport();
        passport.setPassportNumber(passengerDTO.getPassportNumber());
        passport.setBirthday(passengerDTO.getBirthday());
        System.out.println(passenger.builder()
                .name(passengerDTO.getName())
                .passport(passport)
                .build());
        return passenger.builder()
                .name(passengerDTO.getName())
                .passport(passport)
                .build();
    }
}