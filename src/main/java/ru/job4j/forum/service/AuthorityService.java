package ru.job4j.forum.service;

import ru.job4j.forum.model.Authority;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AuthorityService {
    private final Map<String, Authority> authorities = new HashMap<>();
    private static AtomicInteger counter = new AtomicInteger(1);

    public AuthorityService() {
        Authority authority1 = new Authority();
        authority1.setAuthority("ROLE_USER");
        save(authority1);
        Authority authority2 = new Authority();
        authority2.setAuthority("ROLE_ADMIN");
        save(authority2);
        authorities.put(authority2.getAuthority(), authority2);
    }

    public Collection<Authority> getAll() {
        return authorities.values();
    }

    public Authority findByAuthority(String roleUser) {
        return authorities.get(roleUser);
    }

    public void save(Authority authority) {
        if (authority.getId() == 0) {
            authority.setId(counter.getAndIncrement());
        }
        authorities.put(authority.getAuthority(), authority);
    }
}
