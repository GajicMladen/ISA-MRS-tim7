package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.dto.ReservationDTO;
import tim7.ISAMRSproject.model.*;
import tim7.ISAMRSproject.repository.BoatRepository;
import tim7.ISAMRSproject.repository.ClientRepository;
import tim7.ISAMRSproject.repository.CottageRepository;
import tim7.ISAMRSproject.repository.ReservationRepository;

import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private CottageRepository cottageRepository;
	@Autowired
	private BoatRepository boatRepository;

	@Autowired
	private ClientRepository clientRepository;

	public boolean AdventureHasReservations(Integer id) {
		for (Reservation r : reservationRepository.findAll()) {
			if (r.getOffer().getId() == id) {
				return true;
			}
		}
		return false;
		
	}

	public Reservation addNewAction(ActionDTO actionDTO){
		Reservation newAction = new Reservation();
		newAction.setEndDateTime(actionDTO.getEndDate());
		newAction.setStartDateTime(actionDTO.getStartDate());
		newAction.setTotalPrice(actionDTO.getTotalPrice());
		newAction.setStatus(ReservationStatus.FOR_ACTION);
		Optional<Cottage> cottage = cottageRepository.findById(actionDTO.getOfferId());
		Optional<Boat> boat = boatRepository.findById(actionDTO.getOfferId());
		//instructor

		if(cottage.isPresent()) {
			newAction.setOffer(cottage.get());
			return reservationRepository.save(newAction);

		}
		if(boat.isPresent()){
			newAction.setOffer(boat.get());
			return reservationRepository.save(newAction);

		}

		//instructor
		return null;

	}

	public Reservation getReservationById(int id){
		return reservationRepository.getById(id);
	}

	public List<Reservation> getReservationsForOffer(int offerId){

		return reservationRepository.findByOffer_IdEquals(offerId);
	}

	public void deleteAction(int id){
		this.reservationRepository.deleteById(id);
	}

	public String addNewReservation(ReservationDTO reservationDTO){
		Reservation newReservation = new Reservation();
		newReservation.setEndDateTime(reservationDTO.getEndDate());
		newReservation.setStartDateTime(reservationDTO.getStartDate());
		newReservation.setStatus(reservationDTO.getReservationStatus());

		int daysNum = Period.between(reservationDTO.getStartDate().toLocalDate(),reservationDTO.getEndDate().toLocalDate()).getDays();

		Optional<Client> client = clientRepository.findById(reservationDTO.getClientId());

		if(client.isPresent()){
			newReservation.setClient(client.get());
		}
		else{
			return "invalid Client ID";
		}

		Optional<Cottage> cottage = cottageRepository.findById(reservationDTO.getOfferId());
		Optional<Boat> boat = boatRepository.findById(reservationDTO.getOfferId());
		//instructor

		if(cottage.isPresent()) {
			newReservation.setOffer(cottage.get());
			newReservation.setTotalPrice( daysNum * cottage.get().getPrice() );
			reservationRepository.save(newReservation);
			return "OK";
		}
		if(boat.isPresent()){
			newReservation.setOffer(boat.get());
			newReservation.setTotalPrice( daysNum * boat.get().getPrice() );
			reservationRepository.save(newReservation);
			return "OK";
		}

		//instructor

		return "Invalid Offer ID";
	}
}
