package tim7.ISAMRSproject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tim7.ISAMRSproject.model.Vikendica;
import tim7.ISAMRSproject.model.VlasnikVikendice;


public interface VikendicaRepository extends JpaRepository<Vikendica,Integer>{
	
	@Query("select v from Vikendica v where v.vlasnikVikendice.id = ?1")
	public List<Vikendica> findByVlasnikVikendice(Long vlasnikVikendice);
	
}
