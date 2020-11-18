package com.avantia.backend.dao;

import com.avantia.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends CrudRepository<User, Integer> {
}
