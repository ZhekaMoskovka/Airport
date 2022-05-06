package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "work_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkType {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "workType")
    //one employee have only one workType and one work type have many employee
    private List<Employee> employee;
    //default toString
}