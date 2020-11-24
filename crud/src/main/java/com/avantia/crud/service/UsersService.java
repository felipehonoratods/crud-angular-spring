package com.avantia.crud.service;

import com.avantia.crud.entity.Users;
import com.avantia.crud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public List<Users> list() {
        return usersRepository.findAll();
    }

    public Optional<Users> getOne(int id) {
        return usersRepository.findById(id);
    }

    public Optional<Users> getByName(String name){
        return usersRepository.findByName(name);
    }

    public void save(Users users){
        usersRepository.save(users);
    }

    public void delete(int id){
        usersRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return usersRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return usersRepository.existsByName(name);
    }
}
