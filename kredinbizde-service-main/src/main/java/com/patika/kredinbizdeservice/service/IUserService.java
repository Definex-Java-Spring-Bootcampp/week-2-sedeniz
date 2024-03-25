package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.User;

import java.util.List;

public interface IUserService {
    User save(User user);

    List<User> getAll();

    User getByEmail(String email);

    User update(String email, User user);
}
