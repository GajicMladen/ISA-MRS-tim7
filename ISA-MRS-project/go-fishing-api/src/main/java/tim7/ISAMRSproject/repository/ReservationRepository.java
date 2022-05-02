package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tim7.ISAMRSproject.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
