package App.Service.Impl;

import App.DTO.Mapper.MapStructToPassenger;
import App.DTO.Mapper.MapStructToPassport;
import App.DTO.Mapper.MapToResponsePassengerDTO;
import App.DTO.RequestPassengerDTO;
import App.DTO.ResponsePassengerDTO;
import App.Entity.Passenger;
import App.Entity.Passport;
import App.Entity.Role;
import App.Entity.Ticket;
import App.Repository.PassengerRepository;
import App.Repository.RoleRepository;
import App.Service.PassengerService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class PassengerServiceImpl implements PassengerService {
    @Setter(onMethod = @__({@Autowired}))
    private PassengerRepository passengerRepository;
    @Setter(onMethod = @__({@Autowired}))
    private RoleRepository roleRepository;
    @Setter(onMethod = @__({@Autowired}))
    private MapStructToPassenger mapStructToPassenger;
    @Setter(onMethod = @__({@Autowired}))
    private MapStructToPassport mapStructToPassport;
    @Setter(onMethod = @__({@Autowired}))
    private MapToResponsePassengerDTO mapToResponsePassengerDTO;
    private Passenger passenger = new Passenger();
    private Passport passport = new Passport();
    private Role role = new Role();

    @Override
    public String registration(RequestPassengerDTO requestPassengerDTO) {
        log.info("Passenger service registration with requestPassengerDTO = " + requestPassengerDTO);
        role = roleRepository.findRoleByRole("USER");
        passenger = mapStructToPassenger.mapToPassenger(requestPassengerDTO);
        log.info("Mapping requestPassengerDTO to passenger");
        passport = mapStructToPassport.mapToPassport(requestPassengerDTO);
        log.info("Mapping requestPassengerDTO to passport");
        passenger.setRoles(new HashSet<>());
        passenger.getRoles().add(role);
        log.info("Set passenger's role as USER");
        passenger.setPassport(passport);
        log.info("Set passport to passenger");
        passport.setPassenger(passenger);
        log.info("Set passenger to passport");
        role.getPassengers().add(passenger);
        passengerRepository.save(passenger);
        return "Registered";
    }

    @Override
    public List<ResponsePassengerDTO> getAll() {
        log.info("Passenger service get all passengers");
        List<Passenger> passengers = passengerRepository.findAll();
        log.info("Get all passengers by repository");
        List<ResponsePassengerDTO> passengerDTOS = new ArrayList<>();
        for (Passenger passenger: passengers) {
            passengerDTOS.add(mapToResponsePassengerDTO.mapToResponsePassengerDTO(passenger));
        }
        log.info("Mapping all passengers to responsePassengersDTOS");
        return passengerDTOS;
    }

    @Override
    public String deletePassenger(RequestPassengerDTO requestPassengerDTO) {
        log.info("Passenger service delete passenger from requestPassengerDTO = " + requestPassengerDTO);
        passenger = passengerRepository.findPassengerByName(requestPassengerDTO.getName());
        log.info("Search passenger by name = " + requestPassengerDTO.getName());
        if (passenger.getPassport().getPassportNumber().equals(requestPassengerDTO.getPassportNumber())){
            log.info("Check correct passport number (true)");
            for (Ticket ticket: passenger.getTickets()) {
                ticket.setPassenger(null);
            }
            log.info("Set tickets' passenger as null");
            passenger.setTickets(null);
            log.info("Set passenger's tickets as null");
            for (Role role: passenger.getRoles()) {
                List<Passenger> passengers = role.getPassengers();
                passengers.remove(passenger);
                role.setPassengers(passengers);
            }
            passenger.setRoles(null);
            passengerRepository.delete(passenger);
            return "Passenger deleted";
        }
        else {
            log.info("Check correct passport number (false)");
            return "Wrong passport number";
        }
    }
}