package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    private int id;
    @Column(name = "place_from")
    private String placeFrom;
    @Column(name = "place_to")
    private String placeTo;
}