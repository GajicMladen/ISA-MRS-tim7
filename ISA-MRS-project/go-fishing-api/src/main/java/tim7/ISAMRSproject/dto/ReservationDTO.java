package tim7.ISAMRSproject.dto;

import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.model.ReservationStatus;

import java.time.LocalDateTime;

public class ReservationDTO {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer offerId;
    private Integer id;
    private Integer clietId;
    private float totalPrice;

    private ReservationStatus reservationStatus;

    private ReservationDTO(){

    }

    public ReservationDTO(Reservation reservation){
        this.endDate = reservation.getEndDateTime();
        this.startDate = reservation.getStartDateTime();
        this.totalPrice = reservation.getTotalPrice();
        this.offerId = reservation.getOffer().getId();
        this.id = reservation.getId();
        this.clietId = reservation.getClient().getId();
        this.reservationStatus = reservation.getStatus();
    }


    public ReservationDTO(LocalDateTime startDate, LocalDateTime endDate, Integer offerId, float totalPrice,Integer clientID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.offerId = offerId;
        this.totalPrice = totalPrice;
        this.clietId = clientID;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Integer getClietId() {
        return clietId;
    }

    public void setClietId(Integer clietId) {
        this.clietId = clietId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
