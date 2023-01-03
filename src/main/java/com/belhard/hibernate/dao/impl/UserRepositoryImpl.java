package com.belhard.hibernate.dao.impl;

import com.belhard.hibernate.dao.UserDao;
import com.belhard.hibernate.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserDao {
    private final EntityManager entityManager;
    public static final String FIND_ALL ="from User";

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User find(Long key) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, key);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAll() {
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery(FIND_ALL, User.class).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    @Override
    public User create(User entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
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
