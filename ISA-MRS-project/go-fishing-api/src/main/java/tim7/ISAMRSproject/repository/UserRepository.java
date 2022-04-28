package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim7.ISAMRSproject.model.Userr;


public interface UserRepository extends JpaRepository<Userr, Integer> {
	
}