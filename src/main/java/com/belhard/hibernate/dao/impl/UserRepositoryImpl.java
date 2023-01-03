package com.belhard.hibernate.dao.impl;

import com.belhard.hibernate.dao.UserRepository;
import com.belhard.hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
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
    public void save(User entity) {
        entityManager.getTransaction().begin();
        if (entity.getId() != null) {
            entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
        }
        entityManager.getTransaction().commit();
    }

//    @Override
//    public User create(User entity) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(entity);
//        entityManager.getTransaction().commit();
//        return entity;
//    }
//
//    @Override
//    public User update(User entity) {
//        entityManager.getTransaction().begin();
//        entityManager.merge(entity);
//        entityManager.getTransaction().commit();
//        return entity;
//    }

//    @Override
//    public boolean delete(Long key) {
//        boolean deletedResult = false;
//        entityManager.getTransaction().begin();
//        User user = entityManager.find(User.class, key);
//        if (user != null) {
//            entityManager.remove(user);
//            deletedResult = true;
//        }
//        entityManager.getTransaction().commit();
//        return deletedResult;
//    }

    @Override
    public boolean delete(Long key) {
        boolean deletedResult = false;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from User where id = :id");
        query.setParameter("id", key);
        int result = query.executeUpdate();
        entityManager.getTransaction().commit();
        return result == 1;
    }
}
