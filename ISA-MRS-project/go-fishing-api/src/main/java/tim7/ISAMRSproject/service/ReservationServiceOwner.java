package tim7.ISAMRSproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tim7.ISAMRSproject.model.*;
import tim7.ISAMRSproject.repository.CottageRepository;
import tim7.ISAMRSproject.repository.ReservationRepository;

import java.time.LocalDateTime;
import java.time.Period;

@Service
@Transactional
public class ReservationServiceOwner {


        @Autowired
        private ReservationRepository reservationRepository;

        @Autowired
        private CottageRepository cottageRepository;

        public Reservation reserveCottage(Cottage cottage, Client client, LocalDateTime startDate,LocalDateTime endDate){
            int daysNum = Period.between(startDate.toLocalDate(),endDate.toLocalDate()).getDays();

            Reservation newRes = new Reservation();
            newRes.setClient(client);
            newRes.setStatus(ReservationStatus.ACTIVE);
            newRes.setTotalPrice(daysNum*cottage.getPrice());
            newRes.setOffer(cottage);
            newRes.setStartDateTime(startDate);
            newRes.setEndDateTime(endDate);

            cottage.setChanging(!cottage.isChanging());
            cottageRepository.save(cottage);

            return newRes;
        }

        public void saveReservation(Reservation res){
            reservationRepository.save(res);
        }

        public boolean isPeriodReserved(Offer offer,LocalDateTime startDate,LocalDateTime endDate){

            for (Reservation reservation:reservationRepository.findByOffer_IdEquals(offer.getId())) {
                if((reservation.getStartDateTime().isBefore(startDate) && reservation.getEndDateTime().isAfter(endDate))
                || (reservation.getStartDateTime().isEqual(startDate) || reservation.getEndDateTime().isEqual(startDate))
                || (reservation.getStartDateTime().isEqual(endDate) || reservation.getEndDateTime().isEqual(endDate))){
                    return true;
                }
            }

            return false;
        }

}
