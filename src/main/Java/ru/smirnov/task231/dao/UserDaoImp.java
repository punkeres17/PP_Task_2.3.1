package ru.smirnov.task231.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.smirnov.task231.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void removeUserById(final long id) {
        final User user = getUserById(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(final User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(final Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
