package App.Repository;

import App.Entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepositiry extends JpaRepository<Passport, Integer> {
}
