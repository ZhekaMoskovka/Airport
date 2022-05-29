package App.Repository;

import App.Entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
}
