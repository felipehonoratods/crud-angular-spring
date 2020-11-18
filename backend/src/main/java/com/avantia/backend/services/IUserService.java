package com.avantia.backend.services;

import com.avantia.backend.model.User;

import java.util.List;

public interface IUserService {
    public List<User> list();

    User listId(int id);

    User add(User user);

    User edit(User user);

    User delete(int id);
}
