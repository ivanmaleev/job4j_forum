package ru.job4j.forum.service;

import ru.job4j.forum.model.Authority;

import java.util.*;

public interface AuthorityService {

    public Collection<Authority> getAll();

    public Authority findByAuthority(String roleUser);

    public void save(Authority authority);
}
