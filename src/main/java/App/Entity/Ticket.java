package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private String place;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    //one flight have many tickets but one ticket can be only for one flight
    private Flight flight;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    //one passenger have many tickets but one ticket have only one passenger
    private Passenger passenger;

    @Override
    //custom toString without recursion
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", flight=" + flight +
                ", passenger=" + passenger.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Objects.equals(place, ticket.place) && Objects.equals(flight.getId(), ticket.flight.getId()) && Objects.equals(passenger.getId(), ticket.passenger.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, flight, passenger);
    }
}