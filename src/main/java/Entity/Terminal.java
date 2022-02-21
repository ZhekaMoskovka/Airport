package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "terminals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {
    @Id
    private String gate;
    private String name;
}