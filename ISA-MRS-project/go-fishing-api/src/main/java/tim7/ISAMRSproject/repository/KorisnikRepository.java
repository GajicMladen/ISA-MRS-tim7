package tim7.ISAMRSproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tim7.ISAMRSproject.model.Korisnik;


public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
	
	
}