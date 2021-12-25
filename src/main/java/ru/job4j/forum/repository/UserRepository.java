package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    @Override
    Collection<User> findAll();
}
