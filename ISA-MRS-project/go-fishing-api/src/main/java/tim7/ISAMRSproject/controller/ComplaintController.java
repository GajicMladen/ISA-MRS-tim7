package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.dto.ComplaintDTO;
import tim7.ISAMRSproject.model.Complaint;
import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.service.ComplaintService;
import tim7.ISAMRSproject.service.ReservationService;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/addNew")
    public void addNewComplaint(@RequestBody ComplaintDTO complaintDTO){

        Complaint newOne = new Complaint(complaintDTO);
        Reservation reservation = reservationService.getReservationById(complaintDTO.getReservationId());
        newOne.setReservation(reservation);

        complaintService.addNewComplaint(newOne);

    }

    @GetMapping(value = "/getComplaintFromOwner/{id}")
    public ComplaintDTO getComplaintFromOwner(@PathVariable int id){
        Optional<Complaint> ret = complaintService.findByReservationAndFromOwner(id);
        if(ret.isPresent())
            return  new ComplaintDTO(ret.get());
        return  null;
    }
}