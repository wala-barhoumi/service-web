import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar-style',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent {
  constructor(
    private router : Router
  ){

  }
  goTo(path:any){
    const url = path
    console.log(path);
    
    this.router.navigateByUrl(url)

  }
}
