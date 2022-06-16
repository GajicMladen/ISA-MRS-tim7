package tim7.ISAMRSproject.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tim7.ISAMRSproject.model.Boat;

public interface BoatRepository extends JpaRepository<Boat,Integer>{

  @Query("select COUNT(*) from Boat")
  public Integer getTotalBoats();
  
  @Query("select v from Boat v where v.boatOwner.id = ?1")
  public List<Boat> findByOwnerId(Integer ownerId);
  
  @Query("select c from Boat c inner join c.freePeriods freePeriods " +
          "where upper(c.name) like ?1 and c.price <= ?2 and c.price >= ?3 and c.rating >= ?4 and upper(c.address.city) like ?5 and c.capacity >= ?6 and freePeriods.startDateTime > ?7 and freePeriods.endDateTime < ?8")
  public List<Boat> getBoatsPageSearch(String name, float price, float price1, float rating, String city, int capacity, LocalDateTime startDateTime, LocalDateTime endDateTime, Pageable pageable);

	@Query("select COUNT(c) from Boat c inner join c.freePeriods freePeriods " +
          "where upper(c.name) like ?1 and c.price <= ?2 and c.price >= ?3 and c.rating >= ?4 and upper(c.address.city) like ?5 and c.capacity >= ?6 and freePeriods.startDateTime > ?7 and freePeriods.endDateTime < ?8")
  public int getBoatsSearchCount(String name, float price, float price1, float rating, String city, int capacity, LocalDateTime startDateTime, LocalDateTime endDateTime);

}

