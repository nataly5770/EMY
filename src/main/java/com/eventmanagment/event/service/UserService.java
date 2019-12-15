package com.eventmanagment.event.service;

import com.eventmanagment.event.model.User;

import java.util.List;

public interface UserService {

    /**
     *
     * @return
     */
    List<User> findAllUsers();
}
