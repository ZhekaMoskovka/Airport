package App.DTO.Mapper;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Mapper
public interface MapStructToPassenger {
    @Mapping(target = "passport", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "passwordEncoder")
    Passenger mapToPassenger(RequestPassengerDTO passengerDTO);

    @Named("passwordEncoder")
    static String passwordEncoder(String password) {
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        return passwordEncoder.encode(password);
    }
}