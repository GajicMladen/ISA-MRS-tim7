package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tim7.ISAMRSproject.model.Offer;
import tim7.ISAMRSproject.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByOffer_IdEquals(Integer id);
    
    @Query("select r from Reservation r where r.startDateTime >= ?1 and r.startDateTime <= ?2")
	List<Reservation> findAllByDateRange(LocalDateTime start, LocalDateTime end);


}
