package com.api.employee.dao;

import java.util.Optional;

import com.api.employee.Entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    Optional<User> findByuserName(String userName);
}
