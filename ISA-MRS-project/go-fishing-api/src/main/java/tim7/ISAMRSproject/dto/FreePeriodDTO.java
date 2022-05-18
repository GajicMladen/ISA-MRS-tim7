package tim7.ISAMRSproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import tim7.ISAMRSproject.model.FreePeriod;

import java.time.LocalDateTime;

public class FreePeriodDTO {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer offerId;

    public FreePeriodDTO() {

    }
    public FreePeriodDTO(FreePeriod x){
        this.startDate = x.getStartDateTime();
        this.endDate =x.getEndDateTime();
        this.offerId = x.getOffer().getId();
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
}
