package com.example.dmdb.roles;

import com.example.dmdb.roles.Role;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RoleRepo extends ListCrudRepository<Role, Long> {
    Optional<Role> findByMediaId(Long id);
}
