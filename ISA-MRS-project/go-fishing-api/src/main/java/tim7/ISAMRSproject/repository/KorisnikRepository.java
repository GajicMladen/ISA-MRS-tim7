package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tim7.ISAMRSproject.model.Korisnik;


public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
	
}