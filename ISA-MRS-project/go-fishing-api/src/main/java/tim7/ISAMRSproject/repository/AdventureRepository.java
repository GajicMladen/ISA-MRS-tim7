package tim7.ISAMRSproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tim7.ISAMRSproject.model.Adventure;

public interface AdventureRepository extends JpaRepository<Adventure, Integer> {
	@Query("select v from Adventure v where v.fishingInstructor.id = ?1")
	public List<Adventure> findByInstructorId(Integer id);
}
