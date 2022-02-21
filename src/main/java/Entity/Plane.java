package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plane {
    @Id
    private int id;
    private String name;
}