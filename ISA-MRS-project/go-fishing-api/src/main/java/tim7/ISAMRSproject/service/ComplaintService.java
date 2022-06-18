package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim7.ISAMRSproject.model.Complaint;
import tim7.ISAMRSproject.repository.ComplaintRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public void addNewComplaint(Complaint c){
    	
        complaintRepository.save(c);
    }

    public Optional<Complaint> findByReservationAndFromOwner(int id){
        return complaintRepository.findByReservation_IdEqualsAndFormOwnerIsTrue(id);
    }

	public List<Complaint> findComplaintsOnWait() {
		return this.complaintRepository.findOnWait();
	}
	
	public Optional<Complaint> getComplaintById(int id) {
		return this.complaintRepository.findById(id);
	}

	public void save(Complaint complaint) {
		this.complaintRepository.save(complaint);
		
	}
}

