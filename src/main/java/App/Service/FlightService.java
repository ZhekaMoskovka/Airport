package App.Service;

import App.DTO.RequestFlightDTO;
import App.DTO.ResponseFlightDTO;

import java.util.List;

public interface FlightService {
    List<ResponseFlightDTO> flightInBorders(String dateFrom, String dateTo);
    String deleteFlight(RequestFlightDTO requestFlightDTO);
}