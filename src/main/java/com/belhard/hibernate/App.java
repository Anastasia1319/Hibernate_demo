package com.belhard.hibernate;

import com.belhard.hibernate.dao.UserRepository;
import com.belhard.hibernate.dao.impl.UserRepositoryImpl;
import com.belhard.hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    private static EntityManagerFactory factory;
    private static UserRepository userRepository;
    public static void main(String[] args) {
        factory = null;
        User user = new User();
        user.setFirstName("Jon");
        user.setLastName("Wonk");
        user.setCity("London");
        user.setEmail("jon@gmail.com");
        user.setPassword("123456789");
        try {
            factory = Persistence.createEntityManagerFactory("remote");
            EntityManager entityManager = factory.createEntityManager();
            userRepository = new UserRepositoryImpl(entityManager);

            // find
//            User foundUser = userRepository.find(3L);
//            System.out.println("Found user: " + foundUser);

            //save
            userRepository.save(user);

            //findAll
//            List<User> users = userRepository.findAll();
//            System.out.println(users);

            //delete
//            boolean deleted = userRepository.delete(12L);
//            System.out.println("Deleted: " + deleted);

        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
