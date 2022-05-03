package Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;
    private String time;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    private Airline airline;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "gate", referencedColumnName = "gate")
    private Terminal terminal;
    private String status;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", place from=" + route.getPlaceFrom() +
                ", place to=" + route.getPlaceTo()+
                ", time='" + time + '\'' +
                ", airline=" + airline.getName() +
                ", terminal=" + terminal.getName() +
                ", status='" + status + '\'' +
                '}';
    }
}