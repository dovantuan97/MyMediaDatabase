package com.example.dmdb.friendships;

import com.example.dmdb.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Friendship {

    @Id
    @GeneratedValue
    private Long id;
    private boolean approved;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;
}
