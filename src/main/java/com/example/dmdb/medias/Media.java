package com.example.dmdb.medias;

import com.example.dmdb.enums.CountryOfOrigin;
import com.example.dmdb.enums.Genre;
import com.example.dmdb.enums.MediaType;
import com.example.dmdb.mymedias.MyMedia;
import com.example.dmdb.roles.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer releaseYear;
    @ElementCollection(targetClass = CountryOfOrigin.class)
    @Enumerated(EnumType.STRING)
    private List<CountryOfOrigin> countriesOfOrigin = new ArrayList<>();
    private MediaType mediaType;
    @ElementCollection(targetClass = Genre.class)
    @Enumerated(EnumType.STRING)
    private List<Genre> genres = new ArrayList<>();
    private String synopsis;
    @OneToMany (mappedBy = "media", cascade = CascadeType.ALL)
    private List<Role> roles;
    private String imageSource;
    @OneToMany (mappedBy = "media", cascade = CascadeType.ALL)
    private List<MyMedia> myMedia;
}
