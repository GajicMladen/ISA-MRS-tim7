package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim7.ISAMRSproject.model.Complaint;
import tim7.ISAMRSproject.repository.ComplaintRepository;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public void addNewComplaint(Complaint c){
        complaintRepository.save(c);
    }
}

