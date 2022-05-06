package Logic;

import DAO.AirlineDAO;
import DAO.Impl.AirlineDAOImpl;
import DAO.Impl.PassengerDAOImpl;
import DAO.PassengerDAO;
import Entity.Passenger;

import java.util.List;

public class Main {
    private static AirlineDAO airlineDAO = new AirlineDAOImpl();
    private static PassengerDAO passengerDAO = new PassengerDAOImpl();

    public static void main(String[] args) {
        List<Passenger> passengersList = passengerDAO.getAllWithTickets();
        for (int i = 0; i < passengersList.size(); i++) {
            System.out.println(passengersList.get(i));
        }
    }
}