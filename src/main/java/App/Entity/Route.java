package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "place_from")
    private String placeFrom;
    @Column(name = "place_to")
    private String placeTo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "route")
    //one route have many flights but one flight have only one route
    private List<Flight> flights;
    //default toString
}