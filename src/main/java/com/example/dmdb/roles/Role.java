package com.example.dmdb.roles;

import com.example.dmdb.actors.Actor;
import com.example.dmdb.enums.RoleType;
import com.example.dmdb.medias.Media;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "cast")
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private String characterName;
    private RoleType roleType;
    @ManyToOne
    private Actor actor;
    @ManyToOne
    private Media media;
}
