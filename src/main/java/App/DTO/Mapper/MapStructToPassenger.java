package App.DTO.Mapper;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapStructToPassenger {
    @Mapping(target = "passport", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    Passenger mapToPassenger(RequestPassengerDTO passengerDTO);
}