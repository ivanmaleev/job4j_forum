package ru.job4j.forum.service;

import ru.job4j.forum.model.User;

import java.util.Collection;

public interface UserService {

    public Collection<User> getAll();

    public User findByUsername(String username);

    public void save(User user);
}
