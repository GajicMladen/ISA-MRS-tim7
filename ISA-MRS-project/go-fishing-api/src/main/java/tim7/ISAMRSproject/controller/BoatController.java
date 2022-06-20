package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.dto.BoatDTO;
import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.BoatService;
import tim7.ISAMRSproject.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/boats")
public class BoatController {

    @Autowired
    private BoatService boatService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getBoat/{id}")
    public ResponseEntity<BoatDTO> getBoat(@PathVariable int id){

        Optional<Boat> boat =  boatService.getBoat(id);
        if(boat.isPresent())
            return new ResponseEntity<>(new BoatDTO(boat.get()), HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/owner/{id}")
    public ResponseEntity<List<BoatDTO>> getOwnerCottages(@PathVariable int id){

        List<Boat> boats = boatService.getBoatsByOwnerId(id);
        List<BoatDTO> boatsDTOS = new ArrayList<BoatDTO>();

        for (Boat boat : boats) {
            boatsDTOS.add(new BoatDTO(boat));
        }

        return new ResponseEntity<>(boatsDTOS,HttpStatus.OK);
    }

    @PostMapping(
            value = "/newBoat",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BoatDTO addNewBoat(@RequestBody BoatDTO newOne) {
        Optional<User> user = userService.findById(newOne.getOwnerId());
        if(user.isPresent() && user.get().hasRole("ROLE_BOAT_OWNER"))
            return new BoatDTO(boatService.addNewBoat(newOne,user.get()));
        return null;
    }

    @DeleteMapping(value = "/deleteBoat/{id}")
    public boolean deleteBoat(@PathVariable Integer id){

        return boatService.deleteBoat(id);

    }

    @PutMapping(value = "/updateBoat",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBoat(@RequestBody BoatDTO boat){

        Boat boat1 = boatService.getBoat(boat.getId()).get();
        boatService.editBoat(boat1,boat.getId(),boat.getName(),boat.getDescription(),boat.getPrice(),boat.getCapacity());
    }
}
