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

import tim7.ISAMRSproject.dto.ReservationListItemDTO;
import tim7.ISAMRSproject.repository.ReservationRepository;
import tim7.ISAMRSproject.utils.EmailServiceImpl;

import tim7.ISAMRSproject.model.*;
import tim7.ISAMRSproject.repository.*;


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
	private UserRepository userRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private FreePeriodRepository fpRepository;

	@Autowired
	private GradeRepository gradeRepository;
	
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
		Optional<Adventure> adventure = adventureRepository.findById(actionDTO.getOfferId());

		if(cottage.isPresent()) {
			newAction.setOffer(cottage.get());

			cottage.get().setChanging(!cottage.get().isChanging());
			cottageRepository.save(cottage.get());

			return reservationRepository.save(newAction);

		}
		if(boat.isPresent()){
			newAction.setOffer(boat.get());

			boat.get().setChanging(!boat.get().isChanging());
			boatRepository.save(boat.get());

			return reservationRepository.save(newAction);

		}
		if(adventure.isPresent()){
			newAction.setOffer(adventure.get());

			adventure.get().setChanging(!adventure.get().isChanging());
			adventureRepository.save(adventure.get());

			return reservationRepository.save(newAction);
		}

		return null;

	}

	public Reservation addNewActionCottage(LocalDateTime startDate,LocalDateTime endDate,float totalPrice,Cottage cottage){

		Reservation newAction = new Reservation();
		newAction.setEndDateTime(endDate);
		newAction.setStartDateTime(startDate);
		newAction.setTotalPrice(totalPrice);
		newAction.setStatus(ReservationStatus.FOR_ACTION);
		newAction.setOffer(cottage);

		cottage.setChanging(!cottage.isChanging());
		cottageRepository.save(cottage);

		return reservationRepository.save(newAction);
	}

	public Optional<Reservation> getReservationById(int id){
		return reservationRepository.findById(id);
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



	public String createNewReservation(String startDateString, String endDateString, int offerId, float totalPrice, String offerType, User user, int points) {

		LocalDateTime startDate = convertDateString(startDateString);
		LocalDateTime endDate = convertDateString(endDateString);
		Offer offer;
		Reservation res = new Reservation();
		res.setStartDateTime(startDate);
		res.setEndDateTime(endDate);
		res.setTotalPrice(totalPrice);
		if (offerType.equals("cottage")){
			offer = cottageRepository.getById(offerId);
			offer.setChanging(true);
			cottageRepository.save((Cottage) offer);
			res.setOffer(offer);
		}
		else if (offerType.equals("boat")) {

			offer = boatRepository.getById(offerId);
			res.setOffer(boatRepository.getById(offerId));
		}else {
			offer = adventureRepository.getById(offerId);
			res.setOffer(adventureRepository.getById(offerId));

		}
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

		user.setLoyaltyPoints(user.getLoyaltyPoints() + points);
		userRepository.save(user);
		emailService.sendReservationConfirmationMail(user, res, res.getOffer().getName());
		return "Your reservation is successful!";
		
	}
	
	public List<ReservationListItemDTO> getActiveReservations(User u) {
		List<ReservationListItemDTO> retVal = new ArrayList<ReservationListItemDTO>();
		for(Reservation r: reservationRepository.findByClient_IdEquals(u.getId())) {
			if (r.getStartDateTime().isAfter(LocalDateTime.now())) {
				ReservationListItemDTO rli = new ReservationListItemDTO();
				rli.setId(r.getId());
				rli.setStartDate(r.getStartDateTime());
				rli.setEndDate(r.getEndDateTime());
				rli.setClientId(u.getId());
				rli.setOfferId(r.getOffer().getId());
				rli.setOfferName(r.getOffer().getName());
				rli.setTotalPrice(r.getTotalPrice());
				rli.setOfferAddress(r.getOffer().getAddress().toString());
				if(LocalDateTime.now().plusDays(3).isAfter(r.getStartDateTime()))
					rli.setCanCancel(false);
				else
					rli.setCanCancel(true);
				retVal.add(rli);
			}
		}
		return retVal;
	}
	
	public List<ReservationListItemDTO> getPastReservations(User u) {
		List<ReservationListItemDTO> retVal = new ArrayList<ReservationListItemDTO>();
		for(Reservation r: reservationRepository.findByClient_IdEquals(u.getId())) {
			if (r.getStartDateTime().isBefore(LocalDateTime.now())) {
				ReservationListItemDTO rli = new ReservationListItemDTO();
				rli.setId(r.getId());
				rli.setStartDate(r.getStartDateTime());
				rli.setEndDate(r.getEndDateTime());
				rli.setClientId(u.getId());
				rli.setOfferId(r.getOffer().getId());
				rli.setOfferName(r.getOffer().getName());
				rli.setTotalPrice(r.getTotalPrice());
				rli.setOfferAddress(r.getOffer().getAddress().toString());
				if(r.getGrade() == null)
					rli.setCanCancel(true);
				else
					rli.setCanCancel(false);
				boolean canComplain = true;
				for (Complaint c: r.getComplaints()) {
					if (r.getId() == c.getReservation().getId() && !c.isFormOwner())
						canComplain = false;
				}
				rli.setCanComplain(canComplain);
				retVal.add(rli);
			}
		}
		return retVal;
	}
	
	public boolean cancelReservation(int id) {
		Reservation res = reservationRepository.getById(id);
		if (res == null) return false;
		else {
			FreePeriod fp = new FreePeriod();
			fp.setStartDateTime(res.getStartDateTime());
			fp.setEndDateTime(res.getEndDateTime());
			fp.setOffer(res.getOffer());
			reservationRepository.cancelReservationById(id);
			fpRepository.save(fp);
			return true;
		}
	}
	
	public boolean addReview(Grade grade, int reservationId) {
		Reservation res = reservationRepository.getById(reservationId);
		if (res != null) {
			res.setGrade(grade);
			grade.setReservation(res);
			gradeRepository.save(grade);
			return true;
		} else return false;

	}
	
	private LocalDateTime convertDateString(String s) {
		String[] tokens = s.split("-");
		LocalDateTime retVal = LocalDateTime.of(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[0]), 0, 0);
		return retVal;
	}
	
	
	public List<Reservation> getAllReservations() {
		return this.reservationRepository.findAll();
	}

	public List<Reservation> getReservationsByDataRange(LocalDateTime start, LocalDateTime end) {
		return this.reservationRepository.findAllByDateRange(start, end);
	}


	@Transactional
	public Reservation findById(int id){
		return reservationRepository.findById(id).get();
	}
	@Transactional(readOnly = false)
	public Reservation saveReservation(Reservation res){
		return reservationRepository.save(res);
	}


	@Transactional(readOnly = false)
	public boolean buyAction(Client client,Reservation res){
		if( res.getStatus() == ReservationStatus.FOR_ACTION){
			res.setClient(client);
			res.setStatus(ReservationStatus.ACTIVE);
			return true;
		}
		return false;
	}
}
