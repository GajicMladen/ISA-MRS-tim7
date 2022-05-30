package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tim7.ISAMRSproject.dto.BoatDTO;
import tim7.ISAMRSproject.dto.CottageDTO;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.service.BoatService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/boats")
public class BoatController {

    @Autowired
    private BoatService boatService;

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
}
