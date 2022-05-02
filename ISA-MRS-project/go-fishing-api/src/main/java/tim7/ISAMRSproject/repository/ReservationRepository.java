package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim7.ISAMRSproject.model.Rezervacija;

public interface ReservationRepository extends JpaRepository<Rezervacija, Integer> {

}
