package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim7.ISAMRSproject.model.Client;
import tim7.ISAMRSproject.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void addPenatlToClient(Integer id){
        clientRepository.addPenalToClient(id);
    }

    public Optional<Client> getClientById(Integer id){
        return clientRepository.findById(id);
    }
}
