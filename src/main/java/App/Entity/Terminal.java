package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "terminals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private List<Flight> flights;
    //default toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terminal terminal = (Terminal) o;
        return Objects.equals(gate, terminal.gate) && Objects.equals(name, terminal.name) && Objects.equals(employee, terminal.employee) && Objects.equals(flights, terminal.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gate, name, employee, flights);
    }
}