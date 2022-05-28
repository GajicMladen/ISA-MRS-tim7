package tim7.ISAMRSproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.dto.FreePeriodDTO;
import tim7.ISAMRSproject.model.FreePeriod;
import tim7.ISAMRSproject.service.FreePeriodService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "api/freePeriods")
public class FreePeriodController {

    @Autowired
    private FreePeriodService freePeriodService;


    @GetMapping(value = "/getFreePeriods/{id}")
    public List<FreePeriodDTO> getFreePeriods(@PathVariable int id){

        List<FreePeriod> fr = freePeriodService.getFreePeriodByOfferId(id);
        List<FreePeriodDTO> ret = new ArrayList<>();
        for (FreePeriod f: fr) {
            ret.add(new FreePeriodDTO(f));
        }
        return ret;
    }
    
    @GetMapping(value = "/getFreePeriodsFromIds/{ids}")
	public List<FreePeriodDTO> getFreePeriodsFromIds(@PathVariable String ids) {
		List<FreePeriodDTO> freePeriods = new ArrayList<FreePeriodDTO>();
		String[] offerIds = ids.split(",");
		for (String i : offerIds) {
			int id = Integer.parseInt(i);
			List<FreePeriod> fr = freePeriodService.getFreePeriodByOfferId(id);
			for (FreePeriod f: fr) {
				freePeriods.add(new FreePeriodDTO(f));
			}
		}
		
		return freePeriods;
	}


    @PostMapping(value = "/addFreePeriod",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFreePeriod(@RequestBody FreePeriodDTO freePeriodDTO){
        freePeriodService.addFreePeriod(freePeriodDTO);
    }
    
    @PostMapping(value = "/addPeriodAdventure",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addFreePeriodAdventure(@RequestBody FreePeriodDTO freePeriodDTO){
        boolean correct = freePeriodService.addFreePeriodAdventure(freePeriodDTO);
        if (correct) {
        	return ResponseEntity.status(HttpStatus.ACCEPTED).body(correct);
        } else {
        	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(correct);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteFreePeriod(@PathVariable int id){
        freePeriodService.deleteFreePeriod(id);
    }

}
