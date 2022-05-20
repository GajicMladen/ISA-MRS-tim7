import { NgbDate } from "@ng-bootstrap/ng-bootstrap";

export class FreePeriodDTO {
    startDate: NgbDate;
    endDate : NgbDate;
    offerId: number;
    
}

export class FreePeriodSendDTO{
    startDate: string;
    endDate : string;
    offerId: number;
    
}

export class FreePeriodReciveDTO{
    startDate: number[];
    endDate : number[];
    offerId: number;
    
}