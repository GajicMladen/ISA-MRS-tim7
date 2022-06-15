package tim7.ISAMRSproject.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;
import tim7.ISAMRSproject.model.Cottage;


public interface CottageRepository extends JpaRepository<Cottage,Integer>{
	
	@Query("select v from Cottage v where v.cottageOwner.id = ?1")
	public List<Cottage> findByOwnerId(Integer ownerId);

	@Transactional
	@Modifying
	@Query(value = "update Cottage c set c.name = ?2 , c.promoDescription = ?3 , c.price = ?4, c.capacity = ?5 where c.id = ?1")
	public void updateCottage(Integer cottageId,String name,String promoDescription,float price, int capacity);
	
	@Query("select COUNT(*) from Cottage")
	public Integer getTotalCottages();

}
