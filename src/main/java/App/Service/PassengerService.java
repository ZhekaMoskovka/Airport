package App.Service;

import App.DTO.RequestPassengerDTO;
import App.DTO.ResponsePassengerDTO;

import java.util.List;

public interface PassengerService {
    String registration(RequestPassengerDTO requestPassengerDTO);
    List<ResponsePassengerDTO> getAll();
    String deletePassenger(RequestPassengerDTO requestPassengerDTO);
}