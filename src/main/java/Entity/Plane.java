package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}