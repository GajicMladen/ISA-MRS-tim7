package tim7.ISAMRSproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tim7.ISAMRSproject.model.Complaint;
import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.repository.ComplaintRepository;

@Service
@Transactional
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ReservationService resService;
    
    public void addNewComplaint(Complaint c){
        complaintRepository.save(c);
    }
    
    public void addNewComplaint(Complaint c, int reservationId){
    	Reservation res = resService.getReservationById(reservationId);
    	c.setReservation(res);
    	c.setOffenderId(res.getOffer().getId());
        complaintRepository.save(c);
    }

    public Optional<Complaint> findByReservationAndFromOwner(int id){
        return complaintRepository.findByReservation_IdEqualsAndFormOwnerIsTrue(id);
    }
}

