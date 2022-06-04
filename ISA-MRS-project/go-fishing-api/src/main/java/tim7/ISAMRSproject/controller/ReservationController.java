package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.dto.ReservationDTO;
import tim7.ISAMRSproject.model.*;
import tim7.ISAMRSproject.service.BoatService;
import tim7.ISAMRSproject.service.CottageService;
import tim7.ISAMRSproject.service.ReservationService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private BoatService boatService;
    @Autowired
    private CottageService cottageService;


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

    
}
