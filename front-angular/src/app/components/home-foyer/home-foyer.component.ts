import { Component } from '@angular/core';
import { FoyerService } from 'src/app/services/foyer.service';

@Component({
  selector: 'app-home-foyer',
  templateUrl: './home-foyer.component.html',
  styleUrls: ['./home-foyer.component.scss']
})
export class HomeFoyerComponent {
  allFoyer : any
  constructor(private foyerService: FoyerService,){}

  ngOnInit(): void {
    this.get()
  }


  get() {
    this.foyerService.get().subscribe(res => {
      console.log('get', res)
      this.allFoyer = res
    })
  }

}
