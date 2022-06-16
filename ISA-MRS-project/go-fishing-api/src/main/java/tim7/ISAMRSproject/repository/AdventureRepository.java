package tim7.ISAMRSproject.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tim7.ISAMRSproject.model.Adventure;

public interface AdventureRepository extends JpaRepository<Adventure, Integer> {
	@Query("select v from Adventure v where v.fishingInstructor.id = ?1")
	public List<Adventure> findByInstructorId(Integer id);
	
	@Query("select COUNT(*) from Adventure")
	public Integer getTotalAdventures();
	
	@Query("select c from Adventure c inner join c.freePeriods freePeriods " +
            "where upper(c.name) like upper(?1) and c.price <= ?2 and c.price >= ?3 and c.rating >= ?4 and upper(c.address.city) like ?5 and c.capacity >= ?6 and freePeriods.startDateTime > ?7 and freePeriods.endDateTime < ?8")
    public List<Adventure> getAdventuresPageSearch(String name, float price, float price1, float rating, String city, int capacity, LocalDateTime startDateTime, LocalDateTime endDateTime, Pageable pageable);

	@Query("select COUNT(c) from Adventure c inner join c.freePeriods freePeriods " +
            "where upper(c.name) like upper(?1) and c.price <= ?2 and c.price >= ?3 and c.rating >= ?4 and upper(c.address.city) like ?5 and c.capacity >= ?6 and freePeriods.startDateTime > ?7 and freePeriods.endDateTime < ?8")
    public int getAdventuresSearchCount(String name, float price, float price1, float rating, String city, int capacity, LocalDateTime startDateTime, LocalDateTime endDateTime);

}
