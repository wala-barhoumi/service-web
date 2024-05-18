import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UniversityComponent } from './components/university/university.component';
import { FoyerComponent } from './components/foyer/foyer.component';
import { StatistiqueComponent } from './components/statistique/statistique.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { HomeFoyerComponent } from './components/home-foyer/home-foyer.component';

const routes: Routes = [
  {
    path: '',
    component: SidebarComponent,
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', component: HomeFoyerComponent },
      { path: 'university', component: UniversityComponent },
      { path: 'foyer', component: FoyerComponent },
      { path: 'statistique', component: StatistiqueComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
