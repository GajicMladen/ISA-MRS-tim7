import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletionRequestDialogComponent } from './deletion-request-dialog.component';

describe('DeletionRequestDialogComponent', () => {
  let component: DeletionRequestDialogComponent;
  let fixture: ComponentFixture<DeletionRequestDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletionRequestDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletionRequestDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
