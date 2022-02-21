package Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    private int id;
    @Column(name = "route_id")
    private int routeId;
    private String time;
    @Column(name = "airline_id")
    private int airlineId;
    private String status;
}