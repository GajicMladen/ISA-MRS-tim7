import { NgbDate } from "@ng-bootstrap/ng-bootstrap";

export enum ReservationStatus{
    
	ON_WAIT,
	ACTIVE,
	IN_PROCESS,
	ENDED,
	CANCELED,
	FOR_ACTION
}

export class Reservation{
    offerId: number;
    startDate: NgbDate;
    endDate: NgbDate;
    totalPrice: number;
    reservationStatus:ReservationStatus;
    //add more reservation atributes
}

export class ActionDTO{
    id:number;
    offerId: number;
    startDate: NgbDate;
    endDate: NgbDate;
    totalPrice: number;
    reservationStatus:ReservationStatus;
}
export class ActionSendDTO{
    
    offerId: number;
    startDate: string;
    endDate: string;
    totalPrice: number;
}


export class ActionReciveDTO{
    
    id:number;
    offerId: number;
    startDate: number[];
    endDate: number[];
    totalPrice: number;
}