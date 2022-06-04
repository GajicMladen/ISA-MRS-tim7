import { NgbDate } from "@ng-bootstrap/ng-bootstrap";

export enum ReservationStatus{
    
	ON_WAIT,
	ACTIVE,
	IN_PROCESS,
	ENDED,
	CANCELED,
	FOR_ACTION
}

export class ReservationDTO{
    id:number;
    offerId: number;
    startDate: NgbDate;
    endDate: NgbDate;
    totalPrice: number;
    reservationStatus:ReservationStatus;
    clientId: number;
    //add more reservation atributes
    
    getStartDateString():string {
        return this.startDate.day +"."+ this.startDate.month+"."+this.startDate.year;
    }
    getEndDateString():string {
        return this.endDate.day +"."+ this.endDate.month+"."+this.endDate.year;
    }

    getReservationStatusString():string{
        console.log(this.reservationStatus);
        switch (this.reservationStatus){
            case ReservationStatus.ON_WAIT:{
                return "Na čekanju";
            }
            case ReservationStatus.ACTIVE:{
                return "Aktivna";
            }
            case ReservationStatus.CANCELED:{
                return "Otkazana";
            }
            case ReservationStatus.IN_PROCESS:{
                return "U procesu";
            }
            case ReservationStatus.ENDED:{
                return "Završena";
            }
            case ReservationStatus.FOR_ACTION:{
                return "Za akciju";
            }
        } 
    }

}

export class ReservationSendDTO{
    offerId: number;
    startDate: string;
    endDate: string;
    totalPrice: number;
    reservationStatus:ReservationStatus;
    clientId: number;
    //add more reservation atributes
    
}
export class ReservationReciveDTO{
    id:number;
    offerId: number;
    startDate: number[];
    endDate: number[];
    totalPrice: number;
    reservationStatus:ReservationStatus;
    clientId: number;
    //add more reservation atributes
    
}

export class ActionDTO{
    id:number;
    offerId: number;
    startDate: NgbDate;
    endDate: NgbDate;
    totalPrice: number;

    getStartDateString():string {
        return this.startDate.day +"."+ this.startDate.month+"."+this.startDate.year;
    }
    getEndDateString():string {
        return this.endDate.day +"."+ this.endDate.month+"."+this.endDate.year;
    }
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