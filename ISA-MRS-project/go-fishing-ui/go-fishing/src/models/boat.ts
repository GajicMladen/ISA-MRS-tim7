import { Offer } from './offer';

export interface Boat extends Offer {
  ownerId:number;
  boatType: string;
  length: number;
  numOfEngines: number;
  powerOfEngines: number;
  maxSpeed: number;
  reservationCancellationTerms?: string;
}
