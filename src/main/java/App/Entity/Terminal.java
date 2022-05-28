package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "terminals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {
    @Id
    @GeneratedValue
    private String gate;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "terminals")
    //one terminal have many employee and one employee can work on many terminals
    private List<Employee> employee;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "terminal")
    //one terminal can handle many flights but one flight can be handled only by one terminal
    private List<Flight> flight;
    //default toString
}