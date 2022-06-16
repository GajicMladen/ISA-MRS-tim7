package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.dto.DataForChartDTO;
import tim7.ISAMRSproject.dto.ReservationDTO;
import tim7.ISAMRSproject.model.*;
import tim7.ISAMRSproject.service.BoatService;
import tim7.ISAMRSproject.service.ClientService;
import tim7.ISAMRSproject.service.CottageService;
import tim7.ISAMRSproject.service.ReservationService;
import tim7.ISAMRSproject.utils.EmailServiceImpl;

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

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private ClientService clientService;


    @PostMapping(value = "/addNewAction",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getAllCottages(@RequestBody ActionDTO actionDTO){

        Reservation newAction = reservationService.addNewAction(actionDTO);
        if(newAction != null){
            List<Client> subscribers = clientService.getSubscribersForOffer(newAction.getOffer().getId());
            for(Client client: subscribers ) {
                try {
                    emailService.sendActionEmail(client,newAction);
                }
                catch (Exception e){
                    System.out.println("Exceprion on sending email to : "+client.getEmail());
                }
            }
        }
    }

    @GetMapping(value = "/getActions/{id}")
    public List<ActionDTO> getActionsForOffer(@PathVariable int id){

        List<Reservation> actionsForOffer =  reservationService.getActionsForOffer(id);
        List<ActionDTO> retVal = new ArrayList<>();
        for (Reservation reservation:actionsForOffer) {
            retVal.add(new ActionDTO(reservation));
        }

        return retVal;
    }

    @GetMapping(value = "/getReservationsForOffer/{id}")
    public List<ReservationDTO> getReservationsForOffer(@PathVariable int id){

        List<Reservation> reservationsForOffer =  reservationService.getReservationsForOffer(id);
        List<ReservationDTO> retVal = new ArrayList<>();
        for (Reservation reservation:reservationsForOffer) {
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
            List<Reservation> actionsForOffer =  reservationService.getReservationsForOffer(cottage.getId());
            for (Reservation reservation:
                    actionsForOffer) {
                if( ! reservation.getStatus().equals(ReservationStatus.FOR_ACTION))
                    retVal.add(new ReservationDTO(reservation));
            }
        }

        return retVal;
    }

    @GetMapping(value = "/getProfitChartDataForCottageOwner/{id}")
    public List<DataForChartDTO> getDataForChartCottageOwner(@PathVariable int id){
        List<DataForChartDTO> retVal = new ArrayList<>();

        List<Cottage> offers = cottageService.getCottagesByOwnerId(id);
        for (Cottage cottage:offers) {
            DataForChartDTO newData = new DataForChartDTO();
            newData.setName(cottage.getName());
            float value = 0;
            List<Reservation> reservations =  reservationService.getReservationsForOffer(cottage.getId());
            for (Reservation reservation: reservations) {
                value += reservation.getTotalPrice();
            }
            newData.setValue(value);
            retVal.add(newData);
        }

        return retVal;

    }

    @GetMapping(value = "/getProfitChartDataForBoatOwner/{id}")
    public List<DataForChartDTO> getDataForChartBoatOwner(@PathVariable int id){
        List<DataForChartDTO> retVal = new ArrayList<>();

        List<Boat> offers = boatService.getBoatsByOwnerId(id);
        for (Boat boat:offers) {
            DataForChartDTO newData = new DataForChartDTO();
            newData.setName(boat.getName());
            float value = 0;
            List<Reservation> reservations =  reservationService.getReservationsForOffer(boat.getId());
            for (Reservation reservation: reservations) {
                value += reservation.getTotalPrice();
            }
            newData.setValue(value);
            retVal.add(newData);
        }

        return retVal;

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
