import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Services/service.service';
import { Person } from '../../Model/Person';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  person:Person = new Person();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
  }

  Save(){
    this.service.createUsers(this.person)
    .subscribe(data=>{
      alert("Cadastrado com sucesso...!!!");
      this.router.navigate(["list"]);
    })
  }

}
