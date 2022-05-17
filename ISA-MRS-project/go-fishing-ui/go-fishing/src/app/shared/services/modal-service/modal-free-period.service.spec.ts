import { TestBed } from '@angular/core/testing';

import { ModalFreePeriodService } from './modal-free-period.service';

describe('ModalFreePeriodService', () => {
  let service: ModalFreePeriodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModalFreePeriodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
