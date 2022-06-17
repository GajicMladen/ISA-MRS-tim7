package tim7.ISAMRSproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.dto.ReservationDTO;
import tim7.ISAMRSproject.model.Adventure;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.model.ReservationStatus;
import tim7.ISAMRSproject.service.AdventureService;
import tim7.ISAMRSproject.service.BoatService;
import tim7.ISAMRSproject.service.CottageService;
import tim7.ISAMRSproject.service.ReservationService;

@RestController
@RequestMapping(value = "api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private BoatService boatService;
    @Autowired
    private CottageService cottageService;
    @Autowired
    private AdventureService adventureService;


    @PostMapping(value = "/addNewAction",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getAllCottages(@RequestBody ActionDTO actionDTO){

        reservationService.addNewAction(actionDTO);

    }

    @GetMapping(value = "/getActions/{id}")
    public List<ActionDTO> getActionsForOffer(@PathVariable int id){

        List<Reservation> actionsForOffer =  reservationService.getReservationsForOffer(id);
        List<ActionDTO> retVal = new ArrayList<>();
        for (Reservation reservation:
             actionsForOffer) {
            if(reservation.getStatus().equals(ReservationStatus.FOR_ACTION))
                retVal.add(new ActionDTO(reservation));
        }

        return retVal;
    }

    @GetMapping(value = "/getReservationsForOffer/{id}")
    public List<ReservationDTO> getReservationsForOffer(@PathVariable int id){

        List<Reservation> actionsForOffer =  reservationService.getReservationsForOffer(id);
        List<ReservationDTO> retVal = new ArrayList<>();
        for (Reservation reservation:
                actionsForOffer) {
            if( ! reservation.getStatus().equals(ReservationStatus.FOR_ACTION))
                retVal.add(new ReservationDTO(reservation));
        }

        return retVal;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteFreePeriod(@PathVariable int id){
        reservationService.deleteAction(id);
    }

    @GetMapping(value = "/getReservationsForBoatOwner/{id}")
    public List<ReservationDTO> getReservationsForBoatOwner(@PathVariable int id){
        List<ReservationDTO> retVal = new ArrayList<>();

        List<Boat> offers = boatService.getBoatsByOwnerId(id);
        for (Boat boat:offers) {
            List<Reservation> actionsForOffer =  reservationService.getReservationsForOffer(boat.getId());
            for (Reservation reservation:
                    actionsForOffer) {
                if( ! reservation.getStatus().equals(ReservationStatus.FOR_ACTION))
                    retVal.add(new ReservationDTO(reservation));
            }
        }

        return retVal;
    }

    @GetMapping(value = "/getReservationsForCottageOwner/{id}")
    public List<ReservationDTO> getReservationsForCottageOwner(@PathVariable int id){
        List<ReservationDTO> retVal = new ArrayList<>();

        List<Cottage> offers = cottageService.getCottagesByOwnerId(id);
        for (Cottage cottage:offers) {
            List<Reservation> actionsForOffer =  reservationService.getReservationsForOffer(cottage .getId());
            for (Reservation reservation:
                    actionsForOffer) {
                if( ! reservation.getStatus().equals(ReservationStatus.FOR_ACTION))
                    retVal.add(new ReservationDTO(reservation));
            }
        }

        return retVal;
    }
    
    @GetMapping(value ="/getReservationsForInstructor/{id}")
    public List<ReservationDTO> getReservationsForInstructor(@PathVariable int id) {
    	List<ReservationDTO> reservationsDTO = new ArrayList<ReservationDTO>();
    	List<Adventure> adventures = this.adventureService.getAdventuresByInstructorId(id);
    	for (Adventure a : adventures) {
    		List<Reservation> reservations = this.reservationService.getReservationsForOffer(a.getId());
    		for (Reservation r : reservations) {
    			reservationsDTO.add(new ReservationDTO(r));    			
    		}
    	}
    	return reservationsDTO;
    }


    @PostMapping(value = "/addNewReservation")
    public ResponseEntity<?> addNewReservation(@RequestBody ReservationDTO newReservation){



        String msg = reservationService.addNewReservation(newReservation);
        if(msg.equals("OK")){
            return new ResponseEntity<>("DONE!",HttpStatus.OK);

        }
        return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);

    }
    
}
