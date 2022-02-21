package DAO;

import Entity.Passenger;

import java.util.List;

public interface PassengerDAO {
    Passenger add(Passenger passenger);
    Passenger update(Passenger passenger);
    boolean delete(Passenger passenger);
    Passenger get (int id);
    List<Passenger> getAll();
}