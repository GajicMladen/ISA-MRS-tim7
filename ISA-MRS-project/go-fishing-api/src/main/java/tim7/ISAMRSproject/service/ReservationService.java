package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.model.ReservationStatus;
import tim7.ISAMRSproject.repository.BoatRepository;
import tim7.ISAMRSproject.repository.CottageRepository;
import tim7.ISAMRSproject.repository.ReservationRepository;

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

	public boolean AdventureHasReservations(Integer id) {
		for (Reservation r : reservationRepository.findAll()) {
			if (r.getOffer().getId() == id) {
				return true;
			}
		}
		return false;
		
	}

	public void addNewAction(ActionDTO actionDTO){
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
			reservationRepository.save(newAction);
			return;
		}
		if(boat.isPresent()){
			newAction.setOffer(boat.get());
			reservationRepository.save(newAction);
			return;
		}

		//instructor


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
}
