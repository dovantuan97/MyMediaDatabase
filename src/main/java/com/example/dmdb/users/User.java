package com.example.dmdb.users;

import com.example.dmdb.my_entries.MyEntry;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private List<MyEntry> myEntries;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
