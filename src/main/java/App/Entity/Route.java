package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id && Objects.equals(placeFrom, route.placeFrom) && Objects.equals(placeTo, route.placeTo) && Objects.equals(flights, route.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placeFrom, placeTo, flights);
    }
}