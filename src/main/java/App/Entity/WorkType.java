package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "work_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkType {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "workType")
    //one employee have only one workType and one work type have many employee
    private List<Employee> employee;
    //default toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkType workType = (WorkType) o;
        return id == workType.id && Objects.equals(name, workType.name) && Objects.equals(employee, workType.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employee);
    }
}