package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}