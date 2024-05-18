import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { UniversityService } from 'src/app/services/university.service';
class Universite {
  nomUniversite: any
  adresse: any
  idUniversite: any
  grouvenerat : any
}
@Component({
  selector: 'app-university',
  templateUrl: './university.component.html',
  styleUrls: ['./university.component.scss']
})
export class UniversityComponent implements OnInit {
  universite = new Universite()
  allUniversite: any
  isAdd = true
  idUniversityToDelete: any
  @ViewChild('closeButton') closeButton: any
  @ViewChild('closeButtonDelete') closeButtonDelete: any
  grouvenerats: any
  constructor(
    private universiteService: UniversityService , 
    private http : HttpClient
  ) { }

  ngOnInit(): void {
    this.getGouvernerat()
    this.get()
  }

  getGouvernerat(){
    this.universiteService.getAllGourvernerats().subscribe(res=>{
      this.grouvenerats = res
    })
  }

  get() {
    this.universiteService.getUniversite().subscribe(res => {
      console.log('get', res)
      this.allUniversite = res
    })
   
  }

  add() {
    console.log('add', this.universite)
    this.universiteService.add(this.universite).subscribe(res => {
      this.closeButton.nativeElement.click()
      this.get()
      this.universite = new Universite()
    })
  }

  edit(i: any) {
    this.isAdd = false
    this.universite = i
  }

  editAction() {
    this.universiteService.edit(this.universite).subscribe(res => {
      this.closeButton.nativeElement.click()
      this.universite = new Universite()
      this.get()
    })
  }

  delete(i: any) {
    this.idUniversityToDelete = i.idUniversite
    console.log(this.idUniversityToDelete)
  }

  deleteAction() {
    this.universiteService.delete(this.idUniversityToDelete).subscribe(res => {
      this.closeButtonDelete.nativeElement.click()
      this.get()
    })
  }
}
