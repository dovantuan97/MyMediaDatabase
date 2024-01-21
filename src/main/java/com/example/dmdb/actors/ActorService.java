package com.example.dmdb.actors;

import com.example.dmdb.actors.Actor;
import com.example.dmdb.actors.ActorRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepo repo;

    public ActorService(ActorRepo repo) {
        this.repo = repo;
    }

    public void save(Actor actor) {
        actor.setImageSource(setImgSource(actor));
        repo.save(actor);
    }

    public Optional<Actor> findByName(String name) {
        return repo.findByName(name);
    }

    public String setImgSource(Actor actor) {
        return actor.getName().toLowerCase().replace(" ", "_");
    }

    public Optional<Actor> findById(Long actorId) {
        return repo.findById(actorId);
    }
}
