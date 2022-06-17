package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.model.Action;
import tim7.ISAMRSproject.model.Client;
import tim7.ISAMRSproject.model.Offer;
import tim7.ISAMRSproject.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void addPenatlToClient(Integer id){
        clientRepository.addPenalToClient(id);
    }

    public Optional<Client> getClientById(Integer id){
        return clientRepository.findById(id);
    }


    public List<Client> getSubscribersForOffer(Integer offerId){
        return clientRepository.getSubscribersForOffer(offerId);
    }

    public boolean isClinetSubscribedToOffer(Integer clientId,Integer offerId){
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()){
            for (Offer offer:client.get().getSubscribedOffers() ) {
                if(offer.getId() == offerId)
                    return true;
            }
        }
        return false;
    }
}
