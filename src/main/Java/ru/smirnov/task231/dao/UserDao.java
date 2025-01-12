package ru.smirnov.task231.dao;

import ru.smirnov.task231.model.User;

import java.util.List;


public interface UserDao {
    void removeUserById(long id);

    void updateUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
