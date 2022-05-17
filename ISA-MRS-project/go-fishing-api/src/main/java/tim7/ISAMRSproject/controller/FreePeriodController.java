package tim7.ISAMRSproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tim7.ISAMRSproject.dto.FreePeriodDTO;
import tim7.ISAMRSproject.service.FreePeriodService;

@RestController
@RequestMapping(value = "api/freePeriod")
public class FreePeriodController {

    @Autowired
    private FreePeriodService freePeriodService;



    @PostMapping(value = "/addFreePeriod",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFreePeriod(@RequestBody FreePeriodDTO freePeriodDTO){
        freePeriodService.addFreePeriod(freePeriodDTO);
    }

}
