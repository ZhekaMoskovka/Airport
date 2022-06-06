package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "passports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passport {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    //one passenger have only one passport
    private Passenger passenger;
    private String passportNumber;
    private String birthday;

    @Override
    //custom toString without recursion
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passenger=" + passenger.getName() +
                ", passportNumber='" + passportNumber + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}