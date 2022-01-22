package ru.job4j.forum.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.service.AuthorityService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityRepository authorityRepository;

    @Override
    public Collection<Authority> getAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority findByAuthority(String roleUser) {
        return authorityRepository.findByAuthority(roleUser);
    }

    @Override
    public void save(Authority authority) {
        authorityRepository.save(authority);
    }
}
