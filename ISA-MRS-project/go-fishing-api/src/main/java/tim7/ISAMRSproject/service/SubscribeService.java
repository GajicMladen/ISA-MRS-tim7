package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Client;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.Offer;
import tim7.ISAMRSproject.repository.BoatRepository;
import tim7.ISAMRSproject.repository.ClientRepository;
import tim7.ISAMRSproject.repository.CottageRepository;

import java.util.Optional;

@Service
@Transactional
public class SubscribeService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CottageRepository cottageRepository;

    @Autowired
    private BoatRepository boatRepository;


    public void addSubsription(int clinetnId,int offerId){

        Optional<Client> client = clientRepository.findById(clinetnId);

        if(client.isPresent()){

            Optional<Cottage> cottage = cottageRepository.findById(offerId);
            if(cottage.isPresent() && ! client.get().isSubscribedToOffer(cottage.get().getId())){
                client.get().addSubscribedOffer(cottage.get());
                clientRepository.save(client.get());
                return;
            }

            Optional<Boat> boat = boatRepository.findById(offerId);
            if(boat.isPresent() && ! client.get().isSubscribedToOffer(boat.get().getId())){
                client.get().addSubscribedOffer(boat.get());
                clientRepository.save(client.get());
                return;
            }


        }
    }
    public void removeSubsription(int clinetnId,int offerId){

        Optional<Client> client = clientRepository.findById(clinetnId);

        if(client.isPresent()){

            Optional<Cottage> cottage = cottageRepository.findById(offerId);
            if(cottage.isPresent() &&  client.get().isSubscribedToOffer(cottage.get().getId())){
                client.get().removeSubscribedOffer(cottage.get());
                clientRepository.save(client.get());
                return;
            }

            Optional<Boat> boat = boatRepository.findById(offerId);
            if(boat.isPresent() &&  client.get().isSubscribedToOffer(boat.get().getId())){
                client.get().removeSubscribedOffer(boat.get());
                clientRepository.save(client.get());
                return;
            }


        }
    }
}
