package tim7.ISAMRSproject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.dto.ClientComplaintDTO;
import tim7.ISAMRSproject.dto.DataForChartDTO;

import tim7.ISAMRSproject.dto.DateRangeDTO;

import tim7.ISAMRSproject.dto.DateRangeStringDTO;
import tim7.ISAMRSproject.dto.GradeDTO;
import tim7.ISAMRSproject.dto.ReservationDTO;

import tim7.ISAMRSproject.dto.ReservationListItemDTO;

import tim7.ISAMRSproject.model.*;

import tim7.ISAMRSproject.service.AdventureService;
import tim7.ISAMRSproject.service.BoatService;
import tim7.ISAMRSproject.service.ClientService;
import tim7.ISAMRSproject.service.ComplaintService;
import tim7.ISAMRSproject.service.CottageService;
import tim7.ISAMRSproject.service.FreePeriodService;
import tim7.ISAMRSproject.service.ReservationService;
import tim7.ISAMRSproject.service.UserService;
import tim7.ISAMRSproject.utils.EmailServiceImpl;

@RestController
@RequestMapping(value = "api/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private BoatService boatService;
    @Autowired
    private CottageService cottageService;
    @Autowired
    private AdventureService adventureService;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private FreePeriodService freePeriodService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private UserService userService;
    
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

    @GetMapping(value = "/getVisitChartDataForCottageOwner/{id}")
    public List<DataForChartDTO> getVisitDataForChartCottageOwner(@PathVariable int id){
        List<DataForChartDTO> retVal = new ArrayList<>();

        List<Cottage> offers = cottageService.getCottagesByOwnerId(id);
        for (Cottage cottage:offers) {
            DataForChartDTO newData = new DataForChartDTO();
            newData.setName(cottage.getName());
            float value = 0;
            List<Reservation> reservations =  reservationService.getReservationsForOffer(cottage.getId());
            value += reservations.size();
            newData.setValue(value);
            retVal.add(newData);
        }

        return retVal;

    }

    @GetMapping(value = "/getGradeChartDataForCottageOwner/{id}")
    public List<DataForChartDTO> getGradeDataForChartCottageOwner(@PathVariable int id){
        List<DataForChartDTO> retVal = new ArrayList<>();

        List<Cottage> offers = cottageService.getCottagesByOwnerId(id);
        for (Cottage cottage:offers) {
            DataForChartDTO newData = new DataForChartDTO();
            newData.setName(cottage.getName());
            float value = 0;
            List<Reservation> reservations =  reservationService.getReservationsForOffer(cottage.getId());
            for (Reservation reservation: reservations) {
                if (reservation.getGrade() != null)
                    value += reservation.getGrade().getGrade();
            }
            if(reservations.size() > 0 )
                value = value/reservations.size();
            else
                value = 0;
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
    @GetMapping(value = "/getVisitChartDataForBoatOwner/{id}")
    public List<DataForChartDTO> getVisitDataForChartBoatOwner(@PathVariable int id){
        List<DataForChartDTO> retVal = new ArrayList<>();

        List<Boat> offers = boatService.getBoatsByOwnerId(id);
        for (Boat boat:offers) {
            DataForChartDTO newData = new DataForChartDTO();
            newData.setName(boat.getName());
            float value = 0;
            List<Reservation> reservations =  reservationService.getReservationsForOffer(boat.getId());
            value += reservations.size();
            newData.setValue(value);
            retVal.add(newData);
        }

        return retVal;

    }
    @GetMapping(value = "/getGradeChartDataForBoatOwner/{id}")
    public List<DataForChartDTO> getGradeDataForChartBoatOwner(@PathVariable int id){
        List<DataForChartDTO> retVal = new ArrayList<>();

        List<Boat> offers = boatService.getBoatsByOwnerId(id);
        for (Boat boat:offers) {
            DataForChartDTO newData = new DataForChartDTO();
            newData.setName(boat.getName());
            float value = 0;
            List<Reservation> reservations =  reservationService.getReservationsForOffer(boat.getId());
            for (Reservation reservation: reservations) {
                if(reservation.getGrade() != null)
                    value += reservation.getGrade().getGrade();
            }
            if(reservations.size() > 0 )
                value = value/reservations.size();
            else
                value = 0;
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
    
    @GetMapping(value = "/getFreePeriods/{cottageId}")
    public ResponseEntity<List<String>> getCottageFreePeriods(@PathVariable int cottageId){
    	List<String> retVal = new ArrayList<String>();
    	List<FreePeriod> freePeriods = freePeriodService.getFreePeriodByOfferId(cottageId);
    	for (FreePeriod fp: freePeriods) {
    		retVal.add(fp.getStartDateTime().getDayOfMonth() + "-" + fp.getStartDateTime().getMonthValue() + "-" + fp.getStartDateTime().getYear() + " " + fp.getEndDateTime().getDayOfMonth() + "-" + fp.getEndDateTime().getMonthValue() + "-" + fp.getEndDateTime().getYear());
    	}
    	return new ResponseEntity<>(retVal, HttpStatus.OK);
    }  
    
    @PostMapping(value = "/newReservation")
    public ResponseEntity<?> addNewReservation(@RequestBody DateRangeStringDTO dateRangeDTO, Principal user){
    	User u = userService.findByEmail(user.getName());
    	String status = reservationService.createNewReservation(dateRangeDTO.getStartDateString(), dateRangeDTO.getEndDateString(), dateRangeDTO.getOfferId(), dateRangeDTO.getTotalPrice(), dateRangeDTO.getOfferType(), u);
    	return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\":\"" + status + "\"}");
    }
    
    @PostMapping(value = "/getReservationsByDateRange")
    public ResponseEntity<?> getReservationsByDateRange(@RequestBody DateRangeDTO dateRange) {
    	List<Reservation> reservations = this.reservationService.getReservationsByDataRange( dateRange.getStart(), dateRange.getEnd());
    	List<ReservationDTO> dtos = new ArrayList<ReservationDTO>();
    	for (Reservation r : reservations) {
    		ReservationDTO dto = new ReservationDTO(r);
    		dtos.add(dto);
    	}
    	return new ResponseEntity<List<ReservationDTO>>(dtos, HttpStatus.OK);
    }
    
    @GetMapping(value = "/AllReservations")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
    	List<Reservation> reservations = this.reservationService.getAllReservations();
    	List<ReservationDTO> dtos = new ArrayList<ReservationDTO>();
    	for (Reservation r : reservations) {
    		ReservationDTO dto = new ReservationDTO(r);
    		dtos.add(dto);
    	}
    	return new ResponseEntity<List<ReservationDTO>>(dtos, HttpStatus.OK);
    }
    
    @GetMapping(value = "/getReservation/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable int id) {
    	Optional<Reservation> reservation = this.reservationService.getReservationById(id);
    	if (reservation.isPresent()) {
    		return new ResponseEntity<>(new ReservationDTO(reservation.get()), HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	}
    }
  
    @GetMapping(value = "/activeReservations")
    public ResponseEntity<?> getActiveReservations(Principal user){
    	User u = userService.findByEmail(user.getName());
    	List<ReservationListItemDTO> activeReservations = reservationService.getActiveReservations(u);
    	return new ResponseEntity<>(activeReservations, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/cancelReservation/{id}")
    public ResponseEntity<?> cancelReservation(@PathVariable int id){
    	boolean status = reservationService.cancelReservation(id);
    	if (status)
    		return new ResponseEntity<>(HttpStatus.OK);
    	else
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(value = "/pastReservations")
    public ResponseEntity<?> getPastReservations(Principal user){
    	User u = userService.findByEmail(user.getName());
    	List<ReservationListItemDTO> pastReservations = reservationService.getPastReservations(u);
    	return new ResponseEntity<>(pastReservations, HttpStatus.OK);
    }
    
    @PostMapping(value = "/addReview")
    public ResponseEntity<?> addReview(@RequestBody GradeDTO gradeDTO){
    	Grade grade = new Grade();
    	grade.setGrade(gradeDTO.getGrade());
    	grade.setRevision(gradeDTO.getReviewText());
    	grade.setStatus(ApprovalStatus.ON_WAIT);
    	
    	boolean status = reservationService.addReview(grade, gradeDTO.getId());
    	if (status)
    		return new ResponseEntity<>(HttpStatus.OK);
    	else
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(value = "/addComplaint")
    public ResponseEntity<?> addReview(@RequestBody ClientComplaintDTO complaintDTO){
    	Complaint complaint = new Complaint();
    	
    	complaint.setFormOwner(false);
    	complaint.setForOffer(true);
    	complaint.setPunishOffender(false);
    	complaint.setText(complaintDTO.getComplaintText());
    	complaint.setStatus(ApprovalStatus.ON_WAIT);
    	
    	complaintService.addNewComplaint(complaint, complaintDTO.getId());
		return new ResponseEntity<>(HttpStatus.OK);
    }
}
