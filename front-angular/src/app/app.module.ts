import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { UniversityComponent } from './components/university/university.component';
import { FoyerComponent } from './components/foyer/foyer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { StatistiqueComponent } from './components/statistique/statistique.component';
import { HomeFoyerComponent } from './components/home-foyer/home-foyer.component';
import { HomeFoyerCardComponent } from './components/home-foyer/home-foyer-card/home-foyer-card.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    UniversityComponent,
    FoyerComponent,
    StatistiqueComponent,
    HomeFoyerComponent,
    HomeFoyerCardComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
