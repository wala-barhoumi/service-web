import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-home-foyer-card',
  templateUrl: './home-foyer-card.component.html',
  styleUrls: ['./home-foyer-card.component.scss']
})
export class HomeFoyerCardComponent {
  @Input() childInput: any;

}
