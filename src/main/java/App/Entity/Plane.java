package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Plane {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(joinColumns = {@JoinColumn(name = "plane_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "airline_id", referencedColumnName = "id")})
    //one airline have many planes and one plane consist in many airlines
    private List<Airline> airlines;
    //default toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return id == plane.id && Objects.equals(name, plane.name) && Objects.equals(airlines, plane.airlines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, airlines);
    }
}