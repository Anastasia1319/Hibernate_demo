package com.belhard.hibernate.dao.impl;

import com.belhard.hibernate.dao.UserDao;
import com.belhard.hibernate.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User find(Long key) {
        User user = entityManager.find(User.class, key);
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }
}
