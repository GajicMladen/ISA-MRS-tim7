import { Offer } from './offer';

export interface Boat extends Offer {
  boatType: string;
  length: number;
  numOfEngines: number;
  powerOfEngines: number;
  maxSpeed: number;
  reservationCancellationTerms?: string;
}
