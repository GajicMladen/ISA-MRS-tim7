package tim7.ISAMRSproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tim7.ISAMRSproject.model.Client;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.ClientService;
import tim7.ISAMRSproject.service.SubscribeService;
import tim7.ISAMRSproject.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/clients")
public class ClientController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;

    @Autowired
    private SubscribeService subscribeService;

    @PostMapping(value = "/addPenalToClient/{id}")
    public void addPenalToClient(@PathVariable int id){
        clientService.addPenatlToClient(id);
    }

    @PostMapping(value = "/addSubscription/{offerId}")
    public void addSubscription(Principal user,@PathVariable int offerId){

        User reqUser = this.userService.findByEmail(user.getName());
        subscribeService.addSubsription(reqUser.getId(),offerId);

    }
    @PostMapping(value = "/removeSubscription/{offerId}")
    public void removeSubscription(Principal user,@PathVariable int offerId){

        User reqUser = this.userService.findByEmail(user.getName());
        subscribeService.removeSubsription(reqUser.getId(),offerId);

    }
    @GetMapping(value = "/isSubscribedToOffer/{offerId}")
    public boolean isSubscribedToOffer(Principal user,@PathVariable int offerId){

        User reqUser = this.userService.findByEmail(user.getName());
        return clientService.isClinetSubscribedToOffer(reqUser.getId(),offerId);

    }

}
