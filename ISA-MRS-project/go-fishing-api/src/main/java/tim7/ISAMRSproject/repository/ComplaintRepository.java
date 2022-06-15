package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tim7.ISAMRSproject.model.Complaint;

import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
    Optional<Complaint> findByReservation_IdEqualsAndFormOwnerIsTrue(Integer id);


}
