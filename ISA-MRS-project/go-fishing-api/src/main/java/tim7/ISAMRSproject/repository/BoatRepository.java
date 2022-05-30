package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Cottage;

import java.util.List;

public interface BoatRepository extends JpaRepository<Boat, Integer> {

    @Query("select v from Boat v where v.boatOwner.id = ?1")
    public List<Boat> findByOwnerId(Integer ownerId);

}