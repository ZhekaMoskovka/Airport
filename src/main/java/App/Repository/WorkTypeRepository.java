package App.Repository;

import App.Entity.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTypeRepository extends JpaRepository<WorkType, Integer> {
}
