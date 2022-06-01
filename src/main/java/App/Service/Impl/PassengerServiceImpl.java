package App.Service.Impl;

import App.DTO.Mapper.MapStructToPassenger;
import App.DTO.Mapper.MapStructToPassport;
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
    private Passport passport;
    private MapStructToPassenger mapStructToPassenger;
    private MapStructToPassport mapStructToPassport;

    @Override
    public boolean registration(RequestPassengerDTO passengerDTO) {
        passenger = mapStructToPassenger.mapToPassenger(passengerDTO);
        passport = mapStructToPassport.mapToPassport(passengerDTO);
        passenger.setPassport(passport);
        passport.setPassenger(passenger);
        passengerRepository.save(passenger);
        return true;
    }
}