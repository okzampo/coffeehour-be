package com.okzampo.coffehour.service;

import java.util.List;

import com.okzampo.coffehour.entity.User;

public interface UserService {
    public User createUser(User user);
    public User editUser(String id, User user);
    public User deleteUser(String id);
    public User getUser(String id);
    public List<User> getAllUsers();
}
