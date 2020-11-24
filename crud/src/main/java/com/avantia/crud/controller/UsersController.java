package com.avantia.crud.controller;

import com.avantia.crud.dto.Message;
import com.avantia.crud.dto.UsersDto;
import com.avantia.crud.entity.Users;
import com.avantia.crud.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/list")
    public ResponseEntity<List<Users>> list() {
        List<Users> list = usersService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Users> getById(@PathVariable("id") int id) {
        if (!usersService.existsById(id)) {
            return new ResponseEntity(new Message("Não existe!"), HttpStatus.NOT_FOUND);
        }
        Users users = usersService.getOne(id).get();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/detailname/{name}")
    public ResponseEntity<Users> getById(@PathVariable("name") String name) {
        if (!usersService.existsByName(name)) {
            return new ResponseEntity(new Message("Não existe!"), HttpStatus.NOT_FOUND);
        }
        Users users = usersService.getByName(name).get();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UsersDto usersDto) {
        if (StringUtils.isBlank(usersDto.getName())) {
            return new ResponseEntity(new Message("O Nome é Obrigatório"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(usersDto.getEmail())) {
            return new ResponseEntity(new Message("O Email é Obrigatório"), HttpStatus.BAD_REQUEST);
        }
        Users users = new Users(usersDto.getName(), usersDto.getLastname(), usersDto.getEmail(), usersDto.getPassword());
        usersService.save(users);
        return new ResponseEntity(new Message("Usuário cadastrado!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody UsersDto usersDto) {
        if (!usersService.existsById(id)) {
            return new ResponseEntity(new Message("Não existe!"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(usersDto.getName())) {
            return new ResponseEntity(new Message("O Nome é Obrigatório"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(usersDto.getEmail())) {
            return new ResponseEntity(new Message("O Email é Obrigatório"), HttpStatus.BAD_REQUEST);
        }
        Users users = usersService.getOne(id).get();
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setLastname(usersDto.getLastname());
        users.setPassword(usersDto.getPassword());
        usersService.save(users);
        return new ResponseEntity(new Message("Usuário atualizado!"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id) {
        if (!usersService.existsById(id)) {
            return new ResponseEntity(new Message("Não existe!"), HttpStatus.NOT_FOUND);
        }
        usersService.delete(id);
        return new ResponseEntity(new Message("Usuário deletado!"), HttpStatus.OK);
    }
}
