package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "passengers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "passenger")
    //one passenger have only one passport
    private Passport passport;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger", fetch = FetchType.LAZY)
    //one passenger have many tickets but one ticket have only one passenger
    private List<Ticket> tickets;

    @Override
    //custom toString without recursion
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", passport=" + passport.getPassportNumber() +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}