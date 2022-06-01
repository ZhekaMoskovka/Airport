package App.Service;

import App.DTO.RequestPassengerDTO;

public interface PassengerService {
    boolean registration(RequestPassengerDTO passengerDTO);
}