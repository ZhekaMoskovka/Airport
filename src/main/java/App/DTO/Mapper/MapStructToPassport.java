package App.DTO.Mapper;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapStructToPassport {
    @Mapping(target = "passenger", ignore = true)
    Passport mapToPassport (RequestPassengerDTO passengerDTO);
}