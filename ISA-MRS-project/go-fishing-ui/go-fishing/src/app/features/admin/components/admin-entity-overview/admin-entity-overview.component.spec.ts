import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEntityOverviewComponent } from './admin-entity-overview.component';

describe('AdminEntityOverviewComponent', () => {
  let component: AdminEntityOverviewComponent;
  let fixture: ComponentFixture<AdminEntityOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminEntityOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminEntityOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
