package tim7.ISAMRSproject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim7.ISAMRSproject.dto.SubscriptionDTO;
import tim7.ISAMRSproject.dto.UnsubscribeDTO;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.ClientService;
import tim7.ISAMRSproject.service.SubscribeService;
import tim7.ISAMRSproject.service.UserService;

@RestController
@RequestMapping(value = "api/clients")
@Transactional
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
    @GetMapping(value="/subscriptions")
	public ResponseEntity<?> getClientSubscriptions(Principal user){
		User u = this.userService.findByEmail(user.getName());
		List<SubscriptionDTO> subs = userService.getAllSubscriptions(u);
		return new ResponseEntity<>(subs, HttpStatus.OK);
	}
    @PutMapping(value="/unsubscribe")
    public ResponseEntity<?> unsubscribeOffer(@RequestBody UnsubscribeDTO unsubDTO, Principal user){
    	User u = this.userService.findByEmail(user.getName());
    	//userService.unsubscribe(u, unsubDTO.getId());
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    

}
