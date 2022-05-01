import { Service } from './service';

export interface Boat extends Service {
  boatType: string;
  length: number;
  numOfEngines: number;
  powerOfEngines: number;
  maxSpeed: number;
  reservationCancellationTerms?: string;
}
