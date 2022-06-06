package App.Service.Impl;

import App.DTO.Mapper.MapStructToPassenger;
import App.DTO.Mapper.MapStructToPassport;
import App.DTO.Mapper.MapToResponsePassengerDTO;
import App.DTO.RequestPassengerDTO;
import App.DTO.ResponsePassengerDTO;
import App.Entity.Passenger;
import App.Entity.Passport;
import App.Repository.PassengerRepository;
import App.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    private Passenger passenger = new Passenger();
    private PassengerRepository passengerRepository;
    private Passport passport = new Passport();
    private MapStructToPassenger mapStructToPassenger;
    private MapStructToPassport mapStructToPassport;
    private MapToResponsePassengerDTO mapToResponsePassengerDTO;

    @Override
    public void registration(RequestPassengerDTO passengerDTO) {
        passenger = mapStructToPassenger.mapToPassenger(passengerDTO);
        passport = mapStructToPassport.mapToPassport(passengerDTO);
        passenger.setPassport(passport);
        passport.setPassenger(passenger);
        passengerRepository.save(passenger);
    }

    @Override
    public List<ResponsePassengerDTO> getAll() {
        List<Passenger> passengers = passengerRepository.findAll();
        List<ResponsePassengerDTO> passengerDTOS = new ArrayList<>();
        for (Passenger passenger: passengers) {
            passengerDTOS.add(mapToResponsePassengerDTO.mapToResponsePassengerDTO(passenger));
        }
        return passengerDTOS;
    }

    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Autowired
    public void setMapStructToPassenger(MapStructToPassenger mapStructToPassenger) {
        this.mapStructToPassenger = mapStructToPassenger;
    }

    @Autowired
    public void setMapStructToPassport(MapStructToPassport mapStructToPassport) {
        this.mapStructToPassport = mapStructToPassport;
    }

    @Autowired
    public void setMapToResponsePassengerDTO(MapToResponsePassengerDTO mapToResponsePassengerDTO) {
        this.mapToResponsePassengerDTO = mapToResponsePassengerDTO;
    }
}