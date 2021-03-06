package App.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    //one route have many flights but one flight have only one route
    private Route route;
    private Calendar time;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    //one airline have many flights but one flight can be done only by one airline
    private Airline airline;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "gate", referencedColumnName = "gate")
    //one terminal can handle many flights but one flight can be handled only by one terminal
    private Terminal terminal;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "flight")
    //one flight have many tickets but one ticket can be only for one flight
    private List<Ticket> tickets;
    private String status;

    @Override
    //custom toString without recursion
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", place from=" + route.getPlaceFrom() +
                ", place to=" + route.getPlaceTo() +
                ", time='" + time + '\'' +
                ", airline=" + airline.getName() +
                ", terminal=" + terminal.getName() +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && Objects.equals(route.getId(), flight.route.getId()) && Objects.equals(time, flight.time) && Objects.equals(airline.getId(), flight.airline.getId()) && Objects.equals(terminal.getGate(), flight.terminal.getGate()) && Objects.equals(tickets, flight.tickets) && Objects.equals(status, flight.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, route, time, airline, terminal, tickets, status);
    }
}