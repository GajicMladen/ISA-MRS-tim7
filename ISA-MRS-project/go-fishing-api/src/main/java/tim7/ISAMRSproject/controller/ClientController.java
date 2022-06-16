package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.service.ClientService;

@RestController
@RequestMapping(value = "api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/addPenalToClient/{id}")
    public void addPenalToClient(@PathVariable int id){
        clientService.addPenatlToClient(id);
    }
}
