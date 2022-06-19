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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
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
        role = roleRepository.findRoleByRole("USER");
        passenger = mapStructToPassenger.mapToPassenger(requestPassengerDTO);
        passport = mapStructToPassport.mapToPassport(requestPassengerDTO);
        passenger.setRoles(new HashSet<>());
        passenger.getRoles().add(role);
        passenger.setPassport(passport);
        passport.setPassenger(passenger);
        role.getPassengers().add(passenger);
        passengerRepository.save(passenger);
        return "Registered";
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

    @Override
    public String deletePassenger(RequestPassengerDTO requestPassengerDTO) {
        passenger = passengerRepository.findPassengerByName(requestPassengerDTO.getName());
        if (passenger.getPassport().getPassportNumber().equals(requestPassengerDTO.getPassportNumber())){
            for (Ticket ticket: passenger.getTickets()) {
                ticket.setPassenger(null);
            }
            passenger.setTickets(null);
            passengerRepository.delete(passenger);
            return "Passenger deleted";
        }
        else {
            return "Wrong passport number";
        }
    }
}