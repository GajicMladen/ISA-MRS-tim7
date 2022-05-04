package tim7.ISAMRSproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tim7.ISAMRSproject.model.Korisnik;


public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	public Optional<Korisnik> findById(Long id);
	public Optional<Korisnik> findByEmail(String email);
}