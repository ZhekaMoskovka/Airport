package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity(name = "airlines")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
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
}