import { Offer } from './offer';

export interface Cottage extends Offer {

    ownerId:number;
    roomCount: number;
    bedCount:number;

}
