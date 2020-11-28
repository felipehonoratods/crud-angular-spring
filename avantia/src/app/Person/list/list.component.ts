import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Services/service.service';
import { Person } from '../../Model/Person';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  persons: Person[];
  constructor(private router: Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.service.getUsers()
      .subscribe(data => {
        this.persons = data;
      });
  }

  Edit(person:Person):void{
    localStorage.setItem("id",person.id.toString());
    this.router.navigate(["edit"]);
  }

  Delete(person:Person){
    this.service.deleteUsers(person)
    .subscribe(data=>{
      this.persons=this.persons.filter(p=>p!==person);
      alert("Usuario deletado...");
    })
  }

}
