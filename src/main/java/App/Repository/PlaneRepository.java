package App.Repository;

import App.Entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Integer> {
}