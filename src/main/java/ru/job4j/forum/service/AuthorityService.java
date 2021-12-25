package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.AuthorityRepository;

import java.util.*;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Collection<Authority> getAll() {
        return authorityRepository.findAll();
    }

    public Authority findByAuthority(String roleUser) {
        return authorityRepository.findByAuthority(roleUser);
    }

    public void save(Authority authority) {
        authorityRepository.save(authority);
    }
}
