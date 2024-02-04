package com.example.dmdb.roles;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    public final RoleRepo repo;

    public RoleService(RoleRepo repo) {
        this.repo = repo;
    }

    public void save(Role role) {
        repo.save(role);
    }
}
