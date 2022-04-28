package tim7.ISAMRSproject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tim7.ISAMRSproject.model.Cottage;


public interface CottageRepository extends JpaRepository<Cottage,Integer>{
	
	@Query("select v from Cottage v where v.cottageOwner.id = ?1")
	public List<Cottage> findByOwnerId(Long ownerId);
	
}
