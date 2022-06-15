package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim7.ISAMRSproject.dto.BoatDTO;
import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.model.*;
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
    
    public List<Boat> getAllBoats() {
    	return boatRepository.findAll();
    }

    public void deleteBoatById(int id) {
    	this.boatRepository.deleteById(id);
    }
  
    public Boat addNewBoat(BoatDTO boatDTO, User user) {

        Boat boat = new Boat(boatDTO);
        boat.setBoatOwner((BoatOwner) user);
        return boatRepository.save(boat);

    }

    public boolean deleteBoat(Integer id){
        try{
            boatRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void editBoat(BoatDTO boatDTO){
        boatRepository.updateBoat(boatDTO.getId(), boatDTO.getName(),
                boatDTO.getDescription(), boatDTO.getPrice(),boatDTO.getCapacity());
    }

}
