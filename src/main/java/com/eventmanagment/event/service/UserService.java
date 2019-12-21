package com.eventmanagment.event.service;

import com.eventmanagment.event.model.User;
import com.eventmanagment.event.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    /**
     *
     * @return
     */
    List<User> findAllUsers();

    /**
     *  To create new user
     *
     * @param user
     */
    void createUser(User user);

}
