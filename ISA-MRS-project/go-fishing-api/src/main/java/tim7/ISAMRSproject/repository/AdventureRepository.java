package tim7.ISAMRSproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim7.ISAMRSproject.model.Adventure;

public interface AdventureRepository extends JpaRepository<Adventure, Integer> {

}
