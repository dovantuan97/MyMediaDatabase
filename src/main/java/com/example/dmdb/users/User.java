package com.example.dmdb.users;

import com.example.dmdb.medias.Media;
import com.example.dmdb.my_entries.MyEntry;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private LocalDate createdAt;
    @OneToOne
    private Media favouriteMovie;
    @OneToOne
    private Media favouriteSeries;
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private List<MyEntry> myEntries;

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public User() {
        this.createdAt = LocalDate.now();
    }
}
