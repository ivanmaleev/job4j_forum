package ru.job4j.forum.service;

import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {

    private static AtomicInteger counter = new AtomicInteger(1);

    private final Map<String, User> users = new HashMap<>();
    private AuthorityService authorityService = new AuthorityService();

    public UserService() {
        User user = new User();
        user.setEnabled(true);
        user.setUsername("root");
        user.setPassword("123456");
        user.setAuthority(authorityService.findByAuthority("ROLE_ADMIN"));
        save(user);
        users.put(user.getUsername(), user);
    }

    public Collection<User> getAll() {
        return users.values();
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(counter.getAndIncrement());
        }
        users.put(user.getUsername(), user);
    }
}
