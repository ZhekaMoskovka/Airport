package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "work_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkType {
    @Id
    private int id;
    private String name;
}