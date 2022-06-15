package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tim7.ISAMRSproject.model.Boat;

import java.util.List;

public interface BoatRepository extends JpaRepository<Boat,Integer>{

	@Query("select COUNT(*) from Boat")
	public Integer getTotalBoats();
  
    @Query("select v from Boat v where v.boatOwner.id = ?1")
    public List<Boat> findByOwnerId(Integer ownerId);

    @Transactional
    @Modifying
    @Query(value = "update Boat b set b.name = ?2 , b.promoDescription = ?3 , b.price = ?4, b.capacity = ?5 where b.id = ?1")
    void updateBoat(Integer boatId,String name,String promoDescription,float price, int capacity);
}

