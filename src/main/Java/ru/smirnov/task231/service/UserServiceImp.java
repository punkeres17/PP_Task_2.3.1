package ru.smirnov.task231.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.task231.dao.UserDao;
import ru.smirnov.task231.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void removeUserById(final long id) {
        userDao.removeUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(final User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(final Long id) {

        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }
}
