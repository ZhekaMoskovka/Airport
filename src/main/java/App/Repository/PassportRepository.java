package App.Repository;

import App.Entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
    Passport findPassportByPassportNumber(String passportNumber);
}