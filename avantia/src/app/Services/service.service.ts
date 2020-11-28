import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Person } from '../Model/Person';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) {}

  Url='http://localhost:8080/users';

  getUsers(){
    return this.http.get<Person[]>(this.Url+"/list");
  }
  createUsers(person:Person){
    return this.http.post<Person>(this.Url+"/create",person);
  }
  getUsersId(id:number){
    return this.http.get<Person>(this.Url+"/detail/"+id);
  }
  updateUsers(person:Person){
    return this.http.put<Person>(this.Url+"/update/"+person.id,person);
  }
  deleteUsers(person:Person){
    return this.http.delete<Person>(this.Url+"/delete/"+person.id);
  }
}
