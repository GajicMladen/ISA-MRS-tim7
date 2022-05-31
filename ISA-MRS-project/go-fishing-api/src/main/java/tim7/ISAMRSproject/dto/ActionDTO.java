package tim7.ISAMRSproject.dto;

import tim7.ISAMRSproject.model.Reservation;

import java.time.LocalDateTime;

public class ActionDTO {


    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer offerId;
    private Integer id;
    private float totalPrice;

    private ActionDTO(){

    }

    public ActionDTO(Reservation reservation){
        this.endDate = reservation.getEndDateTime();
        this.startDate = reservation.getStartDateTime();
        this.totalPrice = reservation.getTotalPrice();
        this.offerId = reservation.getOffer().getId();
        this.id = reservation.getId();
    }


    public ActionDTO(LocalDateTime startDate, LocalDateTime endDate, Integer offerId, float totalPrice) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.offerId = offerId;
        this.totalPrice = totalPrice;
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
