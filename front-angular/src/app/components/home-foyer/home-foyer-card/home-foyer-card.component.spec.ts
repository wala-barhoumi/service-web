import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeFoyerCardComponent } from './home-foyer-card.component';

describe('HomeFoyerCardComponent', () => {
  let component: HomeFoyerCardComponent;
  let fixture: ComponentFixture<HomeFoyerCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomeFoyerCardComponent]
    });
    fixture = TestBed.createComponent(HomeFoyerCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
