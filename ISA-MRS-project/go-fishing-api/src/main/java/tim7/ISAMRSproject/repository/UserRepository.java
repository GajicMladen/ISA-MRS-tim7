package tim7.ISAMRSproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tim7.ISAMRSproject.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);

}