package com.example.dmdb.friendships;

import org.springframework.stereotype.Service;

@Service
public class FriendshipService {

    private final FriendshipRepo repo;

    public FriendshipService(FriendshipRepo repo) {
        this.repo = repo;
    }


}
