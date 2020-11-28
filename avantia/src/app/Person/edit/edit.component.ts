import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Services/service.service';
import { Person } from '../../Model/Person';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  person:Person = new Person();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.Edit();
  }

  Edit(){
    let id=localStorage.getItem("id");
    this.service.getUsersId(+id)
    .subscribe(data=>{
      this.person=data;
    })
  }
  Update(person:Person){
    this.service.updateUsers(person)
    .subscribe(data=>{
      this.person=data;
      alert("Usuário foi atualizado com sucesso...!!!");
      this.router.navigate(["list"]);
    })
  }

}
