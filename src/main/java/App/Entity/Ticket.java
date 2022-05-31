package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
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
}