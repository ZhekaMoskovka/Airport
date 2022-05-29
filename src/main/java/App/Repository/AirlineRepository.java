package App.Repository;

import App.Entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
