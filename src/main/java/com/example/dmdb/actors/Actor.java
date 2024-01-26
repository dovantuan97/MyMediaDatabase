package com.example.dmdb.actors;

import com.example.dmdb.roles.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String imageSource;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "actor")
    private List<Role> roles;

    public Actor(String name) {
        this.name = name;
    }
}
