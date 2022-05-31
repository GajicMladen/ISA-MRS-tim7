package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.model.ReservationStatus;
import tim7.ISAMRSproject.service.ReservationService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/reservations")
public class ReservationController {


    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/addNewAction",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getAllCottages(@RequestBody ActionDTO actionDTO){

        reservationService.addNewAction(actionDTO);

    }

    @GetMapping(value = "/getActions/{id}")
    public List<ActionDTO> getActionsForOffer(@PathVariable int id){

        List<Reservation> actionsForOffer =  reservationService.getActionsForOffer(id);
        List<ActionDTO> retVal = new ArrayList<>();
        for (Reservation reservation:
             actionsForOffer) {
            if(reservation.getStatus().equals(ReservationStatus.FOR_ACTION))
                retVal.add(new ActionDTO(reservation));
        }

        return retVal;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteFreePeriod(@PathVariable int id){
        reservationService.deleteAction(id);
    }
}
