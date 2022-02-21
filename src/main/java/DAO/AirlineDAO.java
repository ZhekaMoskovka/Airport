package DAO;

import Entity.Airline;
import java.util.List;

public interface AirlineDAO {
    Airline add(Airline airline);
    Airline update(Airline airline);
    boolean delete(Airline airline);
    Airline get (int id);
    List<Airline> getAll();
}