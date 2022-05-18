package tim7.ISAMRSproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.dto.FreePeriodDTO;
import tim7.ISAMRSproject.model.FreePeriod;
import tim7.ISAMRSproject.service.FreePeriodService;

import java.util.ArrayList;
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


    @PostMapping(value = "/addFreePeriod",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFreePeriod(@RequestBody FreePeriodDTO freePeriodDTO){
        freePeriodService.addFreePeriod(freePeriodDTO);
    }

}
