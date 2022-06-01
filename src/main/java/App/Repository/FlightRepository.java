package App.Repository;

import App.Entity.Flight;
import App.Entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findFlightByRouteAndTime(Route route, String time);
    @Query(value = "select * from flights where time between :dateFrom and :dateTo", nativeQuery = true)
    List<Flight> flightsInBorders(@Param("dateFrom") String dateFrom, @Param("dateTo")String dateTo);
}