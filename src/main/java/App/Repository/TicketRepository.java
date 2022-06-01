package App.Repository;

import App.Entity.Flight;
import App.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findTicketByFlightAndPlace(Flight flight, String place);
}