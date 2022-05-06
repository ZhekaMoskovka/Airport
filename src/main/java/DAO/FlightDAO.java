package DAO;

import Entity.Flight;

import java.util.List;

public interface FlightDAO {
    Flight add(Flight flight);
    Flight update(Flight flight);
    boolean delete(Flight flight);
    Flight get (int id);
    List<Flight> getAll();
}