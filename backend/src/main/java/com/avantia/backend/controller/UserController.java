package com.avantia.backend.controller;

import com.avantia.backend.model.User;
import com.avantia.backend.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/users"})
public class UserController {
    @Autowired
    IUserService service;

    @GetMapping
    public List<User> list() {
        return service.list();
    }

    @GetMapping(path = {"/{id}"})
    public User listId(@PathVariable("id") int id) {
        return service.listId(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return service.add(user);
    }

    @PutMapping(path = {"/{id}"})
    public User update(@RequestBody User user,@PathVariable("id") int id){
        user.setId(id);
        return service.edit(user);
    }
    @DeleteMapping(path = {"/{id}"})
    public User delete(@PathVariable("id") int  id){
        return service.delete(id);
    }
}
