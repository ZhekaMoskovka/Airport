package App.DTO.Mapper;

import App.DTO.ResponseFlightDTO;
import App.Entity.Flight;
import App.Entity.Route;
import App.Entity.Terminal;
import org.mapstruct.Mapper;

@Mapper
public interface MapStructToResponseFlightDTO {
    ResponseFlightDTO mapToResponseFlightDTO (Flight flight, Route route, Terminal terminal);
}