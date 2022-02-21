package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "airlines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airline {
    @Id
    private int id;
    private String name;
    private double rating;
    private String planes;
}