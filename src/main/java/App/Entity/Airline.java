package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "airlines")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airline {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double rating;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "airlines")
    //one airline have many planes and one plane consist in many airlines
    private List<Plane> planes;
    //default toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return id == airline.id && Double.compare(airline.rating, rating) == 0 && Objects.equals(name, airline.name) && Objects.equals(planes, airline.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating, planes);
    }
}