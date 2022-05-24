package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.repository.BoatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public Optional<Boat> getBoat(int id){

        return boatRepository.findById(id);
    }

    public List<Boat> getBoatsByOwnerId(Integer ownerId){

        return boatRepository.findByOwnerId(ownerId);
    }

}
