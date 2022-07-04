package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double salary;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "work_type_id", referencedColumnName = "id")
    //one employee have only one workType and one work type have many employee
    private WorkType workType;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "gate", referencedColumnName = "gate")})
    //one terminal have many employee and one employee can work on many terminals
    private List<Terminal> terminals;

    @Override
    //custom toString without recursion
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", workType=" + workType.getName() +
                ", terminals=" + terminals +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(workType.getId(), employee.workType.getId()) && Objects.equals(terminals, employee.terminals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, workType, terminals);
    }
}