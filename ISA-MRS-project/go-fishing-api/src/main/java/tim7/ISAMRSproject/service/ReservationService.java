package tim7.ISAMRSproject.service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.dto.ReservationDTO;
import tim7.ISAMRSproject.model.Boat;
import tim7.ISAMRSproject.model.Client;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.FreePeriod;
import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.model.ReservationStatus;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.repository.AdventureRepository;
import tim7.ISAMRSproject.repository.BoatRepository;
import tim7.ISAMRSproject.repository.ClientRepository;
import tim7.ISAMRSproject.repository.CottageRepository;
import tim7.ISAMRSproject.repository.FreePeriodRepository;
import tim7.ISAMRSproject.repository.ReservationRepository;
import tim7.ISAMRSproject.utils.EmailServiceImpl;

@Service
@Transactional
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private CottageRepository cottageRepository;
	@Autowired
	private BoatRepository boatRepository;
	@Autowired
	private AdventureRepository adventureRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private FreePeriodRepository fpRepository;
	
	@Autowired
	private EmailServiceImpl emailService;

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

		List<Reservation> ret = new ArrayList<>();

		List<Reservation> allReservations =  reservationRepository.findByOffer_IdEquals(offerId);
		for (Reservation reservation:allReservations) {
			if(! reservation.getStatus().equals(ReservationStatus.FOR_ACTION))
				ret.add(reservation);
		}

		return ret;
	}


	public List<Reservation> getActionsForOffer(int offerId){
		List<Reservation> ret = new ArrayList<>();

		List<Reservation> allReservations =  reservationRepository.findByOffer_IdEquals(offerId);
		for (Reservation reservation:allReservations) {
			if(reservation.getStatus().equals(ReservationStatus.FOR_ACTION))
				ret.add(reservation);
		}

		return ret;
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
	
	public String createNewReservation(String startDateString, String endDateString, int offerId, float totalPrice, String offerType, User user) {
		LocalDateTime startDate = convertDateString(startDateString);
		LocalDateTime endDate = convertDateString(endDateString);
		
		Reservation res = new Reservation();
		res.setStartDateTime(startDate);
		res.setEndDateTime(endDate);
		res.setTotalPrice(totalPrice);
		if (offerType.equals("cottage"))
			res.setOffer(cottageRepository.getById(offerId));
		else if (offerType.equals("boat"))
			res.setOffer(boatRepository.getById(offerId));
		else if (offerType.equals("adventure"))
			res.setOffer(adventureRepository.getById(offerId));
		res.setStatus(ReservationStatus.ACTIVE);
		res.setClient(clientRepository.getById(user.getId()));
		
		List<FreePeriod> fps = fpRepository.findByOffer_Id(offerId);
		

		for (FreePeriod fp: fps) {
			if(fp.getStartDateTime().isBefore(startDate) && fp.getEndDateTime().isAfter(endDate)) {
				FreePeriod before = new FreePeriod();
				FreePeriod after = new FreePeriod();
				
				before.setOffer(fp.getOffer());
				after.setOffer(fp.getOffer());
				before.setStartDateTime(fp.getStartDateTime());
				before.setEndDateTime(startDate.minusDays(1));
				after.setStartDateTime(endDate);
				after.setEndDateTime(fp.getEndDateTime());
				
				fpRepository.deleteById(fp.getId());
				fpRepository.save(before);
				fpRepository.save(after);
			} else if (fp.getStartDateTime().equals(startDate) && fp.getEndDateTime().equals(endDate)) {
				fpRepository.deleteById(fp.getId());
			}
		}
		
		reservationRepository.save(res);
		emailService.sendReservationConfirmationMail(user, res, res.getOffer().getName());
		return "Your reservation is successful!";
		
	}
	
	private LocalDateTime convertDateString(String s) {
		String[] tokens = s.split("-");
		LocalDateTime retVal = LocalDateTime.of(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[0]), 0, 0);
		return retVal;
	}
}
