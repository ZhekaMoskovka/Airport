package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "passports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    //one passenger have only one passport
    private Passenger passenger;
    private String passportNumber;
    private LocalDate birthday;

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
