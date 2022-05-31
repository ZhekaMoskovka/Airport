package App.Repository;

import App.Entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}