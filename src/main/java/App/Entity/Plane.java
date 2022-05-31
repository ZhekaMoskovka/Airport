package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
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