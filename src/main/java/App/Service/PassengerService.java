package App.Service;

import App.DTO.RequestPassengerDTO;
import App.DTO.ResponsePassengerDTO;

import java.util.List;

public interface PassengerService {
    void registration(RequestPassengerDTO passengerDTO);
    List<ResponsePassengerDTO> getAll();
}