package App.Repository;

import App.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query(value = "select * from flights where time = :time and route_id = :route_id", nativeQuery = true)
    Flight findFlightByRouteIdAndTime(@Param("route_id")int routeId, @Param("time")String time);
    @Query(value = "select * from flights where time between :dateFrom and :dateTo", nativeQuery = true)
    List<Flight> flightsInBorders(@Param("dateFrom") String dateFrom, @Param("dateTo")String dateTo);
}