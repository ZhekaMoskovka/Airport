package App.Service.Impl;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passenger;
import App.Entity.Passport;
import App.Repository.PassengerRepository;
import App.Service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private Passenger passenger;
    private PassengerRepository passengerRepository;

    @Override
    public Passenger registration(RequestPassengerDTO passengerDTO) {
        Passport passport = new Passport();
        passenger.setName(passengerDTO.getName());
        passport.setPassportNumber(passengerDTO.getPassportNumber());
        passport.setBirthday(passengerDTO.getBirthday());
        passenger.setPassport(passport);
        passport.setPassenger(passenger);
        passengerRepository.save(passenger);
        return passenger;
    }
}