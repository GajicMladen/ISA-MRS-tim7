package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tim7.ISAMRSproject.model.Boat;

public interface BoatRepository extends JpaRepository<Boat, Integer> {
}