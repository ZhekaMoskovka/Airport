package App.Repository;

import App.Entity.Flight;
import App.Entity.Passenger;
import App.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findTicketByFlightAndPlace(Flight flight, String place);
    List<Ticket> findTicketsByPassenger(Passenger passenger);
}