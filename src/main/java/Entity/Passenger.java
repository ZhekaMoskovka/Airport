package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "passengers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "passenger")
    private Passport passport;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger", fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", passport=" + passport.getPassportNumber() +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}