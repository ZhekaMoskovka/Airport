package App.Service;

import App.DTO.RequestPassengerDTO;
import App.Entity.Passenger;

public interface PassengerService {
    Passenger registration(RequestPassengerDTO passengerDTO);
}