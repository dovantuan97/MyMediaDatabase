package com.example.dmdb.actors;

import com.example.dmdb.actors.Actor;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ActorRepo extends ListCrudRepository<Actor, Long> {
    Optional<Actor> findByName(String name);
}
