package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tim7.ISAMRSproject.dto.FreePeriodDTO;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.FreePeriod;
import tim7.ISAMRSproject.repository.CottageRepository;
import tim7.ISAMRSproject.repository.FreePeriodRepository;
import tim7.ISAMRSproject.repository.InstructorRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class FreePeriodService {

    @Autowired
    private FreePeriodRepository freePeriodRepository;

    @Autowired
    private CottageRepository cottageRepository;



    public void addFreePeriod(FreePeriodDTO freePeriodDTO){

        LocalDateTime startDate = freePeriodDTO.getStartDate();
        LocalDateTime endDate = freePeriodDTO.getEndDate();

        Optional<Cottage> cottage = cottageRepository.findById(freePeriodDTO.getOfferId());

        //Optional<Instructor> instructor = instructorRepository.findById(freePeriodDTO.getOfferId());

        //Optional<Boat> boat = boatRepository.findById(freePeriodDTO.getOfferId());

        if(cottage.isPresent()){

            freePeriodRepository.save(new FreePeriod(startDate,endDate,cottage.get()));
        }
        /*
        * elif( instuctor.isPresent()) ....
        * */

    }

}
