package App.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return id == passport.id && Objects.equals(passenger.getId(), passport.passenger.getId()) && Objects.equals(passportNumber, passport.passportNumber) && Objects.equals(birthday, passport.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passenger, passportNumber, birthday);
    }
}