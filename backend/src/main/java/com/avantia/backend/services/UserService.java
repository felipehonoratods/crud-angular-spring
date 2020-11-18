package com.avantia.backend.services;

import com.avantia.backend.dao.IUser;
import com.avantia.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUser repository;

    @Override
    public List<User> list() {
        return (List<User>)repository.findAll();
    }

    @Override
    public User listId(int id) {
        return null;
    }

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public User delete(int id) {
        return null;
    }
}
