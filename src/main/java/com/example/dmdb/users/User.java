package com.example.dmdb.users;

import com.example.dmdb.medias.Media;
import com.example.dmdb.mymedias.MyMedia;
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
    private List<MyMedia> myMedias;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
