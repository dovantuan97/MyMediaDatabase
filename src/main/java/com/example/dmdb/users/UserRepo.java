package com.example.dmdb.users;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepo extends ListCrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
