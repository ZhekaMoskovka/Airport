package App.Service.Impl;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passenger;
import App.Entity.Passport;
import App.Repository.PassportRepository;
import App.Service.PassengerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    Passenger passenger;
    PassportRepository passportRepository;

    @Override
    public Passenger registration(RequestPassengerDTO passengerDTO) {
        Passport passport = new Passport();
        passport.setPassportNumber(passengerDTO.getPassportNumber());
        passport.setBirthday(passengerDTO.getBirthday());
        passportRepository.save(passport);
        return passenger.builder()
                .name(passengerDTO.getName())
                .passport(passport)
                .build();
    }
}