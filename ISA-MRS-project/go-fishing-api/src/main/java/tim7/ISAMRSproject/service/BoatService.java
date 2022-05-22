package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.repository.BoatRepository;

import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public Optional<Boat> getBoat(int id){

        return boatRepository.findById(id);
    }

}
