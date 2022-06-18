package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import tim7.ISAMRSproject.model.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByOffer_IdEquals(Integer id);

    List<Reservation> findByClient_IdEquals(Integer id);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Reservation WHERE id = ?1")
    void cancelReservationById(Integer id);
}
